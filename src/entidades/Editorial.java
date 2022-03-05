package entidades;

import com.sun.istack.internal.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Editorial")
public class Editorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para generar id automatico
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String nombre;
    private Boolean alta;
    

    public Editorial(){
        
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
        this.alta = true;
    }
    

    public Editorial(String nombre, Boolean alta) {
        //this.id = id; //es autoincremental 
        this.nombre = nombre;
        this.alta = alta;
    }
        
    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
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
