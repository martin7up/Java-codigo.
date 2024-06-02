
package tercerGuia_RelacionesEntreClases;

import java.util.Random;

public class Main_ejercicio05 {
    public static void main(String[] args){
        
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        Dado dado3 = new Dado();
        
        Jugador jug1 = new Jugador("Pocho");
        
        jug1.tirarDado(dado3);
        System.out.println(jug1.verClasificacion()+" "+dado3.verNro());
        jug1.tirarDado(dado2);
        System.out.println(jug1.verClasificacion()+" "+dado2.verNro());
        jug1.tirarDado(dado1);
        System.out.println(jug1.verClasificacion()+" "+dado1.verNro());
        
        Dado dado4 = new Dado();
        Dado dado5 = new Dado();
        Dado dado6 = new Dado();
        
        Jugador jug2 = new Jugador("Pepe");
    
        jug2.tirarDado(dado4);
        System.out.println(jug2.verClasificacion()+" "+dado4.verNro());
        jug2.tirarDado(dado5);
        System.out.println(jug2.verClasificacion()+" "+dado5.verNro());
        jug2.tirarDado(dado6);
        System.out.println(jug2.verClasificacion()+" "+dado6.verNro());       
    }
}

class Jugador{
    private String nombre;
    private int clasificacion;
    
    public Jugador(){}
    public Jugador(String nombre){
        this();
        this.setNombre(nombre);
        
    }
    
    public int verClasificacion(){ return this.clasificacion;}
    
    public void tirarDado(Dado dado){
        dado.generarNro();
        this.clasificacion+= dado.verNro();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (validar(nombre))? nombre : this.nombre;
        
    }
    
    public static boolean validar(String string){
        for(char aux : string.trim().toLowerCase().toCharArray()){
            if(!Character.isAlphabetic(aux)) return false;
        }
        return true;
    }
    
}

class Dado{
    private int numero;
    private static Random rndNum;
    
    static{
        rndNum = new Random();
    }
    
    public Dado(){
        this.numero= rndNum.nextInt(6);
    }
    
    public void generarNro(){
        this.numero= (this.numero== 0)? this.rndNum.nextInt(6) : this.numero;
    }
    
    public int verNro(){
        return this.numero;
    }

    @Override
    protected void finalize() throws Throwable {
        rndNum= null;
        super.finalize();
    }
}