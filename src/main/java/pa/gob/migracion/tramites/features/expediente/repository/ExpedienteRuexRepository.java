package pa.gob.migracion.tramites.features.expediente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pa.gob.migracion.tramites.features.expediente.dto.ExpedienteRuex;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpedienteRuexRepository extends JpaRepository<ExpedienteRuex, Long> {

    Optional<ExpedienteRuex> findByExtranjero_Ruex(String ruex);

    List<ExpedienteRuex> findAllByExtranjero_Ruex(String ruex);

    @Query("SELECT e FROM ExpedienteRuex e JOIN e.extranjero x JOIN x.usuario u WHERE u.correo = :correo")
    Optional<ExpedienteRuex> findByUsuarioCorreoWithFetch(@Param("correo") String correo);

    Optional<ExpedienteRuex> findByExtranjero_Usuario_Correo(String correo);

    Optional<ExpedienteRuex> findByExtranjero_Usuario_Id(Integer usuarioId);

    List<ExpedienteRuex> findByEstadoId(Short estadoId);
}
