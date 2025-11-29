package tp8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente implements Notificable {
    private final String nombre;
    private final String email;
    private final List<String> notificaciones = new ArrayList<>();

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getNotificaciones() {
        return Collections.unmodifiableList(notificaciones);
    }

    @Override
    public void notificar(String mensaje) {
        notificaciones.add(mensaje);
        System.out.println("Notificación para " + nombre + ": " + mensaje);
    }
}
