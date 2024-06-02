
package primerGuia_IntroduccionAJava;

import java.util.Scanner;

public class Main_ejercicio03 {
    
    private static Scanner sc;
    private static Jugador jugador;
    
    public static void main(String[] args){
        sc = new Scanner(System.in);
        
        do{
            System.out.println(" Nombre \n Nacionalidad \n Edad \n Puntaje Recibido ");
            try {
                jugador = new Jugador (sc.nextLine(),sc.nextLine(),sc.nextByte(),sc.nextByte());
                System.out.println(jugador.toString());
            } catch (Exception ex) { 
                System.out.println("Algun dato se ingreso de manera incorrecta ... intente nuevamente."
                        + "\n Mensaje de error : "+ex.getMessage());
                sc.reset();
            }
        } while(jugador == null);
        
        sc.close();
    }
}

class Jugador{
    
    String nombre, nacionalidad;
    byte edad, puntaje;
    
    public Jugador(){}

    public Jugador(String nombre,  String nacionalidad, byte edad, byte puntaje) throws Exception{       
        this.nombre = comprobar(nombre, "Error : Nombre solo admite letras y espacio; tampoco puede quedar vacio.");
        this.setEdad(edad);
        this.nacionalidad = comprobar(nacionalidad, "Error : Nacionalidad solo admite letras y espacio; tampoco puede quedar vacio.");       
        this.setPuntaje(puntaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception{
        this.nombre = comprobar(nombre, "Error : Nombre solo admite letras y espacio; tampoco puede quedar vacio.");        
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) throws Exception{
        this.nacionalidad = comprobar(nombre, "Error : Nacionalidad solo admite letras y espacio; tampoco puede quedar vacio.");
    }

    public byte getEdad() {
        return this.edad;
    }

    public final void setEdad(byte edad){
        this.edad = (edad>=0 && edad<=127)? edad : -1;
    }

    public byte getPuntaje() {
        return puntaje;
    }

    public final void setPuntaje(byte puntaje){
        this.puntaje = (puntaje>=0&&puntaje<=100)? puntaje : -1;
    }
    
    public static String comprobar(String aComprobar, String mnsjError)throws Exception{
        if(aComprobar != null && !aComprobar.isEmpty()){
            for(char aux : aComprobar.toCharArray()){
                if(!Character.isLetter(aux) && !Character.isWhitespace(aux)) throw new Exception(mnsjError);
            }
            return aComprobar.trim().toUpperCase();
        } else {
            throw new Exception(mnsjError);
        }
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", edad=" + edad + "anios" + ", puntaje=" + puntaje + '}';
    }
  
}
