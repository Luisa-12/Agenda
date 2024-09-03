package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Agenda {


    /**
     * Listas de los objetos.
     */
    private static List<Contacto> contactos = new ArrayList<>();
    private static List<Grupo> grupos = new ArrayList<>();
    private static List<Reunion> reuniones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public List<Contacto> getContactos() { return contactos; }

    public void setContactos(List<Contacto> contactos) { Agenda.contactos = contactos; }

    public List<Grupo> getGrupos() { return grupos; }

    public void setGrupos(List<Grupo> grupos) { Agenda.grupos = grupos; }

    public List<Reunion> getReuniones() { return reuniones; }

    public void setReuniones(List<Reunion> reuniones) { Agenda.reuniones = reuniones;}


    /**
     * Metodo para volver aplicativo la clases.
     */
    public void ejecutar() {

        // Variable booleana para mantener el aplicativo en ejecucion.
        boolean running = true;

        // Bucle principal
        while (running) {
            // Menu de opciones del usuario
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Modificar Contacto");
            System.out.println("4. Crear Grupo");
            System.out.println("5. Modificar Grupo");
            System.out.println("6. Eliminar Grupo");
            System.out.println("7. Agregar Contacto a Grupo");
            System.out.println("8. Eliminar Contacto de Grupo");
            System.out.println("9. Agregar Reunion");
            System.out.println("10. Eliminar Reunion");
            System.out.println("11. Modificar Reunion");
            System.out.println("12. Agregar Asistente a Reunion");
            System.out.println("13. Eliminar Asistente a Reunion");
            System.out.println("14. Mostrar Contactos");
            System.out.println("15. Mostrar Grupos");
            System.out.println("16. Mostrar Reuniones");
            System.out.println("17. Salir");

            // Leer la seleccion del usuario por teclado.
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Evalua la seleccion del usuario para saber que hacer xdxdxd
            switch (opcion) {
                case 1 -> agregarContacto();
                case 2 -> eliminarContacto();
                case 3 -> modificarContacto();
                case 4 -> crearGrupo();
                case 5 -> modificarGrupo();
                case 6 -> eliminarGrupo();
                case 7 -> agregarContactoAGrupo();
                case 8 -> eliminarContactoDeGrupo();
                case 9 -> agregarReunion();
                case 10 -> eliminarReuniones();
                case 11 -> modificarReunion();
                case 12 -> agregarAsistenteReunion();
                case 13 -> eliminarAsistenteDeReunion();
                case 14 -> mostrarContactos();
                case 15 -> mostrarGrupos();
                case 16 -> mostrarReuniones();
                case 17 -> running = false;
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

// ------------------------------------------------------------------------ //

    /**
     * Metodo para agregar el contacto.
     */
    private static void agregarContacto() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese alias: ");
        String alias = scanner.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        // Verificar duplicados.
        String id = nombre + telefono;
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            String ids = c.getNombre() + c.getTelefono();
            if (ids.equals(id)) {
                System.out.println("Error: Ya existe un contacto con el mismo nombre y teléfono.");
                return;
            }
        }

        // Se agrega el contacto despues e paras la verificacion.
        Contacto nuevoContacto = new Contacto(nombre, alias, direccion, telefono, email);
        contactos.add(nuevoContacto);
        System.out.println("Contacto agregado: " + nuevoContacto);
    }


    /**
     * Metodo para eliminar contactos existentes.
     */
    private static void eliminarContacto() {
        System.out.print("Ingrese nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese teléfono del contacto a eliminar: ");
        String telefono = scanner.nextLine();

        // Se busca el contacto para eliminar.
        Contacto contactoAEliminar = null;
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            if (c.getNombre().equals(nombre) && c.getTelefono().equals(telefono)) {
                contactoAEliminar = c;
                break;
            }
        }

        // Confirmar la eliminación del grupo
        System.out.print("¿Está seguro de que desea eliminar el contacto '" +
                contactoAEliminar.getNombre() + contactoAEliminar.getTelefono() +
                "'? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        // Confirmar la eliminacion del contacto
        if (confirmacion.equals("s")) {
            System.out.println("Grupo eliminado exitosamente.");

            // Se hace las verificaciones para eliminar el contacto.
            if (contactoAEliminar != null) {
                contactos.remove(contactoAEliminar);
                System.out.println("Contacto eliminado.");
            } else {
                System.out.println("Contacto no encontrado.");
            }
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    /**
     * Metodo para modificar el contacto.
     */
    private static void modificarContacto() {
        // Verificar si hay contactos disponibles
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos disponibles para modificar.");
            return;
        }

        // Mostrar la lista de contactos disponibles
        System.out.println("Contactos disponibles:");
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            System.out.println((i + 1) + ". Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());
        }

        // Seleccionar el contacto a modificar
        System.out.print("Ingrese el número del contacto que desea modificar: ");
        int indiceContacto = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceContacto < 0 || indiceContacto >= contactos.size()) {
            System.out.println("Índice de contacto no válido.");
            return;
        }

        Contacto contactoSeleccionado = contactos.get(indiceContacto);

        /* Menú para modificar atributos del contacto
            No se puede modificar nombre ni telefono por cuestiones de ID.
        * */
        System.out.println("Modificando el contacto: " + contactoSeleccionado.getNombre());
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1. Alias");
        System.out.println("2. Dirección");
        System.out.println("3. Email");

        System.out.print("Ingrese su opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo alias: ");
                String nuevoAlias = scanner.nextLine();
                contactoSeleccionado.setAlias(nuevoAlias);
                System.out.println("Alias del contacto modificado a: " + nuevoAlias);
                break;

            case 2:
                System.out.print("Ingrese la nueva dirección: ");
                String nuevaDireccion = scanner.nextLine();
                contactoSeleccionado.setDireccion(nuevaDireccion);
                System.out.println("Dirección del contacto modificada a: " + nuevaDireccion);
                break;

            case 3:
                System.out.print("Ingrese el nuevo email: ");
                String nuevoEmail = scanner.nextLine();
                contactoSeleccionado.setEmail(nuevoEmail);
                System.out.println("Email del contacto modificado a: " + nuevoEmail);
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

// ------------------------------------------------------------------------------- //

    /**
     * Metodo para crear los grupos
     */
    private static void crearGrupo() {
        System.out.print("Ingrese nombre del grupo: ");
        String nombreGrupo = scanner.nextLine();

        // Mostrar las categorías disponibles
        System.out.println("Seleccione una categoría de las siguientes:");
        for (Categoria categoria : Categoria.values()) {
            System.out.println("- " + categoria);
        }

        // Obtener la categoría del usuario
        System.out.print("Ingrese categoría: ");
        String categoriaInput = scanner.nextLine().toUpperCase();

        // Validar si la categoría es válida
        Categoria categoriaSeleccionada = null;
        for (Categoria categoria : Categoria.values()) {
            if (categoria.name().equals(categoriaInput)) {
                categoriaSeleccionada = categoria;
                break;
            }
        }

        // Verificar si se encontró una categoría válida
        if (categoriaSeleccionada != null) {
            Grupo nuevoGrupo = new Grupo(nombreGrupo, categoriaSeleccionada);
            grupos.add(nuevoGrupo);
            System.out.println("Grupo creado: " + nuevoGrupo);
        } else {
            System.out.println("Categoría no válida. Inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para modificar los grupos existentes.
     */
    private static void modificarGrupo() {
        // Mostrar la lista de grupos disponibles
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos disponibles para modificar.");
            return;
        }
        // Muestra los grupos disponibles
        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println((i + 1) + ". " + grupos.get(i).getNombre() + " (" + grupos.get(i).getCategoria() + ")");
        }
        // Seleccionar el grupo a modificar
        System.out.print("Ingrese el número del grupo que desea modificar: ");
        int indiceGrupo = Integer.parseInt(scanner.nextLine()) - 1;
        if (indiceGrupo < 0 || indiceGrupo >= grupos.size()) {
            System.out.println("Índice de grupo no válido.");
            return;
        }

        Grupo grupoSeleccionado = grupos.get(indiceGrupo);

        // Menú para modificar atributos del grupo
        System.out.println("Modificando el grupo: " + grupoSeleccionado.getNombre());
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Categoría");

        System.out.print("Ingrese su opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre del grupo: ");
                String nuevoNombre = scanner.nextLine();
                grupoSeleccionado.setNombre(nuevoNombre);
                System.out.println("Nombre del grupo modificado a: " + nuevoNombre);
                break;

            case 2:
                System.out.println("Seleccione la nueva categoría de las siguientes:");
                for (Categoria categoria : Categoria.values()) {
                    System.out.println("- " + categoria);
                }

                System.out.print("Ingrese la nueva categoría: ");
                String categoriaInput = scanner.nextLine().toUpperCase();

                // Validar si la categoría es válida
                Categoria nuevaCategoria = null;
                for (Categoria categoria : Categoria.values()) {
                    if (categoria.name().equals(categoriaInput)) {
                        nuevaCategoria = categoria;
                        break;
                    }
                }

                if (nuevaCategoria != null) {
                    grupoSeleccionado.setCategoria(nuevaCategoria);
                    System.out.println("Categoría del grupo modificada a: " + nuevaCategoria);
                } else {
                    System.out.println("Categoría no válida. No se realizaron cambios.");
                }
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    /**
     * Metodo para eliminar los grupos existentes
     */
    private static void eliminarGrupo() {
        // Verificar si hay grupos disponibles
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos disponibles para eliminar.");
            return;
        }

        // Mostrar la lista de grupos disponibles
        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            Grupo g = grupos.get(i);
            System.out.println((i + 1) + ". " + g.getNombre() + " (" + g.getCategoria() + ")");
        }

        // Seleccionar el grupo a eliminar
        System.out.print("Ingrese el número del grupo que desea eliminar: ");
        int indiceGrupo = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceGrupo < 0 || indiceGrupo >= grupos.size()) {
            System.out.println("Índice de grupo no válido.");
            return;
        }

        Grupo grupoSeleccionado = grupos.get(indiceGrupo);

        // Confirmar la eliminación del grupo
        System.out.print("¿Está seguro de que desea eliminar el grupo '" + grupoSeleccionado.getNombre() + "'? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (confirmacion.equals("s")) {
            grupos.remove(indiceGrupo);
            System.out.println("Grupo eliminado exitosamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    /**
     * Metodo para agregar el contacto a grupos existentes
     */
    private static void agregarContactoAGrupo() {
        // Mostrar la lista de grupos disponibles
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos disponibles.");
            return;
        }
        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            Grupo g = grupos.get(i);
            System.out.println((i + 1) + ". " + g.getNombre() + " (Categoría: " + g.getCategoria() + ")");
        }

        // Seleccionar el grupo
        System.out.print("Ingrese el número del grupo al que desea agregar el contacto: ");
        int indiceGrupo = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceGrupo < 0 || indiceGrupo >= grupos.size()) {
            System.out.println("Índice de grupo no válido.");
            return;
        }

        Grupo grupoSeleccionado = grupos.get(indiceGrupo);
        // Solicitar información del contacto
        System.out.print("Ingrese nombre del contacto: ");
        String nombreContacto = scanner.nextLine();
        System.out.print("Ingrese teléfono del contacto: ");
        String telefonoContacto = scanner.nextLine();

        // Buscar el contacto
        Contacto contacto = buscarContactoPorNombreYTelefono(nombreContacto, telefonoContacto);
        if (contacto == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }

        // Agregar el contacto al grupo
        if (grupoSeleccionado.agregarContacto(contacto)) {
            System.out.println("Contacto agregado al grupo.");
        } else {
            System.out.println("No se pudo agregar el contacto al grupo (puede estar duplicado o exceder el límite de 5 contactos).");
        }
    }

    /**
     * Metodo para eliminar contacto del grupo.
     */
    private static void eliminarContactoDeGrupo() {
        // Mostrar la lista de grupos disponibles
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos disponibles.");
            return;
        }

        System.out.println("Grupos disponibles:");
        for (int i = 0; i < grupos.size(); i++) {
            Grupo g = grupos.get(i);
            System.out.println((i + 1) + ". " + g.getNombre() + " (Categoría: " + g.getCategoria() + ")");
        }

        // Seleccionar el grupo del cual se desea eliminar un contacto
        System.out.print("Ingrese el número del grupo del cual desea eliminar un contacto: ");
        int indiceGrupo = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceGrupo < 0 || indiceGrupo >= grupos.size()) {
            System.out.println("Índice de grupo no válido.");
            return;
        }

        Grupo grupoSeleccionado = grupos.get(indiceGrupo);

        // Mostrar la lista de contactos actuales en el grupo
        List<Contacto> contactos = grupoSeleccionado.getContactos();
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en el grupo.");
            return;
        }

        System.out.println("Contactos actuales en el grupo:");
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " (Teléfono: " + c.getTelefono() + ")");
        }

        // Seleccionar el contacto a eliminar
        System.out.print("Ingrese el número del contacto que desea eliminar: ");
        int indiceContacto = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceContacto < 0 || indiceContacto >= contactos.size()) {
            System.out.println("Índice de contacto no válido.");
            return;
        }

        Contacto contactoAEliminar = contactos.get(indiceContacto);

        // Eliminar el contacto del grupo
        if (grupoSeleccionado.eliminarContacto(contactoAEliminar)) {
            System.out.println("Contacto eliminado del grupo.");
        } else {
            System.out.println("No se pudo eliminar el contacto del grupo.");
        }
    }


