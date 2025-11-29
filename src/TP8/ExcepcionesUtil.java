package tp8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ExcepcionesUtil {
    private ExcepcionesUtil() {
    }

    public static int dividirSeguro(int numerador, int divisor) {
        try {
            return numerador / divisor;
        } catch (ArithmeticException ex) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
    }

    public static int convertirCadenaANumero(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException("No se pudo convertir \"" + texto + "\" a entero");
        }
    }

    public static List<String> leerArchivo(String ruta) throws IOException {
        BufferedReader reader = null;
        List<String> lineas = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            return lineas;
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Archivo no encontrado: " + ruta);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                    // Ignorar errores al cerrar
                }
            }
        }
    }

    public static List<String> leerArchivoConRecursos(String ruta) throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            return lineas;
        }
    }

    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad " + edad + " está fuera del rango permitido");
        }
    }
}
