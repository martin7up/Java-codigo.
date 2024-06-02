
package primerGuia_IntroduccionAJava;

import static primerGuia_IntroduccionAJava.Jugador.comprobar;

public class Main_ejercicio04 {
    
    public static void main(String[] args){
        
        try {
            Perro canino1 = new Perro("Olivia", "Bulldog Frances", (byte)1, 1.2f);
            canino1.mostrarInfo();
        } catch (Exception ex) {
            System.out.println("...algo esta mal con los datos ingresados."
                    + ex.getMessage());
        }
    }
}

class Perro{
    
    private String nombre, raza;
    private byte edad;
    private float peso;
    
    public Perro(){
        this.nombre = "npd";
        this.raza = "npd";
        this.edad = -1;
        this.peso = -1.0f;
    }
    public Perro(String nombre, String raza, byte edad, float peso) throws Exception{
        this.nombre = comprobar(nombre, "Error : nombre solo admite letras y espacio; tampoco puede quedar vacio.");
        this.raza = comprobar(raza, "Error : raza solo admite letras y espacio; tampoco puede quedar vacio.");
        this.setEdad(edad);
        this.setPeso(peso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        this.nombre = comprobar(nombre, "Error : nombre solo admite letras y espacio; tampoco puede quedar vacio.");
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) throws Exception {
        this.raza = comprobar(nombre, "Error : nombre solo admite letras y espacio; tampoco puede quedar vacio.");
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = (edad>=0 && edad<=30)? edad : -1;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = (peso>0)? peso : -1;
    }
    
    public void mostrarInfo(){
        System.out.println("Nombre : "+this.nombre+", Raza : "+this.raza+", Edad : "+
                this.edad+" (anios)"+", Peso : "+this.peso+"(Kg)");
    }   

    
}