package pa.gob.migracion.tramites.features.tramites.dto;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de persistencia para el extranjero / persona solicitante (RUEX).
 * Mapeada al esquema snm.Extranjero de BD_Tramites.sql.
 */
@Entity
@Table(name = "extranjero", schema = "snm")
public class Extranjero {

    @Id
    @Column(name = "ruex", nullable = false, length = 20)
    private String ruex;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "nacionalidad_id", nullable = false)
    private Short nacionalidadId = 1;

    @Column(name = "pasaporte_numero", nullable = false, length = 30)
    private String pasaporteNumero;

    @Column(name = "telefono", length = 25)
    private String telefono;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Extranjero() {
    }

    public Extranjero(String ruex, Usuario usuario, String nombres, String apellidos, LocalDate fechaNacimiento, String pasaporteNumero) {
        this.ruex = ruex;
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.pasaporteNumero = pasaporteNumero;
        this.nacionalidadId = 1;
        this.creadoEn = LocalDateTime.now();
    }

    public String getRuex() {
        return ruex;
    }

    public void setRuex(String ruex) {
        this.ruex = ruex;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Short getNacionalidadId() {
        return nacionalidadId;
    }

    public void setNacionalidadId(Short nacionalidadId) {
        this.nacionalidadId = nacionalidadId;
    }

    public String getPasaporteNumero() {
        return pasaporteNumero;
    }

    public void setPasaporteNumero(String pasaporteNumero) {
        this.pasaporteNumero = pasaporteNumero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        if (!(o instanceof Extranjero)) return false;
        Extranjero that = (Extranjero) o;
        return Objects.equals(ruex, that.ruex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruex);
    }
}
