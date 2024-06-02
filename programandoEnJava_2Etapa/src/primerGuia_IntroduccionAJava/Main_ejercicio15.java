
package primerGuia_IntroduccionAJava;

public class Main_ejercicio15 {
    public static void main(String[] args){
//        int cont = 1, numero = 15536952, aux = 0, aux1 = 0;
//        while(true){
//            aux = (int) (numero/(Math.pow(10,cont)));
//            if(aux<1)break;
//            cont++;
//        }
//        aux=0;
//        for(int i=1; i<=cont; i++){
//            aux = (int) (numero%(Math.pow(10, i)));
//            aux1 = (int) (aux*(Math.pow(10, cont)));
//            aux1 = aux1+
//            cont--;
//            System.out.println(aux);
//        }En algun momento tratar de terminar el proced matemat.

        Pensador pensador = new Pensador(-99821623);
        
        System.out.println("Valor de instancia : "+pensador.getValor()+"\nValor invertido : "+
                pensador.invertir()+"\nPrimer digito : "+pensador.primerDigito()+
                "\nUltimo digito : "+pensador.ultimoDigito()+"\nPar inmediato anterior : "+
                pensador.parAnterior()+"\nPar inmediato posterior : "+pensador.parPosterior());
  
    }
}
class Pensador{
    private int valor;
    
    public Pensador(){}
    public Pensador(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public int invertir(){
        int aux = Integer.valueOf((new StringBuilder()).append(String.valueOf(Math.abs(this.valor))).reverse().toString());
        return (this.valor>0)? aux : -aux;
    }
    
    public int parAnterior(){
        int cont=1;
        while(true){
            if((this.valor-cont)%2==0)return (this.valor-cont);
            cont++;
        }
    }
    
    public int parPosterior(){
        int cont=1;
        while(true){
            if((this.valor+cont)%2==0)return (this.valor+cont);
            cont++;
        }
    }
    
    public int primerDigito(){
        return Integer.valueOf((Math.abs(this.valor)+"").charAt(0)+"");
    }
    
    public int ultimoDigito(){
        return Math.abs(this.valor%10);
    }
}