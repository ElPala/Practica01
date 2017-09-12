package Lenguajes_Formales;

import java.util.Scanner;

/*
 * Created on 01/09/2017.
 */
public class Practica {
    public static void main(String[] args) {
        //VARIABLES
        Lenguaje lenguaje;
        Scanner scanner = new Scanner(System.in);
        //CICLOS
        while(true) {
            System.out.println("Abecedario:");
            //Lectura de datos
            //Abecedario
            String x1 = scanner.nextLine();
            //Lenguaje
            System.out.println("Lengueje:");
            String x2 = scanner.nextLine();
            //Se crea un nuevo lenguaje
            lenguaje = new Lenguaje(x1, x2, "");
            //Se checa el lenguaje con el abcedario
            if (lenguaje.pertenece()) {
                //Si se entra aqui, entonces el lenguaje no concuerda
                continue;
            }else {
                break;
            }
        }
        System.out.println("W:");
         while(true) {
             //W
             String x3 = scanner.nextLine();
             if (x3.equals("0")) {// System.out.println("¿Terminaste? 1(Si)");
                 break;
             }
            //Se checa que el lenguaje coincida con W
             lenguaje.setW(x3);
            if (lenguaje.checar()) {
                System.out.println("W:" + lenguaje.getW() + " es acapetada en L*:{" + lenguaje.getLenguajeString() + "}*");
            } else {
                System.out.println("W:" + lenguaje.getW() + " es rechazada en L*:{" + lenguaje.getLenguajeString() + "}*, " + "{" + lenguaje.getError() + "} no pertence a L");
            }

        }


    }

}
