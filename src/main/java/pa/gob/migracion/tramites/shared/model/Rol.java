package pa.gob.migracion.tramites.shared.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rol", schema = "seg")
public class Rol {

    @Id
    @Column(name = "rol_id")
    private Short id;

    @Column(name = "nombre", nullable = false, unique = true, length = 30)
    private String nombre;

    public Rol() {
    }

    public Rol(Short id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol)) return false;
        Rol rol = (Rol) o;
        return Objects.equals(id, rol.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
