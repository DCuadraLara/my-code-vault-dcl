/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadoreslogicos01;

/**
 * Demonstrate the use of logical operators (&&, ||, !, &, ^) to evaluate boolean expressions.
 * Prints the results for several cases.
 * @author David
 */
public class OperadoresLogicos01 {

    /**
     * @param args the command line arguments (unused).
     */
    public static void main(String[] args) {
        // Input variables
        int x1=10, x2=5, x3=0;
        char c1='F', c2='S';
        
        // Logic parameters --- Output
        
        // x1 es igual a x2
        System.out.println(x1 == x2); // FALSE
        // c1 es distinto a c2
        System.out.println(c1 != c2); // TRUE
        // x1 está entre 10 y 100
        System.out.println((x1 > 10)&&(x1 < 100)); // FALSE
        // x2 no está entre 10 y 100
        System.out.println((x2 < 10)||(x2 > 100)); // TRUE
        // x3 no está entre 10 y 100
        System.out.println((x3 < 10)||(x3 > 100)); // TRUE
        // x1 es mayor que x2 y c1 es igual a c2
        System.out.println((x1 > x2)&&(c1 == c2)); // FALSE
        // O x1 es mayor que x2, o c1 es distinto a c2, cualquiera de los dos casos.
        System.out.println((x1 > x2)||(c1 != c2)); // TRUE
        // x1 es menor o igual que 7 y c2 es igual a c1
        System.out.println((x1 <= 7)&&(c2 == c1)); // FALSE
        // c2 es distinto de 'A' y x2 es mayor que 0
        System.out.println((c2 != 'A')&&(x2 > 0)); // TRUE
        // 'F' es distinto de c1 o x1 es mayor que 20
        System.out.println(('F' != c1)||(x1 > 20)); // FALSE
        // 'F' es distinto de c1 o x1 es mayor que 20 o x2 es mayor que 2
        System.out.println(('F' != c1)||(x1 > 20)||(x2 > 2)); // TRUE
        // 'F' es igual a c1 y x3 es menor que x1
        System.out.println(('F' == c1)&&(x3 < x1)); // TRUE
        // 'F' es igual a c1 y x3 es menor que x1 y x2 es menor o igual que x3
        System.out.println(('F' == c1)&&(x3 < x1)&&(x2 <= x3)); // FALSE
        // x2 está entre x3 y x1, y c2 es 'S'
        System.out.println((x3 < x2 && x2 < x1)&&(c2 == 'S')); // TRUE
        // x3 no está entre x2 y x1
        System.out.println(!(x2 < x3 && x3 < x1)); // TRUE
        // x2 no está entre x3 y x1, o c2 es igual a c1
        System.out.println((!(x3 < x2 && x2 < x1))||(c2 == c1)); // FALSE
        // no se cumple que x3 es menor que x1
        System.out.println(!(x3 < x1)); // FALSE
        // ni x3 es mayor que x1, ni c2 es distinto a c1
        System.out.println((!(x3 > x1))&&(!(c2 != c1))); // FALSE
        // no se cumple que x1 es menor que 100 y x2 es mayor que 10
        System.out.println(!(x1 < 100 && x2 > 10)); // TRUE
        // c2 es anterior alfabéticamente a c1
        System.out.println(c2 < c1); // FALSE
    }
}
