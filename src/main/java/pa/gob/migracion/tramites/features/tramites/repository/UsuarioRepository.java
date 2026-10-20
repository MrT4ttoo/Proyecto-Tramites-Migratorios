package pa.gob.migracion.tramites.features.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pa.gob.migracion.tramites.features.tramites.dto.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     * Búsqueda por correo electrónico.
     * Al usar Spring Data JPA o consultas JPQL parametrizadas, el parámetro :correo
     * se compila internamente con PreparedStatement (consultas parametrizadas),
     * garantizando inmunidad nativa frente a Inyección SQL (HU-07 / SQLMap).
     */
    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo AND u.activo = true")
    Optional<Usuario> findByCorreoParametrizado(@Param("correo") String correo);

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);
}
