class Bateria {
    String modelo;
    int capacidad;
    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
}

class Usuario {
    String nombre;
    String dni;
    Celular celular;
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
}

class Celular {
    String imei;
    String marca;
    String modelo;
    Bateria bateria;
    Usuario usuario;

    public Celular(String imei, String marca, String modelo, Bateria bateria, Usuario usuario) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
        this.usuario = usuario;
        usuario.celular = this;
    }
}

public class CelularMain {
    public static void main(String[] args) {
        Bateria b = new Bateria("Samsung-01", 4000);
        Usuario u = new Usuario("Carlos Gómez", "87654321");
        Celular c = new Celular("1234567890", "Samsung", "S21", b, u);
        System.out.println("Celular de: " + u.nombre + " con batería modelo " + b.modelo);
    }
}
