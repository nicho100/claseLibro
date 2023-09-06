public class ListaDobleEnlace {
    private Nodo cabeza;
    private Nodo cola;
    private int longitud;
    public ListaDobleEnlace() {
        cabeza = null;
        cola = null;
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
            cola = nuevoNodo;
        } else {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        longitud++;
    }

    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= longitud) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        if (posicion == 0) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
        } else if (posicion == longitud - 1) {
            cola = cola.anterior;
            cola.siguiente = null;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
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
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        } else if (posicion == longitud) {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.siguiente;
            }
            nuevoNodo.anterior = actual;
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente.anterior = nuevoNodo;
            actual.siguiente = nuevoNodo;
        }
        longitud++;
    }
}
