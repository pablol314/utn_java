class ClienteR {
    String nombre;
    String telefono;
    public ClienteR(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}

class Mesa {
    int numero;
    int capacidad;
    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
}

class Reserva {
    String fecha;
    String hora;
    ClienteR cliente;
    Mesa mesa;

    public Reserva(String fecha, String hora, ClienteR cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
}

public class ReservaMain {
    public static void main(String[] args) {
        ClienteR c = new ClienteR("Laura Díaz", "351-5551234");
        Mesa m = new Mesa(5, 4);
        Reserva r = new Reserva("2025-09-10", "20:00", c, m);
        System.out.println("Reserva a nombre de " + c.nombre + " en mesa " + m.numero);
    }
}
