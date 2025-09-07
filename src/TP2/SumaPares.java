import java.util.Scanner;

public class SumaPares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int suma = 0, num;
        do {
            System.out.print("Ingrese un número (0 para terminar): ");
            num = scanner.nextInt();
            if (num % 2 == 0) suma += num;
        } while (num != 0);

        System.out.println("La suma de los números pares es: " + suma);
    }
}
