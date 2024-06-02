
package segundaGuia_FundamentosDelLenguajeJava;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main_ejercicio00 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        GuiaRepasoA.ejercicio1(sc);
        sc.next();
        GuiaRepasoA.ejercicio2(sc);
        GuiaRepasoA.ejercicio3(sc);
        GuiaRepasoA.ejercicio4(sc);
    }
}

abstract class GuiaRepasoA{
    
    public static void ejercicio1(Scanner sc){
        
        do{
            try{
                System.out.println("Ingrese a continuacion dos numero cualesquiera "
                        + "para ser sumados: ...");
                System.out.println("Resultado : "+(sc.nextFloat()+sc.nextFloat()));
                break;
            }catch(InputMismatchException ime){
                System.out.println("Algo salio mal al ingresar los datos, "
                        + "intente nuevamente.");
                sc.next();//¿limpiar lo que quedo en buffer si se ingresa letras?
            }
        }while(true);   
    }
    
    public static void ejercicio2(Scanner sc){
        
        String nombre;
        
        while(true){
            System.out.print("Su nombre completo ¿? : ... ");
            nombre = sc.nextLine();
            for(char car : nombre.trim().toCharArray()){
                if(!Character.isLetter(car)&&!Character.isWhitespace(car)){
                    System.out.println("...solo letras y espacio si precisa.");
                    nombre = null;
                    break;
                }
            }
            if(nombre!=null)break;
        }
        System.out.println("Usted ingreso >>> "+nombre.trim().toLowerCase());
    }
    
    public static void ejercicio3(Scanner sc){
        
        System.out.print("ºC -> ºF : ");
        System.out.println((sc.nextFloat()*9/5+32)+" ºF");
    }
    
    public static void ejercicio4(Scanner sc){
        
        System.out.println("Ingrese una valor cualquiera;"+
                " emplee formato para "+Locale.getDefault());
        
        float num = sc.nextFloat();
        
        System.out.println("\nDoble de "+String.format("%.3f", num)+" = "+String.format("%.3f", num*2)+
                "\nTriple de "+String.format("%.3f", num)+" = "+String.format("%.3f", num*3)+
                "\nRaiz de "+String.format("%.3f", num)+" = "+String.format("%.3f", Math.abs(Math.sqrt(num))));        
    }

}
