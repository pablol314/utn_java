package TP6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Gestiona un conjunto de productos disponibles en stock.
 */
public class Inventario {
    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (buscarProductoPorId(producto.getId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un producto con id " + producto.getId());
        }
        productos.add(producto);
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> buscarProductoPorId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id es obligatorio");
        }
        return productos.stream()
                .filter(producto -> producto.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public boolean eliminarProducto(String id) {
        Optional<Producto> encontrado = buscarProductoPorId(id);
        encontrado.ifPresent(productos::remove);
        return encontrado.isPresent();
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        return buscarProductoPorId(id)
                .map(producto -> {
                    producto.setCantidad(nuevaCantidad);
                    return true;
                })
                .orElse(false);
    }

    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
        return productos.stream()
                .filter(producto -> producto.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    public int obtenerTotalStock() {
        return productos.stream()
                .mapToInt(Producto::getCantidad)
                .sum();
    }

    public Optional<Producto> obtenerProductoConMayorStock() {
        return productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidad));
    }

    public List<Producto> filtrarProductosPorPrecio(double minimo, double maximo) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("El precio mínimo no puede ser mayor al máximo");
        }
        return productos.stream()
                .filter(producto -> producto.getPrecio() >= minimo && producto.getPrecio() <= maximo)
                .collect(Collectors.toList());
    }

    public List<String> mostrarCategoriasDisponibles() {
        List<String> descripciones = new ArrayList<>();
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            descripciones.add(String.format("%s: %s", categoria.name(), categoria.getDescripcion()));
        }
        return descripciones;
    }
}
