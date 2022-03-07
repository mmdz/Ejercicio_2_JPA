package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

/*@Author Mellmdz*/
public class ClienteServicio {

    ClienteDAO cdao = new ClienteDAO();

    public Cliente crearCliente(Cliente c) throws Exception {
        validaciones(c);
        cdao.crear(c);
        return c;
    }

    public void eliminar(Cliente c) throws Exception {
        cdao.eliminar(c);
    }

    public void modificar(Cliente c) throws Exception {
        cdao.modificar(c);
    }

    public void validaciones(Cliente c) throws Exception {

        //id, dni, nombre,apellido y telefono
        if (c.getDni() == null || c.getDni() <= 0) {
            throw new Exception("El DNI es inválido");
        }

        if (c.getApellido() == null || c.getApellido().isEmpty()) {
            throw new Exception("El apellido esta vacio o nulo");
        }

        if (c.getNombre() == null || c.getNombre().isEmpty()) {
            throw new Exception("El nombre esta vacio o nulo");
        }

        if(c.getTelefono() == null || c.getTelefono().isEmpty()) {
            throw new Exception("El teléfono es inválido");
        }
    }
}
