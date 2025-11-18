/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadoresderelacion01;

/**
 * This program print a sequence of booleans results(true, false, true, false, true, and false).
 * Each operator used on it must be different.
 * @author David
 */
public class OperadoresDeRelacion01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Init values
        int x = 5;
        int z = 6;
        boolean result;

        // Calculate boolean and show it
        result = (x < z);
        System.out.print(result + ", ");
        result = (x > z);
        System.out.print(result + ", ");
        result = (x != z);
        System.out.print(result + ", ");
        result = (x == z);
        System.out.print(result + ", ");
        result = (x <= x);
        System.out.print(result + ", ");
        result = (x >= z);
        System.out.println(result);
    }
    
}
