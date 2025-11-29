package tp8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido implements Pagable {
    private final List<Producto> productos = new ArrayList<>();
    private final Cliente cliente;
    private String estado = "Creado";

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        notificarCambio("Pedido creado");
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public String getEstado() {
        return estado;
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarCambio("Estado actualizado a: " + nuevoEstado);
    }

    private void notificarCambio(String mensaje) {
        if (cliente != null) {
            cliente.notificar(mensaje);
        }
    }

    @Override
    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(Producto::calcularTotal)
                .sum();
    }
}
