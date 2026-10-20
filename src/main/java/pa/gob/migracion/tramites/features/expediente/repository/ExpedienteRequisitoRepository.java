package pa.gob.migracion.tramites.features.expediente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.gob.migracion.tramites.features.expediente.dto.ExpedienteRequisito;
import pa.gob.migracion.tramites.features.expediente.dto.ExpedienteRequisitoId;

import java.util.List;

@Repository
public interface ExpedienteRequisitoRepository extends JpaRepository<ExpedienteRequisito, ExpedienteRequisitoId> {
    List<ExpedienteRequisito> findByExpediente_Id(Long expedienteId);
}
