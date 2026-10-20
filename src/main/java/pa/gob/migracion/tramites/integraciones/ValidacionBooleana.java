package pa.gob.migracion.tramites.integraciones;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de persistencia para verificaciones institucionales externas (Tribunal Electoral, CSS, Registro Público).
 * Mapeada al esquema ext.ConsultaExterna de BD_Tramites.sql.
 * 
 * Cumplimiento estricto de la Ley 81 de Protección de Datos Personales (Panamá):
 * - Principio de Minimización: Solo se persisten respuestas booleanas (1/0, CUMPLE/NO_CUMPLE).
 * - No se almacenan datos sensibles externos.
 * - Parámetros y firma protegidos mediante hashes criptográficos.
 */
@Entity
@Table(name = "consultaexterna", schema = "ext")
public class ValidacionBooleana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consulta_id")
    private Long id;

    @Column(name = "correlation_id", nullable = false)
    private UUID correlationId = UUID.randomUUID();

    @Column(name = "expediente_id", nullable = false)
    private Long expedienteId;

    @Column(name = "requisito_id", nullable = false)
    private Integer requisitoId;

    @Column(name = "servicio_id", nullable = false)
    private Short servicioId;

    @Column(name = "parametros_hash")
    private byte[] parametrosHash;

    @Column(name = "resultado", nullable = false, length = 25)
    private String resultado = "PENDIENTE";

    @Column(name = "respuesta_booleana")
    private Boolean respuestaBooleana;

    @Column(name = "intentos", nullable = false)
    private Short intentos = 0;

    @Column(name = "max_intentos", nullable = false)
    private Short maxIntentos = 3;

    @Column(name = "solicitada_en", nullable = false)
    private LocalDateTime solicitadaEn = LocalDateTime.now();

    @Column(name = "respondida_en")
    private LocalDateTime respondidaEn;

    public ValidacionBooleana() {
    }

    public ValidacionBooleana(Long expedienteId, Integer requisitoId, Short servicioId, String resultado, Boolean respuestaBooleana, byte[] parametrosHash) {
        this.correlationId = UUID.randomUUID();
        this.expedienteId = expedienteId;
        this.requisitoId = requisitoId;
        this.servicioId = servicioId;
        this.resultado = resultado;
        this.respuestaBooleana = respuestaBooleana;
        this.parametrosHash = parametrosHash;
        this.intentos = 0;
        this.maxIntentos = 3;
        this.solicitadaEn = LocalDateTime.now();
        this.respondidaEn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(UUID correlationId) {
        this.correlationId = correlationId;
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

    public Short getServicioId() {
        return servicioId;
    }

    public void setServicioId(Short servicioId) {
        this.servicioId = servicioId;
    }

    public byte[] getParametrosHash() {
        return parametrosHash;
    }

    public void setParametrosHash(byte[] parametrosHash) {
        this.parametrosHash = parametrosHash;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Boolean getRespuestaBooleana() {
        return respuestaBooleana;
    }

    public void setRespuestaBooleana(Boolean respuestaBooleana) {
        this.respuestaBooleana = respuestaBooleana;
    }

    public Short getIntentos() {
        return intentos;
    }

    public void setIntentos(Short intentos) {
        this.intentos = intentos;
    }

    public Short getMaxIntentos() {
        return maxIntentos;
    }

    public void setMaxIntentos(Short maxIntentos) {
        this.maxIntentos = maxIntentos;
    }

    public LocalDateTime getSolicitadaEn() {
        return solicitadaEn;
    }

    public void setSolicitadaEn(LocalDateTime solicitadaEn) {
        this.solicitadaEn = solicitadaEn;
    }

    public LocalDateTime getRespondidaEn() {
        return respondidaEn;
    }

    public void setRespondidaEn(LocalDateTime respondidaEn) {
        this.respondidaEn = respondidaEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValidacionBooleana)) return false;
        ValidacionBooleana that = (ValidacionBooleana) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
