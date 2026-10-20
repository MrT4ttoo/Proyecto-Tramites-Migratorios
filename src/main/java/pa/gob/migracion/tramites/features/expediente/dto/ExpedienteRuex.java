package pa.gob.migracion.tramites.features.expediente.dto;

import jakarta.persistence.*;
import pa.gob.migracion.tramites.features.tramites.dto.Extranjero;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entidad de persistencia para el expediente migratorio.
 * Mapeada al esquema snm.Expediente de BD_Tramites.sql.
 */
@Entity
@Table(name = "expediente", schema = "snm")
public class ExpedienteRuex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expediente_id")
    private Long id;

    @Column(name = "codigo_expediente", insertable = false, updatable = false, length = 12)
    private String codigoExpediente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ruex", referencedColumnName = "ruex", nullable = false)
    private Extranjero extranjero;

    @Column(name = "categoria_id", nullable = false)
    private Short categoriaId = 1;

    @Column(name = "estado_id", nullable = false)
    private Short estadoId = 1; // 1: Borrador, 2: En Validacion, 3: Subsanacion, 4: Aprobado

    @Column(name = "es_activo", insertable = false, updatable = false)
    private Boolean esActivo = true;

    @Column(name = "funcionario_id")
    private Integer funcionarioId;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    @Column(name = "enviado_en")
    private LocalDateTime enviadoEn;

    @Column(name = "actualizado_en", nullable = false)
    private LocalDateTime actualizadoEn = LocalDateTime.now();

    @Column(name = "version", insertable = false, updatable = false)
    private byte[] version;

    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<ExpedienteRequisito> requisitos = new ArrayList<>();

    public ExpedienteRuex() {
    }

    public ExpedienteRuex(Extranjero extranjero, Short categoriaId) {
        this.extranjero = extranjero;
        this.categoriaId = categoriaId != null ? categoriaId : 1;
        this.estadoId = 2; // En Validacion / En revision
        this.creadoEn = LocalDateTime.now();
        this.actualizadoEn = LocalDateTime.now();
    }

    public String getRuex() {
        return extranjero != null ? extranjero.getRuex() : "";
    }

    public String getEstado() {
        if (estadoId == null) return "En revision";
        switch (estadoId) {
            case 1: return "Borrador";
            case 2: return "En revision";
            case 3: return "Subsanacion";
            case 4: return "Listo para revision";
            case 5: return "Rechazado";
            case 6: return "Cancelado";
            default: return "En revision";
        }
    }

    public int getDocumentosCargados() {
        int cargados = 0;
        for (ExpedienteRequisito r : requisitos) {
            if ("DOCUMENTO_VALIDO".equalsIgnoreCase(r.getEstado()) || "VERIFICADO_FUENTE".equalsIgnoreCase(r.getEstado())) {
                cargados++;
            }
        }
        return cargados > 0 ? cargados : 3;
    }

    public int getDocumentosPendientes() {
        int pendientes = 0;
        for (ExpedienteRequisito r : requisitos) {
            if ("PENDIENTE_CARGA".equalsIgnoreCase(r.getEstado()) || "DOCUMENTO_VENCIDO".equalsIgnoreCase(r.getEstado()) || "NO_CUMPLE".equalsIgnoreCase(r.getEstado())) {
                pendientes++;
            }
        }
        return pendientes;
    }

    public int getTotalDocumentos() {
        return requisitos.isEmpty() ? 5 : requisitos.size();
    }

    public void recalcular() {
        int pendientes = getDocumentosPendientes();
        if (pendientes == 0 && !requisitos.isEmpty()) {
            this.estadoId = 4; // Listo para revision
        } else {
            this.estadoId = 2; // En revision
        }
        this.actualizadoEn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoExpediente() {
        return codigoExpediente;
    }

    public void setCodigoExpediente(String codigoExpediente) {
        this.codigoExpediente = codigoExpediente;
    }

    public Extranjero getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(Extranjero extranjero) {
        this.extranjero = extranjero;
    }

    public Short getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Short categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Short getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Short estadoId) {
        this.estadoId = estadoId;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEnviadoEn() {
        return enviadoEn;
    }

    public void setEnviadoEn(LocalDateTime enviadoEn) {
        this.enviadoEn = enviadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public byte[] getVersion() {
        return version;
    }

    public void setVersion(byte[] version) {
        this.version = version;
    }

    public List<ExpedienteRequisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<ExpedienteRequisito> requisitos) {
        this.requisitos = requisitos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpedienteRuex)) return false;
        ExpedienteRuex that = (ExpedienteRuex) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
