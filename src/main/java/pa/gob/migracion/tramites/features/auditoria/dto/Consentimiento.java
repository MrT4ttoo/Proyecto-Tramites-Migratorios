package pa.gob.migracion.tramites.features.auditoria.dto;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de persistencia para el consentimiento de tratamiento de datos personales.
 * Mapeada al esquema priv.Consentimiento de BD_Tramites.sql (Cumplimiento Ley 81).
 */
@Entity
@Table(name = "consentimiento", schema = "priv")
public class Consentimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consentimiento_id")
    private Long id;

    @Column(name = "ruex", nullable = false, length = 20)
    private String ruex;

    @Column(name = "aviso_id", nullable = false)
    private Integer avisoId = 1;

    @Column(name = "aceptado", nullable = false)
    private Boolean aceptado = true;

    @Column(name = "fecha_hora", nullable = false, updatable = false)
    private LocalDateTime fechaHora = LocalDateTime.now();

    @Column(name = "ip_simulada", nullable = false, length = 45)
    private String ipSimulada = "127.0.0.1";

    @Column(name = "finalidad", nullable = false, length = 200)
    private String finalidad = "Tramite migratorio ante el SNM";

    public Consentimiento() {
    }

    public Consentimiento(String ruex, Integer avisoId, Boolean aceptado, String ipSimulada) {
        this.ruex = ruex;
        this.avisoId = avisoId != null ? avisoId : 1;
        this.aceptado = aceptado != null ? aceptado : true;
        this.ipSimulada = ipSimulada != null ? ipSimulada : "127.0.0.1";
        this.finalidad = "Tramite migratorio ante el SNM";
        this.fechaHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuex() {
        return ruex;
    }

    public void setRuex(String ruex) {
        this.ruex = ruex;
    }

    public Integer getAvisoId() {
        return avisoId;
    }

    public void setAvisoId(Integer avisoId) {
        this.avisoId = avisoId;
    }

    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getIpSimulada() {
        return ipSimulada;
    }

    public void setIpSimulada(String ipSimulada) {
        this.ipSimulada = ipSimulada;
    }

    public String getFinalidad() {
        return finalidad;
    }

    public void setFinalidad(String finalidad) {
        this.finalidad = finalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consentimiento)) return false;
        Consentimiento that = (Consentimiento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
