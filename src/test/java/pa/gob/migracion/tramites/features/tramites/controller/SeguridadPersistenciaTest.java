package pa.gob.migracion.tramites.features.tramites.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pruebas de Seguridad DevSecOps (DAST simulado) para endpoints de Persistencia.
 * Cumplimiento de HU-09: Verificación de inmunidad a inyecciones SQL en la API REST conectada a JPA.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class SeguridadPersistenciaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest(name = "Vector SQLMap DAST: {0}")
    @ValueSource(strings = {
            "' OR '1'='1",
            "admin@migracion.pa' OR 1=1 --",
            "\" OR \"1\"=\"1",
            "' UNION SELECT null, null, null, null --",
            "admin@migracion.pa' AND 1=0 UNION ALL SELECT 1, 'hacked', 3, 4 --",
            "admin@migracion.pa'; SELECT pg_sleep(5); --",
            "admin' OR EXISTS(SELECT * FROM seg.usuario WHERE activo=true) --"
    })
    @DisplayName("DAST (HU-09): Intento de SQLi en /api/login debe ser rechazado con 401 y sin fuga de trazas")
    void testSqlInjectionEnLogin(String injectionPayload) throws Exception {
        Map<String, String> credenciales = Map.of(
                "email", injectionPayload,
                "password", "123"
        );

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(credenciales)))
                .andExpect(status().isUnauthorized())
                // Verificación de cero fuga de información técnica de la BD (CWE-209 / OWASP A03)
                .andExpect(jsonPath("$.error").value("Correo o contrasena incorrectos"))
                .andExpect(jsonPath("$.error", not(containsString("SQL"))))
                .andExpect(jsonPath("$.error", not(containsString("PostgreSQL"))))
                .andExpect(jsonPath("$.error", not(containsString("syntax error"))));
    }

    @Test
    @DisplayName("Acceso No Autorizado: /api/expediente sin token debe responder 401")
    void testExpedienteSinToken() throws Exception {
        mockMvc.perform(get("/api/expediente"))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error").value("No autenticado"));
    }

    @Test
    @DisplayName("Inyección en Encabezado Authorization: Vector malicioso no debe provocar fuga de memoria ni SQLi")
    void testTokenConInyeccionSql() throws Exception {
        String tokenMalicioso = "Bearer ' OR 1=1 --";
        mockMvc.perform(get("/api/expediente")
                        .header("Authorization", tokenMalicioso))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error").value("No autenticado"));
    }
}
