package TP7;

import java.util.ArrayList;
import java.util.List;

public class Tp7App {
    public static void main(String[] args) {
        System.out.println("--- Vehículos y herencia básica ---");
        Auto auto = new Auto("Toyota", "Corolla", 4);
        System.out.println(auto.mostrarInfo());

        System.out.println("\n--- Figuras geométricas y métodos abstractos ---");
        Figura[] figuras = {
                new Circulo("Círculo principal", 3.5),
                new Rectangulo("Rectángulo central", 4.0, 2.5)
        };
        for (Figura figura : figuras) {
            System.out.printf("Área del %s: %.2f\n", figura.getNombre(), figura.calcularArea());
        }

        System.out.println("\n--- Empleados y polimorfismo ---");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new EmpleadoPlanta("Ana", 150000, 25000));
        empleados.add(new EmpleadoTemporal("Luis", 160, 1200));

        for (Empleado empleado : empleados) {
            System.out.printf("%s cobra %.2f pesos. ", empleado.getNombre(), empleado.calcularSueldo());
            if (empleado instanceof EmpleadoPlanta empleadoPlanta) {
                System.out.printf("(Planta, bono: %.2f)\n", empleadoPlanta.getBonoAntiguedad());
            } else if (empleado instanceof EmpleadoTemporal empleadoTemporal) {
                System.out.printf("(Temporal, horas: %d)\n", empleadoTemporal.getHorasTrabajadas());
            }
        }

        System.out.println("\n--- Animales y comportamiento sobrescrito ---");
        List<Animal> animales = List.of(
                new Perro("Firulais"),
                new Gato("Mishi"),
                new Vaca("Lola")
        );

        for (Animal animal : animales) {
            System.out.printf("%s hace: %s\n", animal.describirAnimal(), animal.hacerSonido());
        }
    }
}
