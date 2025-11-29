# TP 8: Interfaces y Excepciones

## Parte 1: Sistema de E-commerce
- **Pagable** define el contrato `calcularTotal()`.
- **Producto** implementa `Pagable` y devuelve su precio.
- **Pedido** mantiene una lista de productos, calcula el total y notifica cambios de estado al **Cliente** (que implementa **Notificable**).
- **Pago** y **PagoConDescuento** definen los métodos de cobro y aplicación de descuentos. **TarjetaCredito** y **PayPal** muestran herencia múltiple por interfaces.
- **Tp8App** crea un cliente, un pedido con productos y procesa el pago aplicando descuento, notificando al cliente y mostrando el cambio de estado.

## Parte 2: Ejercicios de Excepciones
- **dividirSeguro**: valida la división entre enteros y relanza `ArithmeticException` si el divisor es 0.
- **convertirCadenaANumero**: transforma texto a `int`, detallando el error con `NumberFormatException`.
- **leerArchivo**: lee un archivo y captura `FileNotFoundException`; cierra recursos en `finally`.
- **validarEdad**: lanza la excepción personalizada `EdadInvalidaException` cuando la edad está fuera del rango 0-120.
- **leerArchivoConRecursos**: usa *try-with-resources* para cerrar automáticamente el `BufferedReader` y propaga `IOException`.

## Ejecución
1. Desde la raíz del proyecto: `mvn -q -DskipTests compile`
2. Ejecutar el ejemplo: `mvn -q exec:java -Dexec.mainClass="tp8.Tp8App"`

La salida muestra el cálculo del total del pedido, el pago con descuento aplicado, las notificaciones al cliente y los distintos escenarios de manejo de excepciones.
