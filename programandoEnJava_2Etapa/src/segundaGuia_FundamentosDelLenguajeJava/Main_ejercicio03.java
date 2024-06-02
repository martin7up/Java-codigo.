package segundaGuia_FundamentosDelLenguajeJava;

import java.util.Random;
import java.util.Scanner;
import static segundaGuia_FundamentosDelLenguajeJava.GuiaRepasoC.validacion;

public class Main_ejercicio03 {
    
    public static void main(String[] args){
        
//        GuiaEjerciciosExtras.ejercicio1();

//        System.out.println(GuiaEjerciciosExtras.ejercicio2((new Scanner(System.in)).nextLong()));

//        GuiaEjerciciosExtras.ejercicio3(new Scanner(System.in));
        
//        GuiaEjerciciosExtras.ejercicio4((byte) 8);
//        GuiaEjerciciosExtras.ejercicio4b((byte) 8);
    
//        GuiaEjerciciosExtras.ejercicio5(new Scanner(System.in), new Random(), (byte) 26);
        
//        System.out.println(GuiaEjerciciosExtras.ejercicio6(50L, 13L));

//        System.out.println(GuiaEjerciciosExtras.ejercicio7(new Scanner(System.in)));

//        System.out.println(GuiaEjerciciosExtras.ejercicio8((byte)2, (byte)4, (byte)0, (byte)9));
        
//        GuiaEjerciciosExtras.ejercicio9(new Scanner(System.in));

    }
}

abstract class GuiaEjerciciosExtras{
    
    public static void ejercicio1(){
        for(byte i=0; i<10; i++)
            for(byte j=0; j<10; j++)
                for(byte k=0; k<10; k++)
                    System.out.println(((i==3)? "E" : i )+"/"+((j==3)? "E" : j)+"/"+((k==3)? "E" : k));           
    }
    
    public static byte ejercicio2(long numero){
        byte cont= 0;
        while(true) if((numero/(Math.pow(10,cont++)))<1) return (byte) (cont-1);
    }
    
    public static void  ejercicio3(Scanner sc){
        System.out.print("Cantidad en minutos ¿? : >>> ");
        long minutos = Math.abs(sc.nextLong());
        System.out.println("Equivalente a : "+minutos/1440+" dias con "+((float)minutos/1440)*24);
        sc.close();
    }
    
    public static void ejercicio4(byte num){
        for(byte j =1; j<=num; j++) for(byte i= 1; i<=j; i++) System.out.print((i!=j)? i : i+"\n");
    }
    
    public static void ejercicio4b(byte num){
        for(byte j =num; j>0; j--) for(byte i= 1; i<=j; i++) System.out.print((i!=j)? i : i+"\n");
    }
    
    public static void ejercicio5(Scanner sc,Random aleatorio, byte limiteSuperior){
        System.out.println("Bienvenido... este juego no se termina hasta que "+
                "adivines que numero se esconde tras la X !\n\t...exitos!"
                + "\n\r...por cierto como minimo es 0 y como maximo es "+limiteSuperior+
                    "\n...pista : es positivo y sin coma.");
        while(true){
            System.out.print("Tras esta X esta el valor... cual crees es su valor ¿? ");
            if(validacion("¿? : >>> ","#DATO ERRONEO#",sc,true)==aleatorio.nextInt(limiteSuperior)){
                System.out.println("Correcto!! ... Fin del juego!");
                sc.close();
                return;
            }else{
                System.out.println("...incorrecto... pongamos otro numero tras la X.");
            }
        }
    }
    
    public static String ejercicio6(long dividendo , long divisor){
        long cociente = 0;
        while(true){
            dividendo = dividendo - divisor;
            cociente++;
            if(dividendo<divisor) return ("Resto="+dividendo+"\nCociente="+cociente);
        }
    }
    
    public static String ejercicio7(Scanner sc){
        int num = 1, cont= 0, contP= 0;      
        while(num%5!=0){
            num = (int)validacion("Valor ¿? >>> ","#Error#",sc,true);
            if(num%2==0) contP++;
            if(num>0) cont++;
        }
        sc.close();
        return "Se ingresaron "+(cont)+" numeros; "+contP+" fueron numeros pares y "
                +(cont-contP)+" inpares.";
    }

    public static String ejercicio8(byte a, byte b, byte c, byte d){
        byte aux;
        String str = "(ANTES)A:"+a+" B:"+b+" C:"+c+" D:"+d;
        aux=b;
        b=c;
        c=a;
        a=d;
        d=aux;
        //"\n(DESPUES)A:"+d+" B:"+c+" C:"+a+" D:"+aux;
        return str+"\n(DESPUES)A:"+a+" B:"+b+" C:"+c+" D:"+d;
    }
    
    public static void ejercicio9(Scanner sc){
        int  i= 1, iter;
        float valor, max, min, acum;
        iter = (int) Math.abs(validacion("Iteraciones ¿? : ","Formato Incorrecto",sc,true));
        acum = max = min = validacion("Valor ¿? : "," ¬¬ ... de nuevo",sc,false);
        while(i<iter){
            valor = validacion("Valor ¿? : "," ¬¬ ... de nuevo",sc,false);
            max = Math.max(valor, max);
            min = Math.min(valor, min);
            acum+=valor;
            i++;
        }
        sc.close();
        System.out.println("Promedio : "+acum/i+" Max : "+max+" Min : "+min);
    }
}