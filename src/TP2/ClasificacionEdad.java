import java.util.Scanner;

public class ClasificacionEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        if (edad < 12) {
            System.out.println("Eres un Niño.");
        } else if (edad < 18) {
            System.out.println("Eres un Adolescente.");
        } else if (edad < 60) {
            System.out.println("Eres un Adulto.");
        } else {
            System.out.println("Eres un Adulto mayor.");
        }
    }
}
