package ejerciciousometodos1;

import java.awt.Rectangle;

/**
 *
 * @author David
 */
public class EjercicioUsoMetodos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle r1= new Rectangle (1,2, 5, 4);
        Rectangle r2= new Rectangle (5,3, 4, 6);
        
        Rectangle r3 = r1.union(r2);
        System.out.printf("x: %d, y: %d, width: %d, height: %d%n", r3.x, r3.y, r3.width, r3.height);
    }
    
}
