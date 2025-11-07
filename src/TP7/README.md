# Trabajo Práctico 7 — Herencia y Polimorfismo

El siguiente recorrido documenta los cuatro ejercicios solicitados para el TP7 ejecutando Tp7App.java


---

## 1. Vehículos y herencia básica

```java
System.out.println("--- Vehículos y herencia básica ---");
Auto auto = new Auto("Toyota", "Corolla", 4);
System.out.println(auto.mostrarInfo());
```

```text
--- Vehículos y herencia básica ---
Vehículo Toyota Corolla, puertas: 4
```

---

## 2. Figuras geométricas y métodos abstractos

```java
System.out.println("\n--- Figuras geométricas y métodos abstractos ---");
Figura[] figuras = {
        new Circulo("Círculo principal", 3.5),
        new Rectangulo("Rectángulo central", 4.0, 2.5)
};
for (Figura figura : figuras) {
    System.out.printf("Área del %s: %.2f\n", figura.getNombre(), figura.calcularArea());
}
```

```text
--- Figuras geométricas y métodos abstractos ---
Área del Círculo principal: 38.48
Área del Rectángulo central: 10.00
```

---

## 3. Empleados y polimorfismo

```java
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
```

```text
--- Empleados y polimorfismo ---
Ana cobra 175000.00 pesos. (Planta, bono: 25000.00)
Luis cobra 192000.00 pesos. (Temporal, horas: 160)
```

---

## 4. Animales y comportamiento sobrescrito

```java
System.out.println("\n--- Animales y comportamiento sobrescrito ---");
List<Animal> animales = List.of(
        new Perro("Firulais"),
        new Gato("Mishi"),
        new Vaca("Lola")
);

for (Animal animal : animales) {
    System.out.printf("%s hace: %s\n", animal.describirAnimal(), animal.hacerSonido());
}
```

```text
--- Animales y comportamiento sobrescrito ---
Animal: Firulais hace: Guau
Animal: Mishi hace: Miau
Animal: Lola hace: Muuu
```

---

## Conclusiones

* Se ejemplifica herencia con `Vehiculo` → `Auto`.
* Se ejercitan clases y métodos abstractos mediante `Figura`, `Circulo` y `Rectangulo`.
* Se ilustra polimorfismo con la jerarquía `Empleado`.
* Se demuestra sobrescritura de comportamiento con `Animal` y sus subclases.
