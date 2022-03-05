package persistencia;

import entidades.Autor;
import java.util.List;

public class AutorDAO extends DAO {

    public void crear(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al persitir un autor");
        }
    }

    public void modificar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar un autor");
        }
    }

    public void eliminar(Autor autor) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un autor");
        }
    }

    public Autor buscarPorId(Integer id) {
        //find busca por la PrimaryKey
        return em.find(Autor.class, id);
    }

    public Autor buscarPorNombre(String nombre) {
        return (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
    }

//    public List<Autor> listarAutores() {
//        try {
//             return em.createQuery("SELECT a FROM Autor a").getResultList();
//        } catch (Exception e) {
//            return null;
//        }       
//    }

}
