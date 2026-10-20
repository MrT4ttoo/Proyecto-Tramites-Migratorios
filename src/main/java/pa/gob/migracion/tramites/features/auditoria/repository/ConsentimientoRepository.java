package pa.gob.migracion.tramites.features.auditoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pa.gob.migracion.tramites.features.auditoria.dto.Consentimiento;

import java.util.Optional;

@Repository
public interface ConsentimientoRepository extends JpaRepository<Consentimiento, Long> {
    Optional<Consentimiento> findTopByRuexOrderByFechaHoraDesc(String ruex);
}
