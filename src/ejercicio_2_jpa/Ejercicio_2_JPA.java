package ejercicio_2_jpa;

import entidades.Autor;
import entidades.Cliente;
import entidades.Editorial;
import entidades.Libro;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import servicios.AutorServicio;
import servicios.ClienteServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;
import servicios.PrestamoServicio;

/*@Author Mellmdz*/
public class Ejercicio_2_JPA {

    public static void main(String[] args) {
        try {
            //creo los servicios
            AutorServicio as = new AutorServicio();
            EditorialServicio es = new EditorialServicio();
            LibroServicio ls = new LibroServicio();
            //creo autores
            Autor a1 = new Autor("OscarWilde");
            Autor a2 = new Autor("JaneAusten");
            Autor a3 = new Autor("Cortazar");
            Autor a4 = new Autor("Sabato");
            as.crearAutor(a1);
            as.crearAutor(a2);
            as.crearAutor(a3);
            as.crearAutor(a4);

            //creo editoriales
            Editorial e1 = new Editorial("Planeta");
            Editorial e2 = new Editorial("Adisson");
            Editorial e3 = new Editorial("Puerto");
            es.crearEditorial(e1);
            es.crearEditorial(e2);
            es.crearEditorial(e3);

            //creo Libros
            Libro l1 = new Libro(1000L, "Orgullo", 1850, 100, 50, 25, a2, e1);
            Libro l2 = new Libro(2000L, "Oliver", 1895, 200, 50, 75, a1, e1);
            Libro l3 = new Libro(3000L, "Rayuela", 1948, 300, 50, 45, a3, e3);
            Libro l4 = new Libro(4000L, "Tunel", 1920, 150, 75, 20, a4, e2);
            ls.crearLibro(l1);
            ls.crearLibro(l2);
            ls.crearLibro(l3);
            ls.crearLibro(l4);

//            System.out.println("--------");//busca autor
//            System.out.println(as.buscarPorNombre("Sabato").toString());
//
//            System.out.println("---------");
//            System.out.println(ls.buscarLibroPorIsbn(1000L).toString());
//
//            System.out.println("---------");
//            System.out.println(ls.buscarLibroPorTitulo("Rayuela"));
//
//            System.out.println("---------"); //tit, aut, edi
//            System.out.println(ls.buscarLibroPorNombreAutor("JaneAusten"));
            System.out.println("---------");

//            List<Libro> lista = new ArrayList();
//            lista = ls.buscarLibroPorNombreEditorial("Planeta");
//
//            for (int i = 0; i < lista.size(); i++) { //uso una lista para que muestre varias 
//                //System.out.println(lista.get(i).getTitulo().toString());
//                System.out.println(lista.get(i).getTitulo().toString());
//            }
            //////////////////////////////    
            ClienteServicio cs = new ClienteServicio();
            Cliente c1 = new Cliente(100000L, "Garcia", "Maria", "111111");
            cs.crearCliente(c1);

            PrestamoServicio ps = new PrestamoServicio();
            ps.crearPrestamo(c1, l1);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /*validar FECHAS!!*/
//1. Creación de un Cliente nuevo
//2. Crear entidad Préstamo
//3. Registrar el préstamo de un libro.
//4. Devolución de un libro
//5. Búsqueda de todos los prestamos de un Cliente.
//6. Agregar validaciones a todas las funcionalidades de la aplicación:
//• Validar campos obligatorios.
//• No ingresar datos duplicados.
//• No generar condiciones inválidas. Por ejemplo, no se debe permitir 
    //   prestar más ejemplares de los que hay, ni devolver más de los que 
    //se encuentran prestados.
//No se podrán prestar libros con fecha anterior a la fecha actual, etc.
}
