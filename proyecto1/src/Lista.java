public class Lista {
    private Nodo cabeza;
    private int longitud;

    public Lista() {
        cabeza = null;
        longitud = 0;
    }

    public boolean estaVacia() {
        return longitud == 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAlFinal(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        longitud++;
    }

    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= longitud) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        if (posicion == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
        longitud--;
    }

    public int obtener(int posicion) {
        if (posicion < 0 || posicion >= longitud) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void insertar(int valor, int posicion) {
        if (posicion < 0 || posicion > longitud) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        Nodo nuevoNodo = new Nodo(valor);
        if (posicion == 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
        longitud++;
    }
}