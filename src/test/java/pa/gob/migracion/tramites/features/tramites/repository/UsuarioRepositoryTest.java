package pa.gob.migracion.tramites.features.tramites.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import pa.gob.migracion.tramites.shared.model.Rol;
import pa.gob.migracion.tramites.features.tramites.dto.Usuario;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Pruebas Unitarias DevSecOps para UsuarioRepository.
 * Cumplimiento de HU-07: Inmunidad nativa contra Inyección SQL mediante consultas parametrizadas.
 */
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class UsuarioRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Rol rolSolicitante;

    @BeforeEach
    void setUp() {
        rolSolicitante = new Rol((short) 1, "SOLICITANTE");
        entityManager.persist(rolSolicitante);

        Usuario usuario = new Usuario("usuario@migracion.pa", "Pa2026!", rolSolicitante);
        entityManager.persist(usuario);
        entityManager.flush();
    }

    @Test
    @DisplayName("Persistencia: Debe buscar usuario por correo de forma exitosa")
    void testBuscarPorCorreoValido() {
        Optional<Usuario> resultado = usuarioRepository.findByCorreoParametrizado("usuario@migracion.pa");
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getCorreo()).isEqualTo("usuario@migracion.pa");
        assertThat(resultado.get().getRol().getNombre()).isEqualTo("SOLICITANTE");
    }

    @ParameterizedTest(name = "Inyección SQL Payloads DAST: {0}")
    @ValueSource(strings = {
            "' OR '1'='1",
            "admin@migracion.pa' OR 1=1 --",
            "usuario@migracion.pa' AND 1=0 UNION SELECT NULL, 'injected', NULL, NULL --",
            "' UNION SELECT * FROM seg.usuario --",
            "usuario@migracion.pa'; DROP TABLE seg.usuario; --",
            "admin' /*!50000OR*/ 1=1 --",
            "' OR '' = '",
            "admin@migracion.pa' AND (SELECT 1 FROM (SELECT(SLEEP(2)))a)--"
    })
    @DisplayName("DevSecOps (HU-07): Inmunidad SQLi - Los payloads maliciosos no deben hacer bypass ni provocar errores de sintaxis")
    void testInmunidadInyeccionSql(String maliciousPayload) {
        assertDoesNotThrow(() -> {
            Optional<Usuario> resultado = usuarioRepository.findByCorreoParametrizado(maliciousPayload);
            // El parámetro :correo viaja parametrizado en el PreparedStatement; no debe hacer bypass
            assertThat(resultado).isEmpty();
        }, "El motor JPA debe tratar el payload estrictamente como un literal de texto sin ejecutar comandos SQL");
    }

    @Test
    @DisplayName("Control de Acceso: No debe retornar usuarios inactivos")
    void testUsuarioInactivoNoRetorna() {
        Usuario inactivo = new Usuario("inactivo@migracion.pa", "Pass123!", rolSolicitante);
        inactivo.setActivo(false);
        entityManager.persist(inactivo);
        entityManager.flush();

        Optional<Usuario> resultado = usuarioRepository.findByCorreoParametrizado("inactivo@migracion.pa");
        assertThat(resultado).isEmpty();
    }
}
