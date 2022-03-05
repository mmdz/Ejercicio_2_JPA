package persistencia;

import entidades.Prestamo;
import java.util.List;

/*@Author Mellmdz*/
public class PrestamoDAO extends DAO {

    public void crear(Prestamo prestamo) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                throw new Exception("Error haciendo un rollback de préstamo");
            }

            throw new Exception("Error al persitir un préstamo");
        }
    }

    public void modificar(Prestamo prestamo) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar un préstamo");
        }
    }

    public void eliminar(Prestamo prestamo) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(prestamo);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un préstamo");
        }
    }

    public Prestamo buscarLibroPorId(Integer id) {
        return em.find(Prestamo.class, id); //find busca por Pkey
    }
    //3. Registrar el préstamo de un libro.
    //4. Devolución de un libro

    //5. Búsqueda de todos los prestamos de un Cliente.
        public List<Prestamo> buscarPrestamosDeUnCliente(Long dni) {
        return em.createQuery("SELECT p FROM Prestamo p JOIN p.Cliente c WHERE c.dni = :dni").setParameter("dni", dni).getResultList();
    }
}
