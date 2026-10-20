package pa.gob.migracion.tramites.features.tramites.dto;

import jakarta.persistence.*;
import pa.gob.migracion.tramites.shared.model.Rol;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de persistencia para usuarios y control de acceso.
 * Mapeada al esquema seg.Usuario de BD_Tramites.sql.
 */
@Entity
@Table(name = "usuario", schema = "seg")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer id;

    @Column(name = "correo", nullable = false, unique = true, length = 254)
    private String correo;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "algoritmo_hash", nullable = false, length = 10)
    private String algoritmoHash = "bcrypt";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @Column(name = "intentos_fallidos", nullable = false)
    private Short intentosFallidos = 0;

    @Column(name = "bloqueado_hasta")
    private LocalDateTime bloqueadoHasta;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Usuario() {
    }

    public Usuario(String correo, String passwordHash, Rol rol) {
        this.correo = correo;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.algoritmoHash = "bcrypt";
        this.activo = true;
        this.intentosFallidos = 0;
        this.creadoEn = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getAlgoritmoHash() {
        return algoritmoHash;
    }

    public void setAlgoritmoHash(String algoritmoHash) {
        this.algoritmoHash = algoritmoHash;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getRolNombre() {
        return (rol != null && rol.getNombre() != null) ? rol.getNombre() : "SOLICITANTE";
    }

    public Short getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(Short intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public LocalDateTime getBloqueadoHasta() {
        return bloqueadoHasta;
    }

    public void setBloqueadoHasta(LocalDateTime bloqueadoHasta) {
        this.bloqueadoHasta = bloqueadoHasta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correo);
    }
}
