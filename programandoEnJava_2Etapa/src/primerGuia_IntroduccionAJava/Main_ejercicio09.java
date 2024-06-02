
package primerGuia_IntroduccionAJava;

import java.util.Scanner;

public class Main_ejercicio09 {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        
        System.out.println("Ingrese Cantidad a cambiar(US$) y precio Dolar en Pesos actual(Arg$)");
        System.out.println("Son : "+Conversor.convertirAPesos(sc.nextFloat(), sc.nextFloat())+" Arg$");
        System.out.println("Ingrese Cantidad a cambiar(Arg$) y precio Dolar en Pesos actual(Arg$)");
        System.out.println("Son : "+Conversor.convertirADolar(sc.nextFloat(), sc.nextFloat())+" US$");
        
        sc.close();
    }
}

abstract class Conversor{
    
    public static float convertirAPesos(float cantidadEnDolar, float precioDolar){
        return cantidadEnDolar*precioDolar;
    }
    
    public static float convertirADolar(float cantidadEnPesos, float precioDolar){
        return cantidadEnPesos/precioDolar;
    }
}