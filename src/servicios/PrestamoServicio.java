package servicios;

import entidades.Prestamo;
import static java.sql.JDBCType.DATE;
import static java.sql.Types.DATE;
import java.time.LocalDate;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Scanner;
import static javafx.scene.AccessibleAttribute.DATE;
import static javax.management.openmbean.SimpleType.DATE;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIME;
import static org.eclipse.persistence.sdo.SDOConstants.DATE;
import persistencia.PrestamoDAO;

/*@Author Mellmdz*/
public class PrestamoServicio {

    PrestamoDAO pdao = new PrestamoDAO();

    public Prestamo crearCliente(Prestamo p) throws Exception {
        validaciones(p);
      
//        Scanner leer = new Scanner(System.in);
//        System.out.println("Ingrese dia:");
//        Integer dia = leer.nextInt();
//        System.out.println("Ingrese mes:");
//        Integer mes = leer.nextInt();
//        System.out.println("Ingrese año:");
//        Integer anio = leer.nextInt();
        
        
        //p.setFechaActual();
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
        
 
        
        

        if (p.getFechaPrestamo() == null) {
            throw new Exception("Fecha invalida");
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
