package persistencia;

import entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO {

    public void crear(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                throw new Exception("Error haciendo un rollback");
            }

            throw new Exception("Error al persitir un libro");
        }
    }

    public void modificar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar un libro");
        }
    }

    public void eliminar(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un libro");
        }
    }

    //9) Búsqueda de un libro por ISBN.
    public Libro buscarLibroPorIsbn(Long isbn) {
        return em.find(Libro.class, isbn); //find busca por Pkey
    }
    //10) Búsqueda de un libro por Título.   

    public Libro buscarLibroPorTitulo(String titulo) {
        return (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
    }
//11) Búsqueda de un libro/s por nombre de Autor.

    public Libro buscarLibroPorNombreAutor(String nombre) {
        return (Libro) em.createQuery("SELECT l FROM Libro l JOIN l.autor a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
        //traer nombre con JOIN de autor
        //SELECT l FROM Libro JOIN l.Autor a
    }

//12) Búsqueda deun libro/s por nombre de Editorial
    public List<Libro> buscarLibroPorNombreEditorial(String nombre) {
        return em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre = :nombre").setParameter("nombre", nombre).getResultList();
    }
    
//     public List<Libro> listarPersonas() {
//        try {
//             return em.createQuery("SELECT p FROM Persona p").getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//       
//    }

}
