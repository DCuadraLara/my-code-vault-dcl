package ejerciciomanipulacion1;

import java.awt.Rectangle;

/**
 *
 * @author David
 */
public class EjercicioManipulacion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle r1, r2, r3;
        
        r1 = new Rectangle(10, 10, 10, 5);
        r2 = r1;
        
        System.out.printf("x: %d, y: %d, Width: %d, Height: %d%n", r1.x, r1.y, r1.width, r1.height);
        System.out.printf("x: %d, y: %d, Width: %d, Height: %d%n", r2.x, r2.y, r2.width, r2.height);
        
        r2.height = 6;
        System.out.printf("La nueva altura de r2 es: %d%n", r2.height);
        
        r3 = new Rectangle(100, 20);
        System.out.printf("x: %d, y: %d, Width: %d, Height: %d%n", r3.x, r3.y, r3.width, r3.height);
        r3 = r2;
        
        r3.setSize(50, 50);
    }
    
}
