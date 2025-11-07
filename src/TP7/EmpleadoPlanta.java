package TP7;

public class EmpleadoPlanta extends Empleado {
    private final double salarioBase;
    private final double bonoAntiguedad;

    public EmpleadoPlanta(String nombre, double salarioBase, double bonoAntiguedad) {
        super(nombre);
        this.salarioBase = salarioBase;
        this.bonoAntiguedad = bonoAntiguedad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBonoAntiguedad() {
        return bonoAntiguedad;
    }

    @Override
    public double calcularSueldo() {
        return salarioBase + bonoAntiguedad;
    }
}
