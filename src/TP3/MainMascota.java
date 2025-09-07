class Mascota {
    String nombre;
    String especie;
    int edad;

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }

    public void cumplirAnios() {
        edad++;
        System.out.println(nombre + " ha cumplido un año más. Edad actual: " + edad);
    }
}

public class MainMascota {
    public static void main(String[] args) {
        Mascota perro = new Mascota("Firulais", "Perro", 3);
        perro.mostrarInfo();
        perro.cumplirAnios();
        perro.cumplirAnios();
        perro.mostrarInfo();
    }
}
