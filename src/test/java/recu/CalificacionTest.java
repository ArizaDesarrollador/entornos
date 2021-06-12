
package recu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jesús Ariza
 */
public class CalificacionTest {
    
    public CalificacionTest() {
    }


    /**
     * Se comprueban todos las distintas posibilidades del método teórico
     */
    @Test
    public void testSetTeorico() {
        // Valores verdaderos
        Calificacion c1 = new Calificacion();
        c1.setTeorico(4.00);
        assertEquals(4.00, c1.getTeorico());//Normal
        c1.setTeorico(09.50);
        assertEquals(09.50, c1.getTeorico());//Dos digitos a la izquierda y derecha
         c1.setTeorico(7.3);
        assertEquals(7.3, c1.getTeorico());//Un digito a la izquierda y 1 a la derecha
         c1.setTeorico(05.5);
        assertEquals(05.5, c1.getTeorico());//Dos digitos a la izquierda y 1 a la derecha
         c1.setTeorico(10.00);
        assertEquals(10.00, c1.getTeorico());// Limite valor de nota
         c1.setTeorico(00.00);
        assertEquals(00.00, c1.getTeorico());// Mínimo valor de nota
        
        // Valores falsos
        Calificacion c2 = new Calificacion();
        c2.setTeorico(11.00);
        assertEquals(null, c2.getTeorico());// Sobrepasa el límite establecido
        c2.setTeorico(-1.00);
        assertEquals(null, c2.getTeorico());// Sobrepasa el mínimo establecido
        c2.setTeorico(1.562);
        assertEquals(null, c2.getTeorico());// Sobrepasa el límite de decimales establecidos
        c2.setTeorico(11.00);
        assertEquals(null, c2.getTeorico());// Sobrepasa el límite establecido
       /*Faltaría una prueba sin el punto, pero directamente un Double no te permite meter
        un número sin el "." a si que se da por testeado, como también caracteres.
        */
    }


    /**
     * El el práctico basicamente he copiado los mismos test que en el teórico ya que su función
     * es básicamente lo misma, a si que como buena práctica hay que reusar código.
     */
    @Test
    public void testSetPractico() {
         // Valores verdaderos
        Calificacion c1 = new Calificacion();
        c1.setPractico(4.00);
        assertEquals(4.00, c1.getPractico());//Normal
        c1.setPractico(09.50);
        assertEquals(09.50, c1.getPractico());//Dos digitos a la izquierda y derecha
         c1.setPractico(7.3);
        assertEquals(7.3, c1.getPractico());//Un digito a la izquierda y 1 a la derecha
         c1.setPractico(05.5);
        assertEquals(05.5, c1.getPractico());//Dos digitos a la izquierda y 1 a la derecha
         c1.setPractico(10.00);
        assertEquals(10.00, c1.getPractico());// Limite valor de nota
         c1.setPractico(00.00);
        assertEquals(00.00, c1.getPractico());// Mínimo valor de nota
        
        // Valores falsos
        Calificacion c2 = new Calificacion();
        c2.setPractico(11.00);
        assertEquals(null, c2.getPractico());// Sobrepasa el límite establecido
        c2.setPractico(-1.00);
        assertEquals(null, c2.getPractico());// Sobrepasa el mínimo establecido
        c2.setPractico(1.562);
        assertEquals(null, c2.getPractico());// Sobrepasa el límite de decimales establecidos
        c2.setPractico(11.00);
        assertEquals(null, c2.getPractico());// Sobrepasa el límite establecido
       /*Faltaría una prueba sin el punto, pero directamente un Double no te permite meter
        un número sin el "." a si que se da por testeado, como también caracteres.
        */
    }

    @Test
    public void testCalcularMedia() {
        Calificacion c1 = new Calificacion();
        c1.setPractico(10.00);
        c1.setTeorico(6.00);
        assertEquals(8.00, c1.calcularMedia());// Media sin decimales
        c1.setPractico(7.79);
        c1.setTeorico(4.99);
        assertEquals(6.390000000000001, c1.calcularMedia());// Media con decimales
        c1.setPractico(7.27);
        c1.setTeorico(09.9);
        assertEquals(8.585, c1.calcularMedia());// Media con valores "cojos"
        
    }
    
}
