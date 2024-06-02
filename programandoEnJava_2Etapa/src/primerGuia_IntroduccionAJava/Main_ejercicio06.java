
package primerGuia_IntroduccionAJava;

public class Main_ejercicio06 {
    public static void main(String[] args){
        Numero numero = new Numero();
        System.out.println(numero.getNumero());
        
        numero.setNumero(12);
        System.out.println(numero.getNumero()+"\nEs par : "+numero.esPar()+
                "\nEs positivo : "+numero.esPositivo()+
                "\nEs multiplo de 3 : "+numero.esMultiploDe(3));        
    }
}

class Numero{
    int numero;
    
    public Numero(){}
    public Numero(int numero){
         this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public boolean esPar(){
        return (this.numero)%2==0;
    }
    
    public boolean esPositivo(){
        return this.numero > 0;
    }
    
    public boolean esMultiploDe(int numero){
        return this.numero%numero == 0;
    }
}