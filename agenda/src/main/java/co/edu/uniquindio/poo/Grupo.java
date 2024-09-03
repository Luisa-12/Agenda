package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Grupo{
    private String nombre;
    private Categoria categoria;
    private List<Contacto> contactos;

    //Constructor de la clase grupo
    public Grupo(String nombre, Categoria categoria){
        this.nombre=nombre;
        this.categoria=categoria;
        this.contactos=new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }



       // Métodos para agregar contactos
       public boolean agregarContacto(Contacto contacto) {
           if (contactos.size() >= 5) {
               System.out.println("Cantidad de contacto en el grupo lleno");
               return false; // No se pueden agregar más de 5 contactos
           }
           if (contactos.contains(contacto)) {
               return false; // El contacto ya existe en la lista
           }
           contactos.add(contacto);
           return true; // Contacto agregado exitosamente
       }


    public boolean eliminarContacto(Contacto contacto) {
        return contactos.remove(contacto);
    }

        // Método para mostrar información del grupo


    @Override
    public String toString() {
        return "Grupo{" +
                "nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", contactos=" + contactos +
                '}';
    }
}
