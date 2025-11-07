package TP7;

public class Auto extends Vehiculo {
    private final int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", puertas: " + cantidadPuertas;
    }
}
