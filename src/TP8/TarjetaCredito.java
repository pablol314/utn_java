package tp8;

public class TarjetaCredito implements PagoConDescuento {
    private final String titular;
    private final double limite;
    private double saldoDisponible;
    private double descuentoPromocional;

    public TarjetaCredito(String titular, double limite, double descuentoPromocional) {
        this.titular = titular;
        this.limite = limite;
        this.saldoDisponible = limite;
        this.descuentoPromocional = descuentoPromocional;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setDescuentoPromocional(double descuentoPromocional) {
        this.descuentoPromocional = descuentoPromocional;
    }

    @Override
    public double aplicarDescuento(double monto) {
        if (descuentoPromocional <= 0) {
            return monto;
        }
        return monto - (monto * descuentoPromocional / 100);
    }

    @Override
    public void procesarPago(double monto) throws PagoException {
        if (monto <= 0) {
            throw new PagoException("El monto a cobrar debe ser positivo");
        }
        if (monto > saldoDisponible) {
            throw new PagoException("Saldo insuficiente en la tarjeta de " + titular);
        }
        saldoDisponible -= monto;
        System.out.println("Pago con tarjeta aprobado por $" + monto + ". Saldo restante: $" + saldoDisponible);
    }
}
