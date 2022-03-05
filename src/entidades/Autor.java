package entidades;

import com.sun.istack.internal.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //la agrego para q pueda crear en BD
@Table(name = "Autor") //le pongo un nombre, sino por defecto le pone el  nombre de la clase
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//genero automatico
    private Integer id;

    @NotNull
    @Column(unique = true)//q no haya duplicados
    private String nombre;
    private Boolean alta;

    public Autor(String nombre) {
        this.nombre = nombre;
        this.alta = true;
    }
 
    public Autor(String nombre, Boolean alta) {
        // this.id = id; //no lo pide porque es autoincremental
        this.nombre = nombre;
        this.alta = alta;
    }

    public Autor() {

    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

}
