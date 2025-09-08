public class MainEmpleado {
    public static void main(String[] args) {
        // Crear empleados con distintos constructores
        Empleado emp1 = new Empleado(1, "Carlos Gómez", "Programador", 45000);
        Empleado emp2 = new Empleado("Laura Martínez", "Diseñadora");
        Empleado emp3 = new Empleado("Ana Torres", "Analista");

        // Aplicar aumentos
        emp1.actualizarSalario(10);   // aumento del 10%
        emp2.actualizarSalario(5000); // aumento fijo
        emp3.actualizarSalario(15);   // aumento del 15%

        // Mostrar información de los empleados
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());

        // Mostrar total de empleados creados
        System.out.println("Total de empleados creados: " + Empleado.mostrarTotalEmpleados());
    }
}
