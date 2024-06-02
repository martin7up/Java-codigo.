package primerGuia_IntroduccionAJava;

public class Main_ejercicio13 {
    public static void main(String[] args){
        
        System.out.println("El 14 es primo : "+Calculo.esPrimo(14)+
        "\nEl 13 es primo : "+Calculo.esPrimo(13)+
        "\nEl 37 es primo : "+Calculo.esPrimo(37)+
        "\nEl 7 es primo : "+Calculo.esPrimo(7)+
        "\nEl 86 es primo : "+Calculo.esPrimo(86)+
        "\n\nValor absoluto de -48 : "+Calculo.valorAbsoluto(-48)+
        "\nValor absoluto de 0 : "+Calculo.valorAbsoluto(0)+
        "\nValor absoluto de 115 : "+Calculo.valorAbsoluto(115)+
        "\n\nPara la ecuacion 1x^2 + 3x + 2 = 0, sus raices son : "+Calculo.raicesDeCuadratica(1, 3, 2)+
        "\nPara la ecuacion 3x^2 + 2x - 8 = 0, sus raices son : "+Calculo.raicesDeCuadratica(3, 2, -8)+
        "\nPara la ecuacion 1x^2 - 4x  7 = 0, sus raices son : "+Calculo.raicesDeCuadratica(1, -4, 7));
              
    }
}

abstract class Calculo{
    
    public static boolean esPrimo(long numero){ 
        numero = Math.abs(numero);
        for(long i = 2;i<numero;i++){
            if(numero%i==0) return false;
        }
        return true;
    }
    
    public static long valorAbsoluto(long numero){
        return (numero<0)? -numero : numero;
    }
    
    public static String raicesDeCuadratica(float a, float b, float c){
        return ((b*b-4*a*c)<0)? "No existen raices en R." : " Raiz 1 : "+
                (-b+Math.sqrt(b*b-4*a*c))/(2*a)+
                " | Raiz 2 : "+(-b-Math.sqrt(b*b-4*a*c))/(2*a);
    }
    
}