public class Empleado {
    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    // Atributo estático para contar empleados
    private static int totalEmpleados = 0;

    // Constructor que recibe todos los atributos
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    // Constructor sobrecargado (solo nombre y puesto)
    public Empleado(String nombre, String puesto) {
        this.id = ++totalEmpleados;  // id automático
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 30000; // salario por defecto
    }

    // Métodos sobrecargados actualizarSalario
    public void actualizarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100);
    }

    public void actualizarSalario(int cantidadFija) {
        this.salario += cantidadFija;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) { this.salario = salario; }

    // Método estático
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // toString() sobrescrito
    @Override
    public String toString() {
        return "Empleado [ID: " + id + ", Nombre: " + nombre + 
               ", Puesto: " + puesto + ", Salario: $" + salario + "]";
    }
}
