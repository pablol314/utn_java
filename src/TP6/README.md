# UTN Java Ejemplos

Esta carpeta del repositorio contiene la resolución del Trabajo Práctico 6 de Programación II (UTN).
Incluye tres módulos temáticos (Inventario, Biblioteca y Universidad) que se ejecutan de forma
secuencial en la clase [`DemoApp`](src/TP6/DemoApp.java). El README
funciona como entrega final y documenta cada requerimiento acompañado de la salida real de la
consola intercalada paso a paso.

---

## Caso Práctico 1 — Sistema de Inventario

Las entidades viven en [`Producto`](src/TP6/Producto.java) y
[`CategoriaProducto`](src/TP6/CategoriaProducto.java), mientras que la
lógica está concentrada en [`Inventario`](src/TP6/Inventario.java).
La demo corresponde al método `DemoApp.ejecutarInventario()`.

1. **Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.**

   ```bash
   $ mvn exec:java
   === Gestión de Inventario ===
   Listado de productos:
   ID: P001 | Nombre: Notebook | Precio: $250000,00 | Stock: 8 | Categoría: Dispositivos electrónicos
   ID: P002 | Nombre: Campera | Precio: $32000,00 | Stock: 15 | Categoría: Prendas de vestir
   ID: P003 | Nombre: Cafetera | Precio: $18000,00 | Stock: 12 | Categoría: Artículos para el hogar
   ID: P004 | Nombre: Arroz Integral | Precio: $2500,00 | Stock: 40 | Categoría: Productos comestibles
   ID: P005 | Nombre: Auriculares | Precio: $15000,00 | Stock: 25 | Categoría: Dispositivos electrónicos
   ```
   ```java
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
   ```

2. **Listar todos los productos mostrando su información y categoría.**

   ```bash
   Listado de productos:
   ID: P001 | Nombre: Notebook | Precio: $250000,00 | Stock: 8 | Categoría: Dispositivos electrónicos
   ID: P002 | Nombre: Campera | Precio: $32000,00 | Stock: 15 | Categoría: Prendas de vestir
   ID: P003 | Nombre: Cafetera | Precio: $18000,00 | Stock: 12 | Categoría: Artículos para el hogar
   ID: P004 | Nombre: Arroz Integral | Precio: $2500,00 | Stock: 40 | Categoría: Productos comestibles
   ID: P005 | Nombre: Auriculares | Precio: $15000,00 | Stock: 25 | Categoría: Dispositivos electrónicos
   ```
   ```java
   System.out.println("Listado de productos:");
   inventario.listarProductos().forEach(Producto::mostrarInfo);
   ```

3. **Buscar un producto por ID y mostrar su información.**

   ```bash
   Buscar producto por ID (P003):
   ID: P003 | Nombre: Cafetera | Precio: $18000,00 | Stock: 12 | Categoría: Artículos para el hogar
   ```
   ```java
   System.out.println("\nBuscar producto por ID (P003):");
   inventario.buscarProductoPorId("P003").ifPresent(Producto::mostrarInfo);
   ```

4. **Filtrar y mostrar productos por categoría.**

   ```bash
   Productos de la categoría ELECTRONICA:
   ID: P001 | Nombre: Notebook | Precio: $250000,00 | Stock: 8 | Categoría: Dispositivos electrónicos
   ID: P005 | Nombre: Auriculares | Precio: $15000,00 | Stock: 25 | Categoría: Dispositivos electrónicos
   ```
   ```java
   System.out.println("\nProductos de la categoría ELECTRONICA:");
   inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA).forEach(Producto::mostrarInfo);
   ```

5. **Eliminar un producto por su ID y listar los restantes.**

   ```bash
   Eliminar producto P002:
   ID: P001 | Nombre: Notebook | Precio: $250000,00 | Stock: 8 | Categoría: Dispositivos electrónicos
   ID: P003 | Nombre: Cafetera | Precio: $18000,00 | Stock: 12 | Categoría: Artículos para el hogar
   ID: P004 | Nombre: Arroz Integral | Precio: $2500,00 | Stock: 40 | Categoría: Productos comestibles
   ID: P005 | Nombre: Auriculares | Precio: $15000,00 | Stock: 25 | Categoría: Dispositivos electrónicos
   ```
   ```java
   System.out.println("\nEliminar producto P002:");
   inventario.eliminarProducto("P002");
   inventario.listarProductos().forEach(Producto::mostrarInfo);
   ```

