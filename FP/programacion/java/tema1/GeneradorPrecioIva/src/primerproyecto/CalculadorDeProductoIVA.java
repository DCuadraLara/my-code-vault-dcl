/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerproyecto;

/**
 *
 * @author David
 */

import java.util.Scanner;


public class CalculadorDeProductoIVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      // Initialize variables
      final double PRECIO_IVA = 0.21;
      
      Scanner sc=new Scanner(System.in);
      System.out.print("Introduce el precio del producto: ");
      double precioProducto=sc.nextDouble();
      double importeIva = PRECIO_IVA * precioProducto;
      System.out.println("Importe del IVA: " + importeIva);
      System.out.println("Precio con IVA: " + (importeIva + precioProducto));
    }
    
}
