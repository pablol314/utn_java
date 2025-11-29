package TP6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Gestiona la asignación de profesores y cursos dentro de una universidad.
 */
public class Universidad {
    private final String nombre;
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la universidad es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProfesor(Profesor profesor) {
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor no puede ser nulo");
        }
        if (!profesores.contains(profesor)) {
            profesores.add(profesor);
        } else {
            throw new IllegalArgumentException("Ya existe un profesor con id " + profesor.getId());
        }
    }

    public void agregarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo");
        }
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        } else {
            throw new IllegalArgumentException("Ya existe un curso con código " + curso.getCodigo());
        }
    }

    public Optional<Profesor> buscarProfesorPorId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id es obligatorio");
        }
        return profesores.stream()
                .filter(profesor -> profesor.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public Optional<Curso> buscarCursoPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código es obligatorio");
        }
        return cursos.stream()
                .filter(curso -> curso.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Optional<Curso> curso = buscarCursoPorCodigo(codigoCurso);
        Optional<Profesor> profesor = buscarProfesorPorId(idProfesor);
        if (curso.isPresent() && profesor.isPresent()) {
            curso.get().setProfesor(profesor.get());
            return true;
        }
        return false;
    }

    public List<Profesor> listarProfesores() {
        return new ArrayList<>(profesores);
    }

    public List<Curso> listarCursos() {
        return new ArrayList<>(cursos);
    }

    public boolean eliminarCurso(String codigo) {
        Optional<Curso> curso = buscarCursoPorCodigo(codigo);
        curso.ifPresent(encontrado -> {
            Profesor profesor = encontrado.getProfesor();
            if (profesor != null) {
                profesor.eliminarCursoInterno(encontrado);
            }
            cursos.remove(encontrado);
        });
        return curso.isPresent();
    }

    public boolean eliminarProfesor(String id) {
        Optional<Profesor> profesor = buscarProfesorPorId(id);
        profesor.ifPresent(encontrado -> {
            for (Curso curso : new ArrayList<>(encontrado.getCursos())) {
                curso.setProfesor(null);
            }
            profesores.remove(encontrado);
        });
        return profesor.isPresent();
    }
}
