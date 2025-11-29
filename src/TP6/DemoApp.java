package TP6;

import java.util.List;

/**
 * Clase de entrada para demostrar las capacidades de inventario, biblioteca y universidad.
 */
public class DemoApp {
    public static void main(String[] args) {
        ejecutarInventario();
        ejecutarBiblioteca();
        ejecutarUniversidad();
    }

    private static void ejecutarInventario() {
        System.out.println("=== Gestión de Inventario ===");
        Inventario inventario = new Inventario();

        Producto prod1 = new Producto("P001", "Notebook", 250000, 8, CategoriaProducto.ELECTRONICA);
        Producto prod2 = new Producto("P002", "Campera", 32000, 15, CategoriaProducto.ROPA);
        Producto prod3 = new Producto("P003", "Cafetera", 18000, 12, CategoriaProducto.HOGAR);
        Producto prod4 = new Producto("P004", "Arroz Integral", 2500, 40, CategoriaProducto.ALIMENTOS);
        Producto prod5 = new Producto("P005", "Auriculares", 15000, 25, CategoriaProducto.ELECTRONICA);

        inventario.agregarProducto(prod1);
        inventario.agregarProducto(prod2);
        inventario.agregarProducto(prod3);
        inventario.agregarProducto(prod4);
        inventario.agregarProducto(prod5);

        System.out.println("Listado de productos:");
        inventario.listarProductos().forEach(Producto::mostrarInfo);

        System.out.println("\nBuscar producto por ID (P003):");
        inventario.buscarProductoPorId("P003").ifPresent(Producto::mostrarInfo);

        System.out.println("\nProductos de la categoría ELECTRONICA:");
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA).forEach(Producto::mostrarInfo);

        System.out.println("\nEliminar producto P002:");
        inventario.eliminarProducto("P002");
        inventario.listarProductos().forEach(Producto::mostrarInfo);

        System.out.println("\nActualizar stock del producto P001 a 5 unidades:");
        inventario.actualizarStock("P001", 5);
        inventario.buscarProductoPorId("P001").ifPresent(Producto::mostrarInfo);

        System.out.printf("\nTotal de stock disponible: %d unidades%n", inventario.obtenerTotalStock());

        inventario.obtenerProductoConMayorStock().ifPresent(producto -> {
            System.out.print("Producto con mayor stock: ");
            producto.mostrarInfo();
        });

        System.out.println("\nProductos con precios entre $1000 y $30000:");
        inventario.filtrarProductosPorPrecio(1000, 30000).forEach(Producto::mostrarInfo);

        System.out.println("\nCategorías disponibles:");
        inventario.mostrarCategoriasDisponibles().forEach(System.out::println);
        System.out.println();
    }

    private static void ejecutarBiblioteca() {
        System.out.println("=== Biblioteca ===");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        Autor autor1 = new Autor("A1", "Julio Cortázar", "Argentina");
        Autor autor2 = new Autor("A2", "Isabel Allende", "Chile");
        Autor autor3 = new Autor("A3", "Stephen King", "Estados Unidos");

        biblioteca.agregarLibro("ISBN001", "Rayuela", 1963, autor1);
        biblioteca.agregarLibro("ISBN002", "Casa de los Espíritus", 1982, autor2);
        biblioteca.agregarLibro("ISBN003", "It", 1986, autor3);
        biblioteca.agregarLibro("ISBN004", "Bestiario", 1951, autor1);
        biblioteca.agregarLibro("ISBN005", "El Visitante", 2018, autor3);

        System.out.println("Listado de libros:");
        biblioteca.listarLibros().forEach(Libro::mostrarInfo);

        System.out.println("\nBuscar libro por ISBN (ISBN003):");
        biblioteca.buscarLibroPorIsbn("ISBN003").ifPresent(Libro::mostrarInfo);

        System.out.println("\nLibros publicados en 1986:");
        biblioteca.filtrarLibrosPorAnio(1986).forEach(Libro::mostrarInfo);

        System.out.println("\nEliminar libro ISBN002:");
        biblioteca.eliminarLibro("ISBN002");
        biblioteca.listarLibros().forEach(Libro::mostrarInfo);

        System.out.printf("\nCantidad total de libros: %d%n", biblioteca.obtenerCantidadLibros());

        System.out.println("\nAutores disponibles:");
        biblioteca.mostrarAutoresDisponibles().forEach(Autor::mostrarInfo);
        System.out.println();
    }

    private static void ejecutarUniversidad() {
        System.out.println("=== Universidad ===");
        Universidad universidad = new Universidad("UTN");

        Profesor profesor1 = new Profesor("PR1", "Ana López", "Programación");
        Profesor profesor2 = new Profesor("PR2", "Carlos Pérez", "Matemática");
        Profesor profesor3 = new Profesor("PR3", "María Gómez", "Bases de Datos");

        Curso curso1 = new Curso("C1", "Programación II");
        Curso curso2 = new Curso("C2", "Análisis Matemático");
        Curso curso3 = new Curso("C3", "Arquitectura de Computadoras");
        Curso curso4 = new Curso("C4", "Bases de Datos");
        Curso curso5 = new Curso("C5", "Sistemas Operativos");

        universidad.agregarProfesor(profesor1);
        universidad.agregarProfesor(profesor2);
        universidad.agregarProfesor(profesor3);

        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);

        universidad.asignarProfesorACurso("C1", "PR1");
        universidad.asignarProfesorACurso("C2", "PR2");
        universidad.asignarProfesorACurso("C3", "PR1");
        universidad.asignarProfesorACurso("C4", "PR3");
        universidad.asignarProfesorACurso("C5", "PR2");

        System.out.println("Cursos con su profesor asignado:");
        universidad.listarCursos().forEach(Curso::mostrarInfo);

        System.out.println("\nProfesores y cursos que dictan:");
        universidad.listarProfesores().forEach(profesor -> {
            profesor.mostrarInfo();
            profesor.listarCursos();
        });

        System.out.println("\nCambiar profesor del curso C3 a PR3:");
        universidad.asignarProfesorACurso("C3", "PR3");
        universidad.buscarCursoPorCodigo("C3").ifPresent(Curso::mostrarInfo);
        universidad.buscarProfesorPorId("PR1").ifPresent(Profesor::listarCursos);
        universidad.buscarProfesorPorId("PR3").ifPresent(Profesor::listarCursos);

        System.out.println("\nEliminar curso C2:");
        universidad.eliminarCurso("C2");
        universidad.listarCursos().forEach(Curso::mostrarInfo);
        universidad.buscarProfesorPorId("PR2").ifPresent(Profesor::listarCursos);

        System.out.println("\nEliminar profesor PR1:");
        universidad.eliminarProfesor("PR1");
        universidad.listarProfesores().forEach(Profesor::mostrarInfo);
        universidad.listarCursos().forEach(Curso::mostrarInfo);

        System.out.println("\nReporte: cantidad de cursos por profesor restante:");
        List<Profesor> profesoresRestantes = universidad.listarProfesores();
        for (Profesor profesor : profesoresRestantes) {
            System.out.printf("%s dicta %d curso(s)%n", profesor.getNombre(), profesor.getCursos().size());
        }
        System.out.println();
    }
}