// ---------------------------------------------------------------------------------//

    /**
     * Metodo para agregar una reunion
     */
    private static void agregarReunion() {
        // Solicitar detalles de la reunión al usuario
        System.out.println("Ingrese el nombre de la reunion: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción de la reunión: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la fecha de la reunión (en formato YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese la hora de la reunión (en formato HH:MM): ");
        String hora = scanner.nextLine();


        // Crear y agregar la nueva reunión
        Reunion nuevaReunion = new Reunion(nombre,descripcion, fecha, hora);
        reuniones.add(nuevaReunion);
        System.out.println("Reunión agregada exitosamente.");
    }


    /**
     * Metodo para eliminar los grupos existentes
     */
    private static void eliminarReuniones() {
        // Verificar si hay grupos disponibles
        if (reuniones.isEmpty()) {
            System.out.println("No hay reuniones disponibles para eliminar.");
            return;
        }

        // Mostrar la lista de grupos disponibles
        System.out.println("Reuniones disponibles:");
        for (int i = 0; i < reuniones.size(); i++) {
            Reunion r = reuniones.get(i);
            System.out.println((i + 1) + ". " + r.getNombre());
        }

        // Seleccionar el grupo a eliminar
        System.out.print("Ingrese el número de la reunion que desea eliminar: ");
        int indiceReunion = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceReunion < 0 || indiceReunion >= reuniones.size()) {
            System.out.println("Índice de reunion no válido.");
            return;
        }

        Reunion reunionSeleccionado = reuniones.get(indiceReunion);

        // Confirmar la eliminación del grupo
        System.out.print("¿Está seguro de que desea eliminar la reunion: '" + reunionSeleccionado.getNombre() + "'? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (confirmacion.equals("s")) {
            grupos.remove(indiceReunion);
            System.out.println("Reunion eliminado exitosamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    /**
     * Metodo para modificar las reuniones existentes.
     */
    private static void modificarReunion() {
        // Mostrar la lista de reuniones disponibles
        if (reuniones.isEmpty()) {
            System.out.println("No hay reuniones disponibles para modificar.");
            return;
        }

        System.out.println("Reuniones disponibles:");
        for (int i = 0; i < reuniones.size(); i++) {
            Reunion r = reuniones.get(i);
            System.out.println((i + 1) + ". " + r.getDescripcion() + " (Fecha: " + r.getFecha() + ", Hora: " + r.getHora() + ")");
        }

        // Seleccionar la reunión a modificar
        System.out.print("Ingrese el número de la reunión que desea modificar: ");
        int indiceReunion = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceReunion < 0 || indiceReunion >= reuniones.size()) {
            System.out.println("Índice de reunión no válido.");
            return;
        }

        Reunion reunionSeleccionada = reuniones.get(indiceReunion);

        // Menú para modificar atributos de la reunión
        System.out.println("Modificando la reunión: " + reunionSeleccionada.getDescripcion());
        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1. Descripción");
        System.out.println("2. Fecha");
        System.out.println("3. Hora");
        System.out.print("Ingrese su opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                System.out.print("Ingrese la nueva descripción de la reunión: ");
                String nuevaDescripcion = scanner.nextLine();
                reunionSeleccionada.setDescripcion(nuevaDescripcion);
                System.out.println("Descripción de la reunión modificada a: " + nuevaDescripcion);
                break;

            case 2:
                System.out.print("Ingrese la nueva fecha de la reunión (en formato YYYY-MM-DD): ");
                String nuevaFecha = scanner.nextLine();
                reunionSeleccionada.setFecha(nuevaFecha);
                System.out.println("Fecha de la reunión modificada a: " + nuevaFecha);
                break;

            case 3:
                System.out.print("Ingrese la nueva hora de la reunión (en formato HH:MM): ");
                String nuevaHora = scanner.nextLine();
                reunionSeleccionada.setHora(nuevaHora);
                System.out.println("Hora de la reunión modificada a: " + nuevaHora);
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }


    /**
     * Metodo para agregar asistences a la reunion.
     */
    private static void agregarAsistenteReunion(){
        //Mostrar la lista de las reuniones
        if (reuniones.isEmpty()){
            System.out.println("No hay reuniones disponibles.");
            return;
        }
        System.out.println("Reuniones disponibles:");
        for (int i = 0; i < reuniones.size(); i++) {
            Reunion r = reuniones.get(i);
            System.out.println((i + 1) + ". " + r.getNombre());
        }

        // Seleccionar el grupo
        System.out.print("Ingrese el número de la reunion al que desea agregar el asistente: ");
        int indiceReuniones = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceReuniones < 0 || indiceReuniones >= reuniones.size()) {
            System.out.println("Índice de reuniones no válido.");
            return;
        }

        Reunion reunionSeleccionado = reuniones.get(indiceReuniones);
        // Solicitar información del contacto
        System.out.print("Ingrese nombre del contacto: ");
        String nombreContacto = scanner.nextLine();
        System.out.print("Ingrese teléfono del contacto: ");
        String telefonoContacto = scanner.nextLine();

        // Buscar el contacto
        Contacto contacto = buscarContactoPorNombreYTelefono(nombreContacto, telefonoContacto);
        if (contacto == null) {
            System.out.println("Contacto no encontrado.");
            return;
        }
        // Agregar el contacto a la asistencia
        if (reunionSeleccionado.agregarAsistente(contacto)) {
            System.out.println("Contacto agregado al grupo.");
        } else {
            System.out.println("No se pudo agregar el contacto al grupo (puede estar duplicado o exceder el límite de 5 contactos).");
        }
    }

    /**
     * Metodo para eliminar un asistente de las reuniones.
     */
    private static void eliminarAsistenteDeReunion() {
        // Mostrar la lista de reuniones disponibles
        if (reuniones.isEmpty()) {
            System.out.println("No hay reuniones disponibles.");
            return;
        }

        System.out.println("Reuniones disponibles:");
        for (int i = 0; i < reuniones.size(); i++) {
            Reunion r = reuniones.get(i);
            System.out.println((i + 1) + ". " + r.getDescripcion() + " (Fecha: " + r.getFecha() + ", Hora: " + r.getHora() + ")");
        }

        // Seleccionar la reunión de la que se desea eliminar un asistente
        System.out.print("Ingrese el número de la reunión de la cual desea eliminar un asistente: ");
        int indiceReunion = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceReunion < 0 || indiceReunion >= reuniones.size()) {
            System.out.println("Índice de reunión no válido.");
            return;
        }

        Reunion reunionSeleccionada = reuniones.get(indiceReunion);

        // Mostrar la lista de asistentes actuales de la reunión
        List<Contacto> asistentes = reunionSeleccionada.getAsistentes();
        if (asistentes.isEmpty()) {
            System.out.println("No hay asistentes en la reunión.");
            return;
        }

        System.out.println("Asistentes actuales:");
        for (int i = 0; i < asistentes.size(); i++) {
            Contacto c = asistentes.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " (Teléfono: " + c.getTelefono() + ")");
        }

        // Seleccionar el asistente a eliminar
        System.out.print("Ingrese el número del asistente que desea eliminar: ");
        int indiceAsistente = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceAsistente < 0 || indiceAsistente >= asistentes.size()) {
            System.out.println("Índice de asistente no válido.");
            return;
        }

        Contacto asistenteAEliminar = asistentes.get(indiceAsistente);
        asistentes.remove(asistenteAEliminar);
        // Actualizar la lista de asistentes en la reunión
        reunionSeleccionada.setAsistentes(asistentes);
        System.out.println("Asistente eliminado de la reunión.");
    }


// --------------------------------------------------------------------------------------- //

    private static Contacto buscarContactoPorNombreYTelefono(String nombre, String telefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre) && c.getTelefono().equals(telefono)) {
                return c;
            }
        }
        return null;
    }

    private static void mostrarContactos() {
        System.out.println("Lista de Contactos:");
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            System.out.println(c);
        }
    }


    private static void mostrarGrupos() {
        System.out.println("Lista de Grupos:");
        for (int i = 0; i < grupos.size(); i++) {
            Grupo g = grupos.get(i);
            System.out.println(g);
        }
    }

    private static void mostrarReuniones(){
        System.out.println("Lista de Reuniones");
        for (int i = 0; i < reuniones.size(); i++) {
            Reunion r = reuniones.get(i);
            System.out.println(r);
        }
    }
}
