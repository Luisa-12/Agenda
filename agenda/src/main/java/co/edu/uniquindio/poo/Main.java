package co.edu.uniquindio.poo;


public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        datosQuemados(agenda);

        agenda.ejecutar();

    }


    private static void datosQuemados (Agenda agenda){

        // Crear contactos
        Contacto contacto1 = new Contacto("Juan Perez", "Juan", "Calle Falsa 123", "555-1234", "juan@com");
        Contacto contacto2 = new Contacto("Ana Garcia", "Ana", "Calle Real 456", "555-5678", "ana@com");
        Contacto contacto3 = new Contacto("Maria Lopez", "Maria", "Avenida Siempre Viva 789", "555-9101", "maria@com");
        agenda.getContactos().add(contacto1);
        agenda.getContactos().add(contacto2);
        agenda.getContactos().add(contacto3);

        // Crear y agregar grupos
        Grupo grupo1 = new Grupo("Amigos", Categoria.AMIGOS);
        Grupo grupo2 = new Grupo("Trabajo", Categoria.OFICINA);
        agenda.getGrupos().add(grupo1);
        agenda.getGrupos().add(grupo2);

        // Crear y agregar reuniones
        Reunion reunion1 = new Reunion("Reunión de planificación","Es solo una planificacion", "2024-09-10", "10:00");
        Reunion reunion2 = new Reunion("Reunión de seguimiento", "Es un seguimiento","2024-09-15", "14:00");
        agenda.getReuniones().add(reunion1);
        agenda.getReuniones().add(reunion2);
    }

}

