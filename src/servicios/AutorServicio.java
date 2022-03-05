package servicios;

import entidades.Autor;
import java.util.List;
import persistencia.AutorDAO;


public class AutorServicio {
    AutorDAO adao = new AutorDAO();
    
     public Autor crearAutor(Autor a) throws Exception{        
        validaciones(a);       
        adao.crear(a);
        return a;
    }
    
    public void eliminar(Autor a) throws Exception{
        adao.eliminar(a);
    }
    public void modificar(Autor a) throws Exception{
        adao.modificar(a);
    }
    
    public void validaciones(Autor a) throws Exception{ 
        if (a.getNombre()==null || a.getNombre().isEmpty()) {
            throw new Exception("Ingresaste un nombre nulo o vacío");
        }
        
//        if (a.getId()==null || a.getId()<=0) {
//            throw new Exception("El ID es inválido");
//        }        
    }
    
    public Autor buscarPorId(Integer id){
        return adao.buscarPorId(id);
    }
    
    public Autor buscarPorNombre(String nombre){
        Autor a = adao.buscarPorNombre(nombre);
        return a;
    }
    
//    public List<Autor> listarAutores(){
//        return adao.listarAutores();
//    }
}
