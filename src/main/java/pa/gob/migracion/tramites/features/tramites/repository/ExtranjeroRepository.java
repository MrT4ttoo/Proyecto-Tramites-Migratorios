package pa.gob.migracion.tramites.features.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.gob.migracion.tramites.features.tramites.dto.Extranjero;

import java.util.Optional;

@Repository
public interface ExtranjeroRepository extends JpaRepository<Extranjero, String> {
    Optional<Extranjero> findByUsuario_Correo(String correo);
    Optional<Extranjero> findByUsuario_Id(Integer usuarioId);
}
