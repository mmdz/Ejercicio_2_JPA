package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*@Author Mellmdz*/
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)//la particularidad se aplica al atributo escrito debajo 
    private Long dni;
    private String apellido;
    private String nombre;
    private String telefono;

    public Cliente(Long dni, String apellido, String nombre,String telefono){
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono; 
    }
    
    public Cliente(Integer id, Long dni, String apellido, String nombre,String telefono) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono; 
    }

    public Cliente(){
        
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ",teléfono=" + telefono +'}';
    }
    
//getter & setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
}
