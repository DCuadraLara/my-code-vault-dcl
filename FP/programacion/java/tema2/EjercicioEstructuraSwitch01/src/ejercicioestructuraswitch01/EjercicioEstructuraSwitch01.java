package ejercicioestructuraswitch01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class EjercicioEstructuraSwitch01 {

    /**
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        //-----------------------------------------
        //          Declaración de variables
        //-----------------------------------------
        String mensaje;
        String resultado = "";
        
        //-----------------------------------------
        //          Entrada de datos
        //-----------------------------------------
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un dia de la semana: ");
        mensaje = sc.nextLine();
        mensaje = mensaje.toLowerCase(); //check lowcase
        
        //-----------------------------------------
        //          Procesamiento
        //-----------------------------------------
        switch (mensaje){
            case "lunes": case "martes": case "miercoles": case "jueves": case "viernes":
                resultado = "dia laborable";
                break;
            case "sabado": case "domingo":
                resultado = "dia libre";
                break;
            default:
                resultado = "dia no valido";   
        }
        
        //-----------------------------------------
        //          Salida de resultados
        //-----------------------------------------
        System.out.printf("Resultado es: %s%n", resultado);
    }
    
}
