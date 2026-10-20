package pa.gob.migracion.tramites.features.expediente.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import pa.gob.migracion.tramites.features.expediente.dto.ExpedienteRuex;
import pa.gob.migracion.tramites.features.tramites.dto.Extranjero;
import pa.gob.migracion.tramites.shared.model.Rol;
import pa.gob.migracion.tramites.features.tramites.dto.Usuario;
import pa.gob.migracion.tramites.integraciones.ValidacionBooleana;
import pa.gob.migracion.tramites.integraciones.ValidacionBooleanaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Pruebas de Persistencia para ExpedienteRuexRepository y ValidacionBooleanaRepository.
 * Cumplimiento de HU-06 (Persistencia Relacional) y Ley 81 de Protección de Datos Personales.
 */
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class ExpedienteRuexRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ExpedienteRuexRepository expedienteRepository;

    @Autowired
    private ValidacionBooleanaRepository validacionRepository;

    private Usuario usuarioPrueba;
    private Extranjero extranjeroPrueba;

    @BeforeEach
    void setUp() {
        // Rol: constructor (Short id, String nombre)
        Rol rol = new Rol((short) 1, "SOLICITANTE");
        entityManager.persist(rol);

        // Usuario: constructor (String correo, String passwordHash, Rol rol)
        usuarioPrueba = new Usuario("solicitante@migracion.pa", "ClaveSegura123!", rol);
        entityManager.persist(usuarioPrueba);

        // Extranjero: PK es ruex (String); constructor completo requerido
        extranjeroPrueba = new Extranjero(
                "EXP-2026-PA-001",
                usuarioPrueba,
                "Juan",
                "Lopez",
                LocalDate.of(1990, 6, 15),
                "PA123456"
        );
        entityManager.persist(extranjeroPrueba);

        // ExpedienteRuex: usar no-arg + setters para control de estadoId
        ExpedienteRuex expediente = new ExpedienteRuex();
        expediente.setExtranjero(extranjeroPrueba);
        expediente.setCategoriaId((short) 1);   // categoría VISA_PAIS_AMIGO
        expediente.setEstadoId((short) 1);       // 1 = Borrador
        entityManager.persist(expediente);
        entityManager.flush();
    }

    @Test
    @DisplayName("Persistencia: Debe buscar expediente por ruex del extranjero de forma exitosa")
    void testBuscarPorRuexExtranjero() {
        Optional<ExpedienteRuex> optExp = expedienteRepository.findByExtranjero_Ruex("EXP-2026-PA-001");
        assertThat(optExp).isPresent();
        assertThat(optExp.get().getCategoriaId()).isEqualTo((short) 1);
        assertThat(optExp.get().getEstado()).isEqualTo("Borrador");
    }

    @Test
    @DisplayName("Persistencia: Debe consultar expedientes asociados a un extranjero")
    void testBuscarPorExtranjeroRuex() {
        List<ExpedienteRuex> expedientes = expedienteRepository.findAllByExtranjero_Ruex("EXP-2026-PA-001");
        assertThat(expedientes).isNotEmpty();
        assertThat(expedientes.get(0).getExtranjero().getRuex()).isEqualTo("EXP-2026-PA-001");
    }

    @Test
    @DisplayName("Ley 81 (Minimización): Persistir verificación externa solo con estado booleano")
    void testPersistirValidacionBooleanaLey81() {
        Optional<ExpedienteRuex> optExp = expedienteRepository.findByExtranjero_Ruex("EXP-2026-PA-001");
        assertThat(optExp).isPresent();

        // ValidacionBooleana: constructor (Long expedienteId, Integer requisitoId, Short servicioId,
        //                                  String resultado, Boolean respuestaBooleana, byte[] parametrosHash)
        ValidacionBooleana validacion = new ValidacionBooleana(
                optExp.get().getId(),
                101,            // requisito_id
                (short) 1,      // servicio_id (Tribunal Electoral)
                "EXITOSA",      // resultado
                true,           // respuesta_booleana: COINCIDE (sin exponer datos sensibles)
                null            // parametros_hash (opcional en prueba)
        );
        entityManager.persist(validacion);
        entityManager.flush();

        List<ValidacionBooleana> validaciones = validacionRepository.findByExpedienteId(optExp.get().getId());
        assertThat(validaciones).hasSize(1);
        assertThat(validaciones.get(0).getRespuestaBooleana()).isTrue();
        assertThat(validaciones.get(0).getResultado()).isEqualTo("EXITOSA");
    }
}
