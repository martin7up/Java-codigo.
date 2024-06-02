package segundaGuia_FundamentosDelLenguajeJava;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main_ejercicio02 {
    public static void main(String[] args){
        
        do{
            System.out.print("Ingrese la nota a continuacion : >>> ");
        }while(!(GuiaRepasoC.ejercicio1((new Scanner(System.in)).nextInt())));
    
        GuiaRepasoC.ejercicio2(new Scanner(System.in));
        System.out.println("La suma de valores ingresados ha superado el limite establecido.");
    
        GuiaRepasoC.ejercicio5(new Scanner(System.in));

        GuiaRepasoC.ejercicio6((byte) 9);

        GuiaRepasoC.ejercicio7(Arrays.asList(-9,2,5,6,10,1));
        
    }

}

abstract class GuiaRepasoC{
    
    public static float validacion(String solicitud, String mnsjError, Scanner sc, boolean esEntero){
        while(true){//Ciclo p/solicitud y validacion de limite
            try{
                System.out.print(solicitud);
                return (esEntero)? (int) sc.nextInt() : sc.nextFloat();
            }catch(InputMismatchException ime){
                System.out.println(mnsjError);
                sc.next();
            }
        } 
    }//Si el argumento bool es true, devuelve un float truncado.
  
    public static boolean ejercicio1(int numero){
        return (numero>=0&&numero<=10);
    }
    
    public static void ejercicio2(Scanner sc){
        int aux = 0, numero;
        numero = (int) validacion("\nLimite ¿? : ", "\n!Error¡", sc, false);
        while(true){//Ciclo p/verificacion de valor alcanzado por aux
            aux = (int) (aux + validacion("Valor ¿? : ", "!Error¡", sc, false));   
            if(aux>=numero){
                sc.close();
                return;
            }
        }
    }
    
    public static void ejercicio3(Scanner sc){
        while(true){
            System.out.print("MENU\n1.Sumar\n2.Restar\n3.Multiplicar\n4.Dividir\n5.Salir\nElija opcion : ");
            switch((int)validacion("Opcion : ","#Error#",sc,true)){
                case 1: System.out.println("Suma igual a : "+
                        (Math.abs((int)validacion("Primer Valor","Error",sc,true))+
                                Math.abs((int)validacion("Segundo Valor","Error",sc,true))));break;
                case 2: System.out.println("Resta igual a : "+
                        (Math.abs((int)validacion("Primer Valor","Error",sc,true))-
                                Math.abs((int)validacion("Segundo Valor","Error",sc,true))));break;
                case 3: System.out.println("Multiplicacion igual a : "+
                        (Math.abs((int)validacion("Primer Valor","Error",sc,true))*
                                Math.abs((int)validacion("Segundo Valor","Error",sc,true))));break;
                case 4: System.out.println("Division igual a : "+
                            (float)(Math.abs((int)validacion("Primer Valor","Error",sc,true))/
                                Math.abs((int)validacion("Segundo Valor","Error",sc,true))));break;
                case 5: {
                            System.out.println("Desea salir ¿? (S/N)");
                            if(sc.nextLine().trim().toUpperCase().charAt(0)=='S'){
                                sc.close();
                                return;
                            }
                        }
                default : System.out.println("Opcion no disponible!!!");break;
            }
        }
    }
    
    public static void ejercicio4(Scanner sc){
        System.out.println("Ingrese a continuacion hasta 20 numeros cualesquiera.\n(Sin ingresa el numero cero finalizara la adquisicion de valores.)");
        float acum = 0, valor = 0;
        for(int i=0; i<20; i++){
            valor = validacion("Valor ¿? : ","!Formato_Incorrecto¡",sc,false);
            if(valor==0)break;
            acum+= (valor>0)? valor : 0;//No se deben sumar numeros negativos.
        }
        System.out.println((valor==0)? "Se ingreso el valor 0; total acumulado : "+acum : "Total cummulado : "+acum);
        sc.close();
    }
    
    public static void ejercicio5(Scanner sc){
        byte i = 0,j = 0;
        String car;
        while(true){
            System.out.println("(XabcO), max : 5, (&&&&&) FIN; -> ¿? : >>> ");
            car= sc.nextLine();
            if(car.equals("&&&&&"))
                break;
            else if(car.length()==5 && car.startsWith("X") && car.endsWith("O"))
                i++;
            else
                j++;
        }
        System.out.println("Se ingresaron en formato correcto "+i+" cadenas y "+j+" incorrectas.");
        sc.close();
    }
    
    public static void ejercicio6(byte numero){
        byte i=0,a=0, j=1;
        while(i<numero){
            if(i==0||i==numero-1){
                while(a<numero){
                    System.out.print('*');
                    a++;
                }               
                System.out.print("\n");
                a=0;
            }else{
                System.out.print('*');
                while(j<numero-1){
                    System.out.print(' ');
                    j++;
                }                
                System.out.println('*');
                j=1;
            }
            i++;
        }
        System.out.println("\n{Es un cuadrado de "+numero+" unidades de medida.}");
    }
    
    public static void ejercicio7(List<Integer> list){
        list.forEach((aux) -> {
            System.out.print(Math.abs(aux));
            for(int i=0; i<Math.abs(aux); i++)System.out.print('*');
            System.out.print("\n");
        });
    }
}
    /*private static int validacionInt(String solicitud, String mnsjError, Scanner sc){
        return (int)validacionFloat(solicitud, mnsjError, sc);
    }Metodo que empleaba metodo validacion sin op ternario y solo sc.nextFloat();*/