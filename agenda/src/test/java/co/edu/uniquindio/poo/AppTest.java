package co.edu.uniquindio.poo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private Agenda agenda;

    @Before
    public void setUp() {
        agenda = new Agenda();
        // Inicializar datos de ejemplo
        agenda.getContactos().clear(); // Limpiar contactos antes de cada prueba
        agenda.getGrupos().clear(); // Limpiar grupos antes de cada prueba
    }

    @Test
    public void testAgregarMasDeCincoContactosEnGrupo() {
        // Crear grupo
        Grupo grupo = new Grupo("Grupo 1", Categoria.OFICINA);
        agenda.getGrupos().add(grupo);

        // Agregar 5 contactos al grupo
        for (int i = 1; i <= 5; i++) {
            Contacto contacto = new Contacto("Contacto " + i, "contacto" + i, "Dirección " + i, "555-000" + i, "contacto" + i + "@example.com");
            grupo.agregarContacto(contacto);
        }

        // Intentar agregar un sexto contacto
        Contacto contactoExceso = new Contacto("Contacto Extra", "contacto6", "Dirección Extra", "555-0006", "contacto6@example.com");
        grupo.agregarContacto(contactoExceso);

        // Verificar que el número de contactos en el grupo no sea mayor a 5
        int cantidadContactos = grupo.getContactos().size();
        assertEquals("El número de contactos en el grupo no debería ser mayor a 5.", 5, cantidadContactos);

        // Verificar que el contacto adicional no se haya agregado
        assertFalse("El contacto adicional no debería estar en el grupo.", grupo.getContactos().contains(contactoExceso));
    }
}

