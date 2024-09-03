package co.edu.uniquindio.poo;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class ContactoTest {
    private Agenda agenda;

    @Before
    public void setUp() {
        agenda = new Agenda();
        // Inicializar datos de ejemplo
        agenda.getContactos().clear(); // Limpiar contactos antes de cada prueba
    }

    @Test
    public void testAgregarContactoDuplicado() {
        // Crear contacto
        Contacto contacto1 = new Contacto("Juan Pérez", "juanp", "Calle 123", "555-1234", "juan@example.com");
        Contacto contacto2 = new Contacto("Juan Pérez", "juanp", "Calle 123", "555-1234", "juan@example.com");

        // Agregar primer contacto
        agenda.getContactos().add(contacto1);

        // Intentar agregar contacto duplicado
        agenda.getContactos().add(contacto2);

        // Verificar que el contacto duplicado no se haya agregado
        boolean contieneDuplicado = agenda.getContactos().stream()
                .filter(c -> c.getNombre().equals(contacto2.getNombre()) &&
                        c.getTelefono().equals(contacto2.getTelefono()))
                .count() > 1;

        assertFalse("El contacto duplicado no debería ser agregado.", contieneDuplicado);
    }
}

