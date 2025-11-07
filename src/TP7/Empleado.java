package TP7;

public abstract class Empleado {
    private final String nombre;

    protected Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSueldo();
}
