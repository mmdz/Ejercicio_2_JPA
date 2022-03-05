package persistencia;

import entidades.Cliente;

/*@Author Mellmdz*/
public class ClienteDAO extends DAO {

    //ABM = crear, modificar, eliminar
    public void crear(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();//lo hereda de DAO
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                throw new Exception("Error haciendo rollback de cliente");
            }
            throw new Exception("Error al persitir un cliente");

        }
    }

    public void modificar(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();//lo hereda de DAO
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al modificar un cliente");
        }
    }
    
    public void eliminar(Cliente cliente) throws Exception {
        try {
            em.getTransaction().begin();//lo hereda de DAO
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Error al eliminar un cliente");
        }
    }
    
    //metodos de busqueda
    public Cliente buscarPorId(Integer id) {
        return em.find(Cliente.class, id);
    }

    public Cliente buscarPorNombre(String nombre) {
        return (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
    }
    
    public Cliente buscarPorApellido(String apellido) {
        return (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.apellido = :apellido").setParameter("apellido", apellido).getSingleResult();
    }

}
