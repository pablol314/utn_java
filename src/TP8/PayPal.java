package tp8;

public class PayPal implements PagoConDescuento {
    private final String correo;
    private double saldo;
    private double cuponPorcentaje;

    public PayPal(String correo, double saldo, double cuponPorcentaje) {
        this.correo = correo;
        this.saldo = saldo;
        this.cuponPorcentaje = cuponPorcentaje;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public double aplicarDescuento(double monto) {
        if (cuponPorcentaje <= 0) {
            return monto;
        }
        return monto - (monto * cuponPorcentaje / 100);
    }

    @Override
    public void procesarPago(double monto) throws PagoException {
        if (monto <= 0) {
            throw new PagoException("El monto a cobrar debe ser positivo");
        }
        if (monto > saldo) {
            throw new PagoException("Saldo insuficiente en la cuenta de PayPal de " + correo);
        }
        saldo -= monto;
        System.out.println("Pago con PayPal procesado por $" + monto + ". Saldo restante: $" + saldo);
    }
}
