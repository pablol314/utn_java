class Estudiante {
    String nombre;
    String apellido;
    String curso;
    double calificacion;

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
    }

    public void subirCalificacion(double puntos) {
        calificacion += puntos;
        System.out.println("La calificación subió a: " + calificacion);
    }

    public void bajarCalificacion(double puntos) {
        calificacion -= puntos;
        if (calificacion < 0) calificacion = 0;
        System.out.println("La calificación bajó a: " + calificacion);
    }
}

public class MainEstudiante {
    public static void main(String[] args) {
        Estudiante est = new Estudiante("Juan", "Pérez", "Programación II", 7.5);
        est.mostrarInfo();
        est.subirCalificacion(1.2);
        est.bajarCalificacion(2.0);
        est.mostrarInfo();
    }
}
