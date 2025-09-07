import java.util.Scanner;

public class Stock {
    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el stock actual: ");
        int stockActual = scanner.nextInt();

        System.out.print("Ingrese la cantidad vendida: ");
        int vendida = scanner.nextInt();

        System.out.print("Ingrese la cantidad recibida: ");
        int recibida = scanner.nextInt();

        int nuevoStock = actualizarStock(stockActual, vendida, recibida);
        System.out.println("El nuevo stock del producto es: " + nuevoStock);
    }
}
