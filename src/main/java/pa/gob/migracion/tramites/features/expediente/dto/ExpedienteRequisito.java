package pa.gob.migracion.tramites.features.expediente.dto;

import jakarta.persistence.*;
import pa.gob.migracion.tramites.features.tramites.dto.Documento;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de persistencia para los requisitos asociados a un expediente migratorio.
 * Mapeada al esquema snm.ExpedienteRequisito de BD_Tramites.sql.
 */
@Entity
@Table(name = "expedienterequisito", schema = "snm")
public class ExpedienteRequisito {

    @EmbeddedId
    private ExpedienteRequisitoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("expedienteId")
    @JoinColumn(name = "expediente_id")
    private ExpedienteRuex expediente;

    @Column(name = "estado", nullable = false, length = 25)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "documento_id")
    private Documento documento;

    @Column(name = "origen_documento", length = 12)
    private String origenDocumento;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn = LocalDateTime.now();

    public ExpedienteRequisito() {
    }

    public ExpedienteRequisito(ExpedienteRuex expediente, Integer requisitoId, String estado) {
        this.id = new ExpedienteRequisitoId(expediente != null ? expediente.getId() : null, requisitoId);
        this.expediente = expediente;
        this.estado = estado;
        this.actualizadoEn = LocalDateTime.now();
    }

    public ExpedienteRequisitoId getId() {
        return id;
    }

    public void setId(ExpedienteRequisitoId id) {
        this.id = id;
    }

    public ExpedienteRuex getExpediente() {
        return expediente;
    }

    public void setExpediente(ExpedienteRuex expediente) {
        this.expediente = expediente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getOrigenDocumento() {
        return origenDocumento;
    }

    public void setOrigenDocumento(String origenDocumento) {
        this.origenDocumento = origenDocumento;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpedienteRequisito)) return false;
        ExpedienteRequisito that = (ExpedienteRequisito) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
