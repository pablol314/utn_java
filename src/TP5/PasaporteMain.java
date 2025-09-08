class Foto {
    String imagen;
    String formato;
    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }
}

class Titular {
    String nombre;
    String dni;
    Pasaporte pasaporte;
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
}

class Pasaporte {
    String numero;
    String fechaEmision;
    Foto foto;
    Titular titular;

    public Pasaporte(String numero, String fechaEmision, Titular titular, Foto foto) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.titular = titular;
        this.foto = foto;
        titular.pasaporte = this;
    }
}

public class PasaporteMain {
    public static void main(String[] args) {
        Titular t = new Titular("Juan Pérez", "12345678");
        Foto f = new Foto("foto.png", "PNG");
        Pasaporte p = new Pasaporte("A12345", "2025-01-01", t, f);
        System.out.println("Pasaporte creado para: " + t.nombre);
    }
}
