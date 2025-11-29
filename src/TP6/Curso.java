package TP6;

import java.util.Objects;

/**
 * Representa a un curso dictado en la universidad.
 */
public class Curso {
    private final String codigo;
    private final String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del curso es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del curso es obligatorio");
        }
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor nuevoProfesor) {
        if (this.profesor == nuevoProfesor) {
            return;
        }
        Profesor anterior = this.profesor;
        this.profesor = nuevoProfesor;
        if (anterior != null) {
            anterior.eliminarCursoInterno(this);
        }
        if (nuevoProfesor != null) {
            nuevoProfesor.agregarCursoInterno(this);
        }
    }

    public void mostrarInfo() {
        String nombreProfesor = profesor == null ? "Sin asignar" : profesor.getNombre();
        System.out.printf("Curso %s - %s | Profesor: %s%n", codigo, nombre, nombreProfesor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso curso)) return false;
        return codigo.equalsIgnoreCase(curso.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s - %s", codigo, nombre);
    }
}
