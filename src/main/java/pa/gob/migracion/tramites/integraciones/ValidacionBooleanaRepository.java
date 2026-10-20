package pa.gob.migracion.tramites.integraciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidacionBooleanaRepository extends JpaRepository<ValidacionBooleana, Long> {

    List<ValidacionBooleana> findByExpedienteId(Long expedienteId);

    List<ValidacionBooleana> findByExpedienteIdAndRespuestaBooleana(Long expedienteId, Boolean respuestaBooleana);

    List<ValidacionBooleana> findByExpedienteIdAndResultado(Long expedienteId, String resultado);
}
