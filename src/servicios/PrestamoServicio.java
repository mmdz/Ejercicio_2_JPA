package servicios;

import entidades.Cliente;
import entidades.Libro;
import entidades.Prestamo;

import java.util.Date;
import java.util.Scanner;

import persistencia.PrestamoDAO;

/*@Author Mellmdz*/
public class PrestamoServicio {

    PrestamoDAO pdao = new PrestamoDAO();

    public Date crearFecha() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Dia: ");
        int dia = leer.nextInt();

        System.out.println("Mes: ");
        int mes = leer.nextInt();

        System.out.println("anio: ");
        int anio = leer.nextInt();

        Date fechaIngresada = (new Date(anio - 1900, mes - 1, dia));

        return fechaIngresada;
    }

    public Prestamo crearPrestamo(Cliente cliente, Libro libro) throws Exception {

        Prestamo p = new Prestamo();

        System.out.println("Ingrese fecha actual");
        p.setFechaActual(crearFecha());

        System.out.println("Ingrese fecha de préstamo");
        p.setFechaPrestamo(crearFecha());

        System.out.println("Ingrese fecha de devolución");
        p.setFechaDevolucion(crearFecha());

        // System.out.println("Ingrese Libro");       
        p.setLibro(libro);

        // System.out.println("Ingrese Cliente");
        p.setCliente(cliente);

        validaciones(p);

        pdao.crear(p);
        return p;
    }

    public void eliminar(Prestamo p) throws Exception {
        pdao.eliminar(p);
    }

    public void modificar(Prestamo p) throws Exception {
        pdao.modificar(p);
    }

    public void validaciones(Prestamo p) throws Exception {
        //id,fechaPResta, fechaDEvolu, libro, cliente
        /*No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más
        ejemplares de los que hay, ni devolver más de los que se encuentran prestados.
        No se podrán prestar libros con fecha anterior a la fecha actual, etc.*/

        if (p.getLibro() == null) {
            throw new Exception("Libro no encontrado");
        }

        if (p.getFechaPrestamo() == null || p.getFechaPrestamo().equals(p.getFechaActual()) 
                || p.getFechaPrestamo().before(p.getFechaActual())) {
            throw new Exception("Debe ser una fecha posterior a la fecha actual ");
        }

        if (p.getFechaDevolucion() == null || p.getFechaDevolucion().equals(p.getFechaActual())
                ||p.getFechaDevolucion().before(p.getFechaPrestamo())) {
            throw new Exception("Debe ser una fecha posterior a la fecha actual ");
        }
    }

    public Prestamo buscarLibroPorId(Integer id) {
        return pdao.buscarLibroPorId(id);
    }

//    public Libro buscarLibroPorTitulo(String titulo) {
//        return ldao.buscarLibroPorTitulo(titulo);
//    }
//
//    public Libro buscarLibroPorNombreAutor(String nombre) {
//        return ldao.buscarLibroPorNombreAutor(nombre);
//    }
//
//    public List<Libro> buscarLibroPorNombreEditorial(String nombre) {
//        return ldao.buscarLibroPorNombreEditorial(nombre);
//    }
}