6. **Actualizar el stock de un producto existente.**

    ```bash
    Actualizar stock del producto P001 a 5 unidades:
    ID: P001 | Nombre: Notebook | Precio: $250000,00 | Stock: 5 | Categoría: Dispositivos electrónicos
    ```
    ```java
    System.out.println("\nActualizar stock del producto P001 a 5 unidades:");
    inventario.actualizarStock("P001", 5);
    inventario.buscarProductoPorId("P001").ifPresent(Producto::mostrarInfo);
    ```

7. **Mostrar el total de stock disponible.**

   ```bash
   Total de stock disponible: 82 unidades
   ```
   ```java
   System.out.printf("\nTotal de stock disponible: %d unidades%n", inventario.obtenerTotalStock());
   ```

8. **Obtener y mostrar el producto con mayor stock.**

   ```bash
   Producto con mayor stock: ID: P004 | Nombre: Arroz Integral | Precio: $2500,00 | Stock: 40 | Categoría: Productos comestibles
   ```
   ```java
   inventario.obtenerProductoConMayorStock().ifPresent(producto -> {
       System.out.print("Producto con mayor stock: ");
       producto.mostrarInfo();
   });
   ```

9. **Filtrar productos por rango de precios (1000 a 3000).**

   ```bash
   Productos con precios entre $1000 y $30000:
   ID: P003 | Nombre: Cafetera | Precio: $18000,00 | Stock: 12 | Categoría: Artículos para el hogar
   ID: P004 | Nombre: Arroz Integral | Precio: $2500,00 | Stock: 40 | Categoría: Productos comestibles
   ID: P005 | Nombre: Auriculares | Precio: $15000,00 | Stock: 25 | Categoría: Dispositivos electrónicos
   ```
   ```java
   System.out.println("\nProductos con precios entre $1000 y $30000:");
   inventario.filtrarProductosPorPrecio(1000, 30000).forEach(Producto::mostrarInfo);
   ```

10. **Mostrar las categorías disponibles con sus descripciones.**

    ```bash
    Categorías disponibles:
    ALIMENTOS: Productos comestibles
    ELECTRONICA: Dispositivos electrónicos
    ROPA: Prendas de vestir
    HOGAR: Artículos para el hogar
    ```
    ```java
    System.out.println("\nCategorías disponibles:");
    inventario.mostrarCategoriasDisponibles().forEach(System.out::println);
    ```

**Conclusiones del caso:** Se refuerza el uso de `this`, constructores especializados, métodos sobrecargados,
`toString()`, miembros estáticos y encapsulamiento mediante colecciones dinámicas.

---

## Nuevo Ejercicio Propuesto 2 — Biblioteca y Libros

Las clases principales son [`Autor`](src/TP6/Autor.java),
[`Libro`](src/TP6/Libro.java) y [`Biblioteca`](src/TP6/Biblioteca.java).
La lógica demostrativa está en `DemoApp.ejecutarBiblioteca()`.

1. **Crear la biblioteca.**

   ```bash
   === Biblioteca ===
   ```
   ```java
   System.out.println("=== Biblioteca ===");
   Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

   Autor autor1 = new Autor("A1", "Julio Cortázar", "Argentina");
   Autor autor2 = new Autor("A2", "Isabel Allende", "Chile");
   Autor autor3 = new Autor("A3", "Stephen King", "Estados Unidos");
   ```

2. **Crear al menos tres autores.**

   ```bash
   ISBN: ISBN001 | Título: Rayuela | Año: 1963 | Autor: Julio Cortázar
   ISBN: ISBN002 | Título: Casa de los Espíritus | Año: 1982 | Autor: Isabel Allende
   ISBN: ISBN003 | Título: It | Año: 1986 | Autor: Stephen King
   ```
   ```java
   biblioteca.agregarLibro("ISBN001", "Rayuela", 1963, autor1);
   biblioteca.agregarLibro("ISBN002", "Casa de los Espíritus", 1982, autor2);
   biblioteca.agregarLibro("ISBN003", "It", 1986, autor3);
   ```

3. **Agregar cinco libros a la biblioteca.**

   ```bash
   Listado de libros:
   ISBN: ISBN001 | Título: Rayuela | Año: 1963 | Autor: Julio Cortázar
   ISBN: ISBN002 | Título: Casa de los Espíritus | Año: 1982 | Autor: Isabel Allende
   ISBN: ISBN003 | Título: It | Año: 1986 | Autor: Stephen King
   ISBN: ISBN004 | Título: Bestiario | Año: 1951 | Autor: Julio Cortázar
   ISBN: ISBN005 | Título: El Visitante | Año: 2018 | Autor: Stephen King
   ```
   ```java
   biblioteca.agregarLibro("ISBN004", "Bestiario", 1951, autor1);
   biblioteca.agregarLibro("ISBN005", "El Visitante", 2018, autor3);

   System.out.println("Listado de libros:");
   biblioteca.listarLibros().forEach(Libro::mostrarInfo);
   ```

