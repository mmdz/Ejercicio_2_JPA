package servicios;

import entidades.Libro;
import java.util.List;
import persistencia.LibroDAO;

public class LibroServicio {

    LibroDAO ldao = new LibroDAO();

    public Libro crearLibro(Libro l) throws Exception {
        validaciones(l);
        ldao.crear(l);
        return l;
    }

    public void eliminar(Libro l) throws Exception {
        ldao.eliminar(l);
    }

    public void modificar(Libro l) throws Exception {
        ldao.modificar(l);
    }

    public void validaciones(Libro l) throws Exception {

        //ejemplares, ej pres, ej rest, alta, aut, edit
        if (l.getIsbn() == null || l.getIsbn() <= 0) {
            throw new Exception("El ISBN es inválido");
        }
        if (l.getAnio() == null || l.getAnio() <= 0) {
            throw new Exception("Ingrese un año válido");
        }
        if (l.getEjemplares() == null || l.getEjemplares() <= 0) {
            throw new Exception("Ingrese cantidad mayor a cero");
        }
        if (l.getEjemplaresPrestados() == null || l.getEjemplaresPrestados() <= 0) {
            throw new Exception("Ingrese cantidad mayor a cero");
        }
        if (l.getEjemplaresRestantes() == null || l.getEjemplaresRestantes() == 0) {
            throw new Exception("No hay más ejemplares");
        }
        if (l.getAutor() == null || l.getAutor().getNombre().isEmpty()) {
            throw new Exception("Ingrese autor válido");
        }
        if (l.getEditorial() == null || l.getEditorial().getNombre().isEmpty()) {
            throw new Exception("Ingrese editorial válida");
        }
    }

    public Libro buscarLibroPorIsbn(Long isbn) {
        return ldao.buscarLibroPorIsbn(isbn);
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        return ldao.buscarLibroPorTitulo(titulo);
    }

    public Libro buscarLibroPorNombreAutor(String nombre) {
        return ldao.buscarLibroPorNombreAutor(nombre);
    }

    public List<Libro> buscarLibroPorNombreEditorial(String nombre) {
        return ldao.buscarLibroPorNombreEditorial(nombre);
    }
}
