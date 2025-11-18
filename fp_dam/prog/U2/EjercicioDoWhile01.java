package ejerciciodowhile01;

/**
 *
 * @author David
 */
public class EjercicioDoWhile01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int inicio = 3;
        int fin = 8;
        
        do{
            System.out.print(inicio + ", ");
            inicio++;
        }
        while (inicio <= fin);
    }
    
}
