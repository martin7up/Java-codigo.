
package tercerGuia_RelacionesEntreClases;

import java.util.Random;


public class Main_ejercicio04 {
    public static void main(String[] args){
        Person persona = new Person("Jorge", "Altair");
        Gps gps = new Gps("Gardin", "ABBX1");
    
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
        persona.ubicarme(gps);
    }
    
}

class Posicion{
    private Double latitud;//Para evitar posiciones erroneas en caso de valores fuera de rango.
    private Double longitud;
    
    public Posicion(){}
    public Posicion(double latitud, double longitud){
        this();
        this.setLatitud(latitud);
        this.setLongitud(longitud);
    }

    public double getLatitud() {
        return latitud;
    }

    public final void setLatitud(double latitud) {
        this.latitud = (latitud>= -90 && latitud<= 90)? latitud : null;
    }

    public double getLongitud() {
        return longitud;
    }

    public final void setLongitud(double longitud) {
        this.longitud = (longitud>= -180 && longitud<= 180)? longitud : null;
    }

    @Override
    public String toString() {
        return "Posicion{" + "latitud=" + latitud + ", longitud=" + longitud + '}';
    }
       
}

class Gps{
    private String marca; 
    private String modelo;
    private Posicion ultimaUbicacion;
    
    public Gps(){}
    public Gps(String marca, String modelo){
        this.marca= marca;
        this.modelo= modelo;
    }
    
    public void mover(){
        Random rndClss= new Random();
        byte signLat= (byte) ((rndClss.nextBoolean()== true)? 1 : -1);
        byte signLong= (byte) ((rndClss.nextBoolean()== false)? -1 : 1);
        this.ultimaUbicacion = new Posicion(rndClss.nextInt(90)*signLat, rndClss.nextInt(180)*signLong);
        rndClss = null;
    }
    
    public Posicion obtenerUltimaPosicion(){
        return this.ultimaUbicacion;
    }
 }

class Person{
    private String nombre;
    private String apellido;

    public Person(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void ubicarme(Gps gps){
        gps.mover();
        System.out.println(gps.obtenerUltimaPosicion().toString());
    }
}