package pa.gob.migracion.tramites.features.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.gob.migracion.tramites.features.tramites.dto.Documento;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    List<Documento> findByRuex(String ruex);

    List<Documento> findByRuexAndEstado(String ruex, String estado);

    Optional<Documento> findByRuexAndNombre(String ruex, String nombre);
}
