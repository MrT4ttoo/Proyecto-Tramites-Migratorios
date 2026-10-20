package pa.gob.migracion.tramites.features.tramites.dto;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de persistencia para documentos en repositorio del extranjero (Once-Only).
 * Mapeada al esquema snm.Documento de BD_Tramites.sql.
 */
@Entity
@Table(name = "documento", schema = "snm")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documento_id")
    private Long id;

    @Column(name = "ruex", nullable = false, length = 20)
    private String ruex;

    @Column(name = "tipo_documento_id", nullable = false)
    private Short tipoDocumentoId = 1;

    @Column(name = "nombre_archivo", nullable = false, length = 260)
    private String nombre;

    @Column(name = "ruta_almacenamiento", nullable = false, length = 400)
    private String rutaAlmacenamiento;

    @Column(name = "hash_sha256", nullable = false)
    private byte[] hashSha256;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision = LocalDate.now();

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "estado", nullable = false, length = 10)
    private String estado = "VIGENTE";

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Documento() {
    }

    public Documento(String ruex, Short tipoDocumentoId, String nombre, String rutaAlmacenamiento, byte[] hashSha256) {
        this.ruex = ruex;
        this.tipoDocumentoId = tipoDocumentoId;
        this.nombre = nombre;
        this.rutaAlmacenamiento = rutaAlmacenamiento;
        this.hashSha256 = hashSha256;
        this.fechaEmision = LocalDate.now();
        this.estado = "VIGENTE";
        this.creadoEn = LocalDateTime.now();
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

    public Short getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Short tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaAlmacenamiento() {
        return rutaAlmacenamiento;
    }

    public void setRutaAlmacenamiento(String rutaAlmacenamiento) {
        this.rutaAlmacenamiento = rutaAlmacenamiento;
    }

    public byte[] getHashSha256() {
        return hashSha256;
    }

    public void setHashSha256(byte[] hashSha256) {
        this.hashSha256 = hashSha256;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documento)) return false;
        Documento documento = (Documento) o;
        return Objects.equals(id, documento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
