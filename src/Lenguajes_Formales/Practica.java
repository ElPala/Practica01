package Lenguajes_Formales;

import java.util.Scanner;

/*
 * Created by Palafox  on 01/09/2017.
 */
public class Practica {
    public static void main(String[] args) {
        //VARIABLES
        boolean fin = true;
        Lenguaje lenguaje;
        Scanner scanner = new Scanner(System.in);
        //CICLOS
        System.out.println("Abecedario|Lengueje|W:");
        do{
            //DATOS
           // do{
               // System.out.println("Abecedario|Lengueje|W:");
            String x1 =scanner.nextLine();
            String x2 =scanner.nextLine();
            String x3 =scanner.nextLine();
                lenguaje = new Lenguaje(x1,x2,x3);
           // }while (lenguaje.pertenece());
            if(lenguaje.pertenece()){
                if(scanner.nextLine().equals("1")) {
                    fin=false;
                }
                continue;
            }
            //ACOMODO
            lenguaje.acomodo();
            //CHEQUEOf
            if(lenguaje.checar()){
                System.out.println("W:"+lenguaje.getW() + " es acapetada en L*:{" + lenguaje.getLenguajeString()+"}*");
            }else {
                System.out.println("W:"+lenguaje.getW() + " es rechazada en L*:{" + lenguaje.getLenguajeString() +"}*, "+"{"+lenguaje.getError()+"} no pertence a L" );
            }
            //FIN
           // System.out.println("¿Terminaste? 1(Si)/ 0(NO)");
            if(scanner.nextLine().equals("1")) {
                fin=false;
            }
        }while (fin);



    }

}
