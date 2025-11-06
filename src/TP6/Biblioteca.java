package ar.utn.programacion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gestiona el catálogo de libros disponibles.
 */
public class Biblioteca {
    private final String nombre;
    private final List<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la biblioteca es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro nuevo = new Libro(isbn, titulo, anioPublicacion, autor);
        if (libros.contains(nuevo)) {
            throw new IllegalArgumentException("Ya existe un libro con ISBN " + isbn);
        }
        libros.add(nuevo);
    }

    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    public Optional<Libro> buscarLibroPorIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("El ISBN es obligatorio");
        }
        return libros.stream()
                .filter(libro -> libro.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public boolean eliminarLibro(String isbn) {
        Optional<Libro> encontrado = buscarLibroPorIsbn(isbn);
        encontrado.ifPresent(libros::remove);
        return encontrado.isPresent();
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        return libros.stream()
                .filter(libro -> libro.getAnioPublicacion() == anio)
                .collect(Collectors.toList());
    }

    public Set<Autor> mostrarAutoresDisponibles() {
        return libros.stream()
                .map(Libro::getAutor)
                .collect(Collectors.toSet());
    }
}
