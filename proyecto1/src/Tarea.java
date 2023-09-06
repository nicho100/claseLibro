import java.time.LocalDate;
public class Tarea {
    private String descripcion;
    private String prioridad;
    private boolean estado;
    private LocalDate fechaLimite;

    public Tarea(String descripcion, String prioridad, LocalDate fechaLimite) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = false; // Incompleta por defecto
        this.fechaLimite = fechaLimite;
    }

    public void modificarDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }

    public void cambiarPrioridad(String nuevaPrioridad) {
        this.prioridad = nuevaPrioridad;
    }

    public void marcarComoCompleta() {
        this.estado = true;
    }

    public boolean estaVencida() {
        if (!estado && LocalDate.now().isAfter(fechaLimite)) {
            return true;
        }
        return false;
    }

    public boolean estaCompleta() {
        return estado;
    }

    public String mostrarTarea() {
        String mensaje = "";
        if (estaVencida() && !estado) {
            mensaje += "(Vencida) ";
        }
        mensaje += descripcion;
        return mensaje;
    }
}
