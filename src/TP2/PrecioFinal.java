import java.util.Scanner;

public class PrecioFinal {
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el precio base del producto: ");
        double precioBase = scanner.nextDouble();

        System.out.print("Ingrese el impuesto en porcentaje: ");
        double impuesto = scanner.nextDouble() / 100;

        System.out.print("Ingrese el descuento en porcentaje: ");
        double descuento = scanner.nextDouble() / 100;

        double precioFinal = calcularPrecioFinal(precioBase, impuesto, descuento);

        System.out.println("El precio final del producto es: " + precioFinal);
    }
}
