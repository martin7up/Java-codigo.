package segundaGuia_FundamentosDelLenguajeJava;

import java.util.InputMismatchException;
import java.util.Scanner;
    
public class Main_ejercicio01 {
    
    private static Scanner sc;
    
    public static void main(String[] args){
        
        sc = new Scanner(System.in);
        
        GuiaRepasoB.ejercicio1(sc);
        System.out.println("Ingrese un numero : ");
        System.out.println("El numero ingresado es Par ¿? : >>> "+GuiaRepasoB.ejercicio2(sc.nextInt()));
        sc.next();
        GuiaRepasoB.ejercicio3(sc);
        GuiaRepasoB.ejercicio4(sc);
        GuiaRepasoB.ejercicio5(sc);
        GuiaRepasoB.ejercicio6(sc);
        sc.close();
        
    }
}

abstract class GuiaRepasoB{
    
    public static void ejercicio1(Scanner sc){
        while(true){
            try{
                System.out.println("Ingrese dos numeros enteros cualesquiera : ");
                System.out.println("El mayor de ambos es : "+Math.max(sc.nextInt(), sc.nextInt()));
                return;
            }catch(InputMismatchException ime){
                System.out.println("Algo salio mal, intente nuevamente.");
                sc.next();
            }
        }
    }
    
    public static boolean ejercicio2(int num){
        return num%2==0;
    }
    
    public static void ejercicio3(Scanner sc){
        System.out.print("Ingrese una frase : >>> ");
        System.out.println((sc.nextLine().equals("eureka"))? "La frase ingresada es eureka." : "La frase ingresada no es eureka.");
    }
    
    public static void ejercicio4(Scanner sc){
        System.out.print("Ingrese una frase de 8 caracteres : ");
        System.out.println((sc.nextLine().trim().length()==8)? "La frase ingresada tiene 8 caracteres." : "La frase ingresada no tiene 8 caracteres.");
    }

    public static void ejercicio5(Scanner sc){
        System.out.print("Frase o palabra ¿? >>> : ");
        System.out.println((sc.nextLine().trim().charAt(0)=='A')? "Correcto." : "Incorrecto.");
    }
    
    public static void ejercicio6(Scanner sc){
        while(true){
            try{
                System.out.println("Ingrese codigo de consulta : >>> ");
                switch(sc.nextInt()){
                    case 1 : System.out.println("Bomba p/Agua"); break;
                    case 2 : System.out.println("Bomba p/Combustible"); break;
                    case 3 : System.out.println("Bomba p/Hormigon"); break;
                    case 4 : System.out.println("Bomba p/Industria Alimentaria"); break;
                    default :  System.out.println("Valor no admitido"); break;        
                }
                return;
            }catch(InputMismatchException ime){
                System.out.println("El codigo a ingresar es un numero tipo entero... intente nuevamente.");
                sc.next();
            }
        }
    }
      
}