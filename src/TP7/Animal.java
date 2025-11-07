package TP7;

public class Animal {
    private final String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String hacerSonido() {
        return "(sonido genérico)";
    }

    public String describirAnimal() {
        return "Animal: " + nombre;
    }
}
