public class Libro {
    private String titulo;
    private String autor;
    private int numPaginas;
    private int numEjemplares;
    private int numEjemplaresPrestados;

    // Contador estático para llevar un seguimiento de todos los préstamos realizados
    private static int totalPrestamos = 0;

    public Libro(String titulo, String autor, int numPaginas, int numEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.numEjemplares = numEjemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public int getNumEjemplaresPrestados() {
        return numEjemplaresPrestados;
    }

    public boolean prestar() {
        if (numEjemplares >1) {
            numEjemplaresPrestados++;
            totalPrestamos++;
            return true;
        }
        return false;
    }

    public void devolver() {
        if (numEjemplaresPrestados > 0) {
            numEjemplaresPrestados--;
        }
    }

    public static int getTotalPrestamos() {
        return totalPrestamos;
    }

    @Override
    public String toString() {
        return "El libro \"" + titulo + "\" creado por el autor " + autor +
                " tiene " + numPaginas + " páginas, quedan " +
                (numEjemplares - numEjemplaresPrestados) + " disponibles y se prestaron " +
                numEjemplaresPrestados + ".";
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1000, 5);
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", 500, 3);

        libro1.prestar();
        libro1.prestar();
        libro2.prestar();

        System.out.println(libro1);
        System.out.println(libro2);

        libro1.devolver();
        libro2.devolver();

        System.out.println("Total de préstamos realizados: " + Libro.getTotalPrestamos());
    }
}
