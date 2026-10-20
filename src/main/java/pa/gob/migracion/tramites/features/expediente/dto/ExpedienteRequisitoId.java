package pa.gob.migracion.tramites.features.expediente.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExpedienteRequisitoId implements Serializable {

    @Column(name = "expediente_id")
    private Long expedienteId;

    @Column(name = "requisito_id")
    private Integer requisitoId;

    public ExpedienteRequisitoId() {
    }

    public ExpedienteRequisitoId(Long expedienteId, Integer requisitoId) {
        this.expedienteId = expedienteId;
        this.requisitoId = requisitoId;
    }

    public Long getExpedienteId() {
        return expedienteId;
    }

    public void setExpedienteId(Long expedienteId) {
        this.expedienteId = expedienteId;
    }

    public Integer getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(Integer requisitoId) {
        this.requisitoId = requisitoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpedienteRequisitoId)) return false;
        ExpedienteRequisitoId that = (ExpedienteRequisitoId) o;
        return Objects.equals(expedienteId, that.expedienteId) && Objects.equals(requisitoId, that.requisitoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expedienteId, requisitoId);
    }
}
