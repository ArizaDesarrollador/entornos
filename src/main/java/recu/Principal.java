package recu;
/**
 *
 * @author Jesús Ariza
 */
public class Principal {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.setEmail("_1111abcd_@test.com");
        p1.setTelefono("603504538");
        System.out.println(p1.getEmail());
        System.out.println(p1.getTelefono());
        
        
    }
}
