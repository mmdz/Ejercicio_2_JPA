package entidades;

import java.util.Date;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*@Author Mellmdz*/
@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//automatizo el ID
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Temporal(TemporalType.DATE)
    private Date fechaActual;

    @OneToOne
    private Libro libro;
    @OneToOne
    private Cliente cliente;

//    public Date crearFecha() {
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//
//        System.out.println("Dia: ");
//        int dia = leer.nextInt();
//
//        System.out.println("Mes: ");
//        int mes = leer.nextInt();
//
//        System.out.println("anio: ");
//        int anio = leer.nextInt();
//
//        Date fechaIngresada = (new Date(anio - 1900, mes - 1, dia));
//
//        return fechaIngresada;
//    }

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
    }

    public Prestamo(Integer id, Date fechaPrestamo, Date fechaDevolucion, Libro libro, Cliente cliente) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
    }

    public Prestamo() {

    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + "Fecha actual" + fechaActual + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", libro=" + libro + ", cliente=" + cliente + '}';
    }
//getter y setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

}
