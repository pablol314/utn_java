package TP6;

import java.util.Objects;

/**
 * Representa un libro disponible en la biblioteca.
 */
public class Libro {
    private final String isbn;
    private final String titulo;
    private final int anioPublicacion;
    private final Autor autor;

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("El ISBN es obligatorio");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        if (autor == null) {
            throw new IllegalArgumentException("El autor es obligatorio");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void mostrarInfo() {
        System.out.printf("ISBN: %s | Título: %s | Año: %d | Autor: %s%n", isbn, titulo, anioPublicacion, autor.getNombre());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return isbn.equalsIgnoreCase(libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)", isbn, titulo, anioPublicacion);
    }
}
