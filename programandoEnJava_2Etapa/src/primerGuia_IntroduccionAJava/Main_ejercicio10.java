package primerGuia_IntroduccionAJava;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_ejercicio10 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("Dibujar un cuadrado de ¿? unidades ... ");
        try{
            Utilitario.dibujaCuadrado((byte) Math.abs(sc.nextByte()));
            System.out.println("Tres numeros enteros cualesquiera.");
            Utilitario.elMayorDe(sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println("Averiguar Dia correspondiente al numero de la semana... numero¿? : ");
            System.out.println("El dia correspondiente es : "+Utilitario.elDiaEs((byte) Math.abs(sc.nextByte())));
        }catch(InputMismatchException ime){
            System.out.println("Se ingreso datos no admisibles... vuelva a ejecutar el programa porfavor.");
        }
    }
}

abstract class Utilitario{
    public static void dibujaCuadrado(byte numero){
        byte i=0;
        for(; i<numero; i++)
            if(i==0||i==numero-1){
                for(byte a=0; a<numero; a++)System.out.print('*');               
                System.out.print("\n");
            }else{
                System.out.print('*');
                for(byte j=1; j<numero-1; j++)System.out.print(' ');                
                System.out.println('*');
            }
        System.out.println("\n{Es un cuadrado de "+numero+" unidades de medida.}");
    }
    
    public static void elMayorDe(int a, int b, int c){
        int auy = a;
        for(int aux : new int[]{a,b,c})if(aux>auy) auy = aux;
        System.out.println("El mayor es : "+auy);
        System.out.println("Hay numeros iguales ¿? : "+(a==b||a==c||b==c));
    }
    
    public static String elDiaEs(byte numero){
        switch(numero){
            case 1 : return "Domingo";
            case 2 : return "Lunes";
            case 3 : return "Martes";
            case 4 : return "Miercoles";
            case 5 : return "Jueves";
            case 6 : return "Viernes";
            case 7 : return "Sabado";
            default : return "Error : Numero no valido";
        }
    }
}

