/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajocadenas01;

/**
 * Creates a sequence of Strings changing the value of 'cadena'.
 * @author David
 */
public class TrabajoCadenas01 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        // Init String
        String cadena = "";
        int num = 25;
        
        System.out.println("----------------");
        System.out.println("String Exercise 01 ");
        System.out.println("----------------\n");
        
        // we modify cadena value
        cadena += "La casa de ";
        System.out.println(cadena);
        cadena += "Juan es ";
        System.out.println(cadena);
        cadena += "el numero ";
        System.out.println(cadena);
        cadena += String.valueOf(num);
        System.out.println(cadena);
    }
    
}
