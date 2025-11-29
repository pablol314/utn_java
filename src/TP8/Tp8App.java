package tp8;

import java.io.IOException;
import java.util.List;

public class Tp8App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana", "ana@example.com");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProducto(new Producto("Auriculares", 15000));
        pedido.agregarProducto(new Producto("Teclado", 22000));

        double totalPedido = pedido.calcularTotal();
        PagoConDescuento pagoConTarjeta = new TarjetaCredito("Ana", 80000, 10);
        double totalConDescuento = pagoConTarjeta.aplicarDescuento(totalPedido);

        try {
            pagoConTarjeta.procesarPago(totalConDescuento);
            pedido.actualizarEstado("Pagado");
        } catch (PagoException e) {
            System.out.println("No fue posible procesar el pago: " + e.getMessage());
        }

        try {
            int division = ExcepcionesUtil.dividirSeguro(10, 0);
            System.out.println("Resultado de la división: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Error al dividir: " + e.getMessage());
        }

        try {
            int numero = ExcepcionesUtil.convertirCadenaANumero("10a");
            System.out.println("Número ingresado: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir el texto a número: " + e.getMessage());
        }

        try {
            ExcepcionesUtil.validarEdad(150);
        } catch (EdadInvalidaException e) {
            System.out.println("Validación de edad fallida: " + e.getMessage());
        }

        try {
            List<String> lineas = ExcepcionesUtil.leerArchivo("archivo_inexistente.txt");
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }

        try {
            List<String> lineas = ExcepcionesUtil.leerArchivoConRecursos("archivo_inexistente.txt");
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Lectura con try-with-resources fallida: " + e.getMessage());
        }
    }
}
