package recu;

/**
 *
 * @author Jesús Ariza
 */
public class Principal {

    public static void main(String[] args) {
        Calificacion c1 = new Calificacion();
        c1.setTeorico(7.27);
        c1.setPractico(09.9);
        System.out.println(c1.toString());
        System.out.println(c1.calcularMedia());

    }
}