4. **Listar todos los libros con su información y la del autor.**

   ```bash
   Listado de libros:
   ISBN: ISBN001 | Título: Rayuela | Año: 1963 | Autor: Julio Cortázar
   ISBN: ISBN002 | Título: Casa de los Espíritus | Año: 1982 | Autor: Isabel Allende
   ISBN: ISBN003 | Título: It | Año: 1986 | Autor: Stephen King
   ISBN: ISBN004 | Título: Bestiario | Año: 1951 | Autor: Julio Cortázar
   ISBN: ISBN005 | Título: El Visitante | Año: 2018 | Autor: Stephen King
   ```
   ```java
   System.out.println("Listado de libros:");
   biblioteca.listarLibros().forEach(Libro::mostrarInfo);
   ```

5. **Buscar un libro por su ISBN y mostrar su información.**

   ```bash
   Buscar libro por ISBN (ISBN003):
   ISBN: ISBN003 | Título: It | Año: 1986 | Autor: Stephen King
   ```
   ```java
   System.out.println("\nBuscar libro por ISBN (ISBN003):");
   biblioteca.buscarLibroPorIsbn("ISBN003").ifPresent(Libro::mostrarInfo);
   ```

6. **Filtrar y mostrar libros publicados en un año específico.**

   ```bash
   Libros publicados en 1986:
   ISBN: ISBN003 | Título: It | Año: 1986 | Autor: Stephen King
   ```
   ```java
   System.out.println("\nLibros publicados en 1986:");
   biblioteca.filtrarLibrosPorAnio(1986).forEach(Libro::mostrarInfo);
   ```

7. **Eliminar un libro por su ISBN y listar los restantes.**

   ```bash
   Eliminar libro ISBN002:
   ISBN: ISBN001 | Título: Rayuela | Año: 1963 | Autor: Julio Cortázar
   ISBN: ISBN003 | Título: It | Año: 1986 | Autor: Stephen King
   ISBN: ISBN004 | Título: Bestiario | Año: 1951 | Autor: Julio Cortázar
   ISBN: ISBN005 | Título: El Visitante | Año: 2018 | Autor: Stephen King
   ```
   ```java
   System.out.println("\nEliminar libro ISBN002:");
   biblioteca.eliminarLibro("ISBN002");
   biblioteca.listarLibros().forEach(Libro::mostrarInfo);
   ```

8. **Mostrar la cantidad total de libros en la biblioteca.**

   ```bash
   Cantidad total de libros: 4
   ```
   ```java
   System.out.printf("\nCantidad total de libros: %d%n", biblioteca.obtenerCantidadLibros());
   ```

9. **Listar todos los autores disponibles en la biblioteca.**

   ```bash
   Autores disponibles:
   Autor A3 - Stephen King (Estados Unidos)
   Autor A1 - Julio Cortázar (Argentina)
   ```
   ```java
   System.out.println("\nAutores disponibles:");
   biblioteca.mostrarAutoresDisponibles().forEach(Autor::mostrarInfo);
   ```

**Conclusiones del caso:** Se afianza la composición 1 a N, el manejo de `ArrayList`, métodos de
búsqueda/filtrado y modularidad orientada a objetos.

---

## Ejercicio — Universidad, Profesor y Curso (relación bidireccional 1 a N)

La capa de dominio se compone de [`Profesor`](src/TP6/Profesor.java),
[`Curso`](src/TP6/Curso.java) y [`Universidad`](src/TP6/Universidad.java).
La demostración está en `DemoApp.ejecutarUniversidad()`.

1. **Crear al menos tres profesores y cinco cursos.**

   ```bash
   === Universidad ===
   ```
   ```java
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
   ```

2. **Agregar profesores y cursos a la universidad.**

   ```bash
   Cursos con su profesor asignado:
   Curso C1 - Programación II | Profesor: Ana López
   Curso C2 - Análisis Matemático | Profesor: Carlos Pérez
   Curso C3 - Arquitectura de Computadoras | Profesor: Ana López
   Curso C4 - Bases de Datos | Profesor: María Gómez
   Curso C5 - Sistemas Operativos | Profesor: Carlos Pérez
   ```
   ```java
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
   ```

3. **Asignar profesores a cursos mediante `asignarProfesorACurso`.**

   ```bash
   Cursos con su profesor asignado:
   Curso C1 - Programación II | Profesor: Ana López
   Curso C2 - Análisis Matemático | Profesor: Carlos Pérez
   Curso C3 - Arquitectura de Computadoras | Profesor: Ana López
   Curso C4 - Bases de Datos | Profesor: María Gómez
   Curso C5 - Sistemas Operativos | Profesor: Carlos Pérez
   ```
   ```java
   System.out.println("Cursos con su profesor asignado:");
   universidad.listarCursos().forEach(Curso::mostrarInfo);
   ```

