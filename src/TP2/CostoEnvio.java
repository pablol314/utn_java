import java.util.Scanner;

public class CostoEnvio {
    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10;
        } else {
            return -1;
        }
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = scanner.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = scanner.nextDouble();

        scanner.nextLine(); 
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scanner.nextLine();

        double costoEnvio = calcularCostoEnvio(peso, zona);
        if (costoEnvio == -1) {
            System.out.println("Zona inválida.");
        } else {
            double total = calcularTotalCompra(precioProducto, costoEnvio);
            System.out.println("El costo de envío es: " + costoEnvio);
            System.out.println("El total a pagar es: " + total);
        }
    }
}
