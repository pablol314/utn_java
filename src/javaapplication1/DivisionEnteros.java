import java.util.Scanner;

public class DivisionEnteros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número entero: ");
        int a = scanner.nextInt();

        System.out.print("Ingresa el segundo número entero: ");
        int b = scanner.nextInt();

        if (b != 0) {
            System.out.println("Resultado (int): " + (a / b));
        } else {
            System.out.println("No se puede dividir entre 0.");
        }
    }
}
