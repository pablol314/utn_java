class Autor {
    String nombre;
    String nacionalidad;
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
}

class Editorial {
    String nombre;
    String direccion;
    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}

class Libro {
    String titulo;
    String isbn;
    Autor autor;
    Editorial editorial;

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }
}

public class LibroMain {
    public static void main(String[] args) {
        Autor a = new Autor("Gabriel García Márquez", "Colombiano");
        Editorial e = new Editorial("Sudamericana", "Buenos Aires");
        Libro l = new Libro("Cien años de soledad", "123-456", a, e);
        System.out.println("Libro: " + l.titulo + " de " + l.autor.nombre);
    }
}
