package TP7;

public abstract class Figura {
    private final String nombre;

    protected Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularArea();
}
