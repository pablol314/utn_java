class PlacaMadre {
    String modelo;
    String chipset;
    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }
}

class Propietario {
    String nombre;
    String dni;
    Computadora computadora;
    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
}

class Computadora {
    String marca;
    String numeroSerie;
    PlacaMadre placaMadre;
    Propietario propietario;

    public Computadora(String marca, String numeroSerie, Propietario propietario, PlacaMadre placaMadre) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.propietario = propietario;
        this.placaMadre = placaMadre;
        propietario.computadora = this;
    }
}

public class ComputadoraMain {
    public static void main(String[] args) {
        Propietario p = new Propietario("Carlos Ruiz", "22223333");
        PlacaMadre pm = new PlacaMadre("ASUS-B450", "AM4");
        Computadora c = new Computadora("HP", "SN123456", p, pm);
        System.out.println("Computadora de " + p.nombre + " con placa " + pm.modelo);
    }
}
