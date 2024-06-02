package tercerGuia_RelacionesEntreClases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.LinkedList;



public class Main_ejercicio00 {
    public static void main(String[] args){
        
//        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"");
        
//        Persona pipol = new Persona("Daniel","Estebez","09/06/1990",30856971L);
//        System.out.println(pipol.toString());
//        
//        Perro perro1 = new Perro("Bronco","Callejerito","Mediano",(byte) 3);
//        Perro perro2 = new Perro("Capitan","Salchicha","Mediano",(byte) 1);
//        Perro perro3 = new Perro("Randy","Pastor Belga","Grande",(byte) 1);
//        Perro perro = new Perro("Chiquitin","Callejerito","Pequenio",(byte) 5);
//        
//        System.out.println(pipol.adoptarPerro(perro));
//        System.out.println(pipol.adoptarPerro(perro2));
//        System.out.println(pipol.adoptarPerro(perro1));
//        System.out.println(pipol.adoptarPerro(perro3));
//        
//        System.out.println(pipol.toString());
//        
//        perro = null;
//        perro1 = null;
//        perro2 = null;
//        perro3 = null;
//
//        System.out.println(pipol.toString());

        int[][] array = new int[][]{{2,5},{2,5,9,8},{25,9,1,0,3}};
        
//        System.out.println(array.length+"\n"+array[0].length+"\n"+array[1].length+"\n"+array[2].length);
//        System.out.println(Arrays.toString(array[0])+"\n"+Arrays.toString(array[1])+"\n"+Arrays.toString(array[2]));
//        System.out.println(Arrays.deepToString(array));
//        
        Object[] yrra = new Object[]{array, new float[]{2.1F,5.0F,6.66F,8.11F,1.3F}, "Gary", new LinkedList<String>(){{add("Kakaroto"); add("Gohan"); add("Tomonobu Itagaki.");}}};
        
        for(Object aux : yrra) System.out.println((aux instanceof int[][])? Arrays.deepToString((int[][]) aux)+"\n" : "*no es objeto tipo int[][]*");
        for(Object aux : yrra) System.out.println((aux instanceof float[])? Arrays.toString((float[])aux)+"\n" : "*no es objeto tipo float[][]*");
        
    }
}

class Persona{
    //Atributos-----------------------------------------------------------------
    private String nombre, apellido, fechaNac;//Se puede modificar atraves de Set.
    private byte edad;//Se calcula a partir de fechaNac.
    private long documento;//Se puede modificar atraves de Set.
    private Perro[] perros;
    //Constructores-------------------------------------------------------------
    public Persona(){
        this.nombre = null;
        this.edad = -1;
        this.documento = -1;
        this.perros = new Perro[3];
        this.fechaNac = null;
    }
    
    public Persona(String nombre, String apellido, String fechaNac, long documento){
        this.edad = (byte) ChronoUnit.YEARS.between(LocalDate.parse(fechaNac, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now());
        
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDocumento(documento);
        this.setFechaNac(fechaNac);
        
        this.perros = new Perro[3];
    }
    
    //Setters y Getters---------------------------------------------------------
    public final void setNombre(String nombre) {
        this.nombre = (soloLetras(nombre.trim()))? nombre : this.nombre;
    }

    public final void setApellido(String apellido) {
        this.apellido = (soloLetras(apellido.trim()))? apellido : this.apellido;
    }

    public final void setFechaNac(String fechaNac) {
        this.fechaNac = (soloNumeros(fechaNac))? fechaNac : this.fechaNac;
        this.edad = (byte) ChronoUnit.YEARS.between(LocalDate.parse(this.fechaNac, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now());
    }

    public final void setDocumento(long documento) {
        try{
            this.documento = documento;
        }catch(NumberFormatException nfe){} 
    }
    
    //Metodos para validacion---------------------------------------------------
    private boolean soloLetras(String cadena){
        for(char car : cadena.toCharArray()){
            if(!Character.isLetter(car)&&!Character.isWhitespace(car)) return false;
        }
        return true;
    }
    
    private boolean soloNumeros(String cadena){
        for(String car : cadena.trim().split("/")){
            try{ Integer.parseInt(car); }catch(NumberFormatException nfe){ return false;}   
        }            
        return true;
    }
    
    //Metodos extras------------------------------------------------------------
    public String adoptarPerro(Perro perro){
        for(byte i= 0; i<this.perros.length; i++){
            if(this.perros[i] == null){
                this.perros[i] = perro;
                return perro.getNombre()+" fue adoptado exitosamente!";
            }  
        }
        return "Ya no puedo adoptar!";
    }
    
    public Perro perroMasGrande(){
        Perro mayor = this.perros[0];
        for(Perro aux : this.perros){
            mayor = (aux.getEdad()>mayor.getEdad())? aux : mayor;
        }
        return mayor;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", edad=" + edad + ", documento=" + documento + ";\nperros=" + Arrays.toString(perros)+ '}';
    }
    
    

}

class Perro{
    private String nombre, raza, tamanio;
    private byte edad;
    
    public Perro(){
        this.nombre = this.raza = this.tamanio = null;
        this.edad = -1;
    }
    
    public Perro(String nombre, String raza, String tamanio, byte edad){
        this.nombre = nombre;
        this.raza = raza;
        this.tamanio = tamanio;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + '}';
    }

}