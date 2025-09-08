class Cliente {
    String nombre;
    String dni;
    TarjetaDeCredito tarjeta;
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
}

class Banco {
    String nombre;
    String cuit;
    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
}

class TarjetaDeCredito {
    String numero;
    String fechaVencimiento;
    Cliente cliente;
    Banco banco;

    public TarjetaDeCredito(String numero, String fechaVencimiento, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cliente = cliente;
        this.banco = banco;
        cliente.tarjeta = this;
    }
}

public class TarjetaCreditoMain {
    public static void main(String[] args) {
        Cliente c = new Cliente("Ana López", "11112222");
        Banco b = new Banco("Banco Nación", "30-99999999-7");
        TarjetaDeCredito t = new TarjetaDeCredito("1234-5678-9876-5432", "12/30", c, b);
        System.out.println("Tarjeta del cliente " + c.nombre + " emitida por " + b.nombre);
    }
}
