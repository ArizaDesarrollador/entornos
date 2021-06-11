package recu;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jmois
 */
public class PersonaTest {

    public PersonaTest() {
    }

    @Test
    public void testSetTelefono() {
        // Casos verdaderos
        Persona p1 = new Persona();
        p1.setTelefono("603504538"); //Normal
        assertEquals("603504538", p1.getTelefono()); 
        p1.setTelefono("+34603504538"); //Con prefijo
        assertEquals("+34603504538", p1.getTelefono());
        p1.setTelefono("+02079460018"); // Con prefijo de 3 numeros
        assertEquals("+02079460018", p1.getTelefono());

        // Casos falsos
        Persona p2 = new Persona();
        p2.setTelefono("6035045380"); // 10 numeros
        assertEquals(null, p2.getTelefono());
        p2.setTelefono("++34603504538"); // prefijo con dos simbolos de +
        assertEquals(null, p2.getTelefono());
        p2.setTelefono("B460a3504538"); // contiene letras
        assertEquals(null, p2.getTelefono());
        p2.setTelefono("620 40 98 56"); // contiene espacios
        assertEquals(null, p2.getTelefono());
        p2.setTelefono("630-20-18-76"); // contiene guiones
        assertEquals(null, p2.getTelefono());

    }

    @Test
    public void testSetEmail() {
        Persona p1 = new Persona();
        // Casos verdaderos
        p1.setEmail("jmoisesariza@gmail.com");//Normal
        assertEquals("jmoisesariza@gmail.com", p1.getEmail());
        p1.setEmail("3242a_@cesur.com");//Números,letras y _
        assertEquals("3242a_@cesur.com", p1.getEmail());
        p1.setEmail("_1111abcd_@test.com");// _ numero y letras
        assertEquals("_1111abcd_@test.com", p1.getEmail());
        p1.setEmail("joan.malaga_50@hotmail.com"); // con puntos y _
        assertEquals("joan.malaga_50@hotmail.com", p1.getEmail());
        Persona p2 = new Persona();
        // Casos falsos
        p2.setEmail("paco@@gmail.com"); // dos @
        assertEquals(null, p2.getEmail());
        p2.setEmail("jose.luis@gmail..com"); // dos puntos en el dominio
        assertEquals(null, p2.getEmail());
        p2.setEmail("dam.com"); // sin @
        assertEquals(null, p2.getEmail());
        p2.setEmail("francisco@gmailpuntoes");// Sin punto en el dominio
        assertEquals(null, p2.getEmail());
        p2.setEmail("espacio en.blanco@gmail.com"); // Con espacios
        assertEquals(null, p2.getEmail());

    }

}