4. **Listar cursos con su profesor y profesores con sus cursos.**

   ```bash
   Profesores y cursos que dictan:
   Profesor PR1 - Ana López | Especialidad: Programación | Cursos: 2
   Cursos dictados por Ana López:
   - C1 (Programación II)
   - C3 (Arquitectura de Computadoras)
   Profesor PR2 - Carlos Pérez | Especialidad: Matemática | Cursos: 2
   Cursos dictados por Carlos Pérez:
   - C2 (Análisis Matemático)
   - C5 (Sistemas Operativos)
   Profesor PR3 - María Gómez | Especialidad: Bases de Datos | Cursos: 1
   Cursos dictados por María Gómez:
   - C4 (Bases de Datos)
   ```
   ```java
   System.out.println("\nProfesores y cursos que dictan:");
   universidad.listarProfesores().forEach(profesor -> {
       profesor.mostrarInfo();
       profesor.listarCursos();
   });
   ```

5. **Cambiar el profesor de un curso y verificar sincronización.**

   ```bash
   Cambiar profesor del curso C3 a PR3:
   Curso C3 - Arquitectura de Computadoras | Profesor: María Gómez
   Cursos dictados por Ana López:
   - C1 (Programación II)
   Cursos dictados por María Gómez:
   - C4 (Bases de Datos)
   - C3 (Arquitectura de Computadoras)
   ```
   ```java
   System.out.println("\nCambiar profesor del curso C3 a PR3:");
   universidad.asignarProfesorACurso("C3", "PR3");
   universidad.buscarCursoPorCodigo("C3").ifPresent(Curso::mostrarInfo);
   universidad.buscarProfesorPorId("PR1").ifPresent(Profesor::listarCursos);
   universidad.buscarProfesorPorId("PR3").ifPresent(Profesor::listarCursos);
   ```

6. **Eliminar un curso y confirmar que no permanece en la lista del profesor.**

   ```bash
   Eliminar curso C2:
   Curso C1 - Programación II | Profesor: Ana López
   Curso C3 - Arquitectura de Computadoras | Profesor: María Gómez
   Curso C4 - Bases de Datos | Profesor: María Gómez
   Curso C5 - Sistemas Operativos | Profesor: Carlos Pérez
   Cursos dictados por Carlos Pérez:
   - C5 (Sistemas Operativos)
   ```
   ```java
   System.out.println("\nEliminar curso C2:");
   universidad.eliminarCurso("C2");
   universidad.listarCursos().forEach(Curso::mostrarInfo);
   universidad.buscarProfesorPorId("PR2").ifPresent(Profesor::listarCursos);
   ```

7. **Eliminar un profesor y dejar sin asignar los cursos que dictaba.**

   ```bash
   Eliminar profesor PR1:
   Profesor PR2 - Carlos Pérez | Especialidad: Matemática | Cursos: 1
   Profesor PR3 - María Gómez | Especialidad: Bases de Datos | Cursos: 2
   Curso C1 - Programación II | Profesor: Sin asignar
   Curso C3 - Arquitectura de Computadoras | Profesor: María Gómez
   Curso C4 - Bases de Datos | Profesor: María Gómez
   Curso C5 - Sistemas Operativos | Profesor: Carlos Pérez
   ```
   ```java
   System.out.println("\nEliminar profesor PR1:");
   universidad.eliminarProfesor("PR1");
   universidad.listarProfesores().forEach(Profesor::mostrarInfo);
   universidad.listarCursos().forEach(Curso::mostrarInfo);
   ```

8. **Mostrar un reporte con la cantidad de cursos por profesor.**

   ```bash
   Reporte: cantidad de cursos por profesor restante:
   Carlos Pérez dicta 1 curso(s)
   María Gómez dicta 2 curso(s)
   ```
   ```java
   System.out.println("\nReporte: cantidad de cursos por profesor restante:");
   List<Profesor> profesoresRestantes = universidad.listarProfesores();
   for (Profesor profesor : profesoresRestantes) {
       System.out.printf("%s dicta %d curso(s)%n", profesor.getNombre(), profesor.getCursos().size());
   }
   ```
**Conclusiones del caso:** Se diferencia la bidireccionalidad, se mantienen invariantes de asociación,
se practica el uso de `ArrayList` y se diseñan métodos seguros para sincronizar relaciones.

---


