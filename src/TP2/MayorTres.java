import java.util.Scanner;

public class MayorTres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int c = scanner.nextInt();

        int mayor = a;
        if (b > mayor) mayor = b;
        if (c > mayor) mayor = c;

        System.out.println("El mayor es: " + mayor);
    }
}
