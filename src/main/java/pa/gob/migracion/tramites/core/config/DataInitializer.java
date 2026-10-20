package pa.gob.migracion.tramites.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pa.gob.migracion.tramites.features.auditoria.dto.Consentimiento;
import pa.gob.migracion.tramites.features.auditoria.repository.ConsentimientoRepository;
import pa.gob.migracion.tramites.features.expediente.dto.ExpedienteRuex;
import pa.gob.migracion.tramites.features.expediente.repository.ExpedienteRuexRepository;
import pa.gob.migracion.tramites.features.tramites.dto.Extranjero;
import pa.gob.migracion.tramites.features.tramites.dto.Usuario;
import pa.gob.migracion.tramites.features.tramites.repository.ExtranjeroRepository;
import pa.gob.migracion.tramites.features.tramites.repository.UsuarioRepository;
import pa.gob.migracion.tramites.shared.model.Rol;
import pa.gob.migracion.tramites.shared.model.RolRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final ExtranjeroRepository extranjeroRepository;
    private final ExpedienteRuexRepository expedienteRepository;
    private final ConsentimientoRepository consentimientoRepository;

    public DataInitializer(UsuarioRepository usuarioRepository,
                           RolRepository rolRepository,
                           ExtranjeroRepository extranjeroRepository,
                           ExpedienteRuexRepository expedienteRepository,
                           ConsentimientoRepository consentimientoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.extranjeroRepository = extranjeroRepository;
        this.expedienteRepository = expedienteRepository;
        this.consentimientoRepository = consentimientoRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        log.info("Verificando persistencia y datos relacionales en PostgreSQL (BD_Tramites.sql)...");

        try {
            boolean userExists = usuarioRepository.existsByCorreo("usuario@migracion.pa");
            if (userExists) {
                log.info("Capa de persistencia relacional PostgreSQL activa y sincronizada con BD_Tramites.sql.");
            } else {
                log.info("Inicializando datos semilla en caso de ejecución sobre base de datos vacía...");
                Rol rolSolicitante = rolRepository.findByNombre("SOLICITANTE")
                        .orElseGet(() -> rolRepository.save(new Rol((short) 1, "SOLICITANTE")));
                Rol rolAdmin = rolRepository.findByNombre("ADMINISTRADOR")
                        .orElseGet(() -> rolRepository.save(new Rol((short) 3, "ADMINISTRADOR")));

                Usuario u1 = usuarioRepository.save(new Usuario("usuario@migracion.pa", "$2a$10$wN9i0iH7y79a2X0.00N9ze5Vl3t1hG3Y0b7Xz7e9K9qZ7gX9yq00O", rolSolicitante));
                usuarioRepository.save(new Usuario("qa@migracion.pa", "$2a$10$wN9i0iH7y79a2X0.00N9ze5Vl3t1hG3Y0b7Xz7e9K9qZ7gX9yq00O", rolSolicitante));
                usuarioRepository.save(new Usuario("admin@migracion.pa", "$2a$10$wN9i0iH7y79a2X0.00N9ze5Vl3t1hG3Y0b7Xz7e9K9qZ7gX9yq00O", rolAdmin));

                Extranjero ext = extranjeroRepository.save(new Extranjero("RUEX-2026-0001", u1, "Carlos", "Mendoza", LocalDate.of(1985, 6, 15), "PAS-COL-2026"));
                consentimientoRepository.save(new Consentimiento("RUEX-2026-0001", 1, true, "127.0.0.1"));
                expedienteRepository.save(new ExpedienteRuex(ext, (short) 1));
                log.info("Datos iniciales sembrados con éxito.");
            }
        } catch (Exception ex) {
            log.warn("Verificación de base de datos finalizada: {}", ex.getMessage());
        }
    }

    public static String sha256Hex(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            return "0000000000000000000000000000000000000000000000000000000000000000";
        }
    }

    public static byte[] sha256Bytes(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            return new byte[32];
        }
    }
}
