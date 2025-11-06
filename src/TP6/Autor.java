package ar.utn.programacion2;

import java.util.Objects;

/**
 * Representa a un autor de libros.
 */
public class Autor {
    private final String id;
    private final String nombre;
    private final String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id del autor es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio");
        }
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad == null ? "" : nacionalidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void mostrarInfo() {
        System.out.printf("Autor %s - %s (%s)%n", id, nombre,
                nacionalidad.isBlank() ? "Nacionalidad no registrada" : nacionalidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor autor)) return false;
        return id.equalsIgnoreCase(autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre;
    }
}
