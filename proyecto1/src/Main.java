// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1000, 5);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 500, 1);

        System.out.println(libro1);
        System.out.println(libro2);

        if (libro1.getNumPaginas() > libro2.getNumPaginas()) {
            System.out.println("El libro \"" + libro1.getTitulo() + "\" tiene más páginas.");
        } else if (libro2.getNumPaginas() > libro1.getNumPaginas()) {
            System.out.println("El libro \"" + libro2.getTitulo() + "\" tiene más páginas.");
        } else {
            System.out.println("Ambos libros tienen la misma cantidad de páginas.");
        }
        //prestar libros con varios ejemplares y otro con 1 ejemplar
        boolean prestamoExitosoLibro1 = libro1.prestar();
        boolean prestamoExitosoLibro2 = libro2.prestar();
        System.out.println("Préstamo exitoso para libro 1: " + prestamoExitosoLibro1);
        System.out.println("Préstamo exitoso para libro 2: " + prestamoExitosoLibro2);
        //prestamos hechos
        System.out.println("Total de préstamos realizados: " + Libro.getTotalPrestamos());
    }
}