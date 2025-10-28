/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadoresdeasignacion01;

/**
 * We need to modify a sequence of values starting it at x = 10 with some assignment operators.
 * We need to show on screen 5, 6, 12, 6, -4, 1.
 * @author David
 */
public class OperadoresDeAsignacion01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize parameters
        int x = 10;
        
        // Calculate with assignment operators
        x = x - 5;
        System.out.print(x + ",");
        x = x + 1;
        System.out.print(x + ",");
        x = x * 2;
        System.out.print(x + ",");
        x = x / 2;
        System.out.print(x + ",");
        x = x - 10;
        System.out.print(x + ",");
        x = x + 5;
        System.out.print(x + ",");
    }
    
}
