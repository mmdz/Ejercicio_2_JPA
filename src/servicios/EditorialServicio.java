package servicios;

import entidades.Editorial;
import persistencia.EditorialDAO;

public class EditorialServicio {

    EditorialDAO edao = new EditorialDAO();

    public Editorial crearEditorial(Editorial e) throws Exception {
        validaciones(e);
        edao.crear(e);
        return e;
    }

    public void eliminar(Editorial e) throws Exception{
        edao.eliminar(e); //llama al metodo del dao
    }
    
    public void modificar(Editorial e) throws Exception{
        edao.modificar(e);
    } 
    
    public void validaciones(Editorial e) throws Exception {
//        if (e.getId() == null || e.getId() <= 0) {
//            throw new Exception("Ingresaste Id inválido");
//        }
        if (e.getNombre() == null || e.getNombre().isEmpty()) {
            throw new Exception("Ingresó un nombre nulo o vacío");
        }        
    }
    
    public Editorial buscarPorId(Integer id){
        return edao.buscarPorId(id);
    }
    
    public Editorial buscarPorNombre(String nombre){
        return edao.buscarPorNombre(nombre);
    }
}
