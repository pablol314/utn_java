package TP6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa a un profesor que dicta cursos dentro de una universidad.
 */
public class Profesor {
    private final String id;
    private final String nombre;
    private final String especialidad;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String especialidad) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id del profesor es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del profesor es obligatorio");
        }
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad == null ? "" : especialidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    public void agregarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            if (curso.getProfesor() != this) {
                curso.setProfesor(this);
            }
        }
    }

    public void eliminarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        if (cursos.remove(curso) && curso.getProfesor() == this) {
            curso.setProfesor(null);
        }
    }

    void agregarCursoInterno(Curso curso) {
        if (curso != null && !cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    void eliminarCursoInterno(Curso curso) {
        cursos.remove(curso);
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println(nombre + " no dicta cursos actualmente.");
        } else {
            System.out.println("Cursos dictados por " + nombre + ":");
            cursos.forEach(curso -> System.out.printf("- %s (%s)%n", curso.getCodigo(), curso.getNombre()));
        }
    }

    public void mostrarInfo() {
        System.out.printf("Profesor %s - %s | Especialidad: %s | Cursos: %d%n",
                id, nombre, especialidad.isBlank() ? "No indicada" : especialidad, cursos.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor profesor)) return false;
        return id.equalsIgnoreCase(profesor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("%s - %s", id, nombre);
    }
}
