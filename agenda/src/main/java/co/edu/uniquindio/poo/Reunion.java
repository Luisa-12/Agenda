package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Reunion {

    private String nombre;
    private String descripcion;
    private String fecha;
    private String hora;
    private List<Contacto> asistentes;
    
    //Consturctor de la clase Reunion
    public Reunion(String nombre,String descripcion, String fecha, String hora) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.asistentes = new ArrayList<>();
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Contacto> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Contacto> asistentes) { this.asistentes = asistentes; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    // Métodos para agregar y eliminar asistentes
    public boolean agregarAsistente(Contacto contacto) {
        if (!asistentes.contains(contacto)) {
            asistentes.add(contacto);
            return true;
        }
        return false;
    }

    // Método para mostrar información de la reunión
    @Override
    public String toString() {
        return "Reunion{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", asistentes=" + asistentes +
                '}';
    }
}
