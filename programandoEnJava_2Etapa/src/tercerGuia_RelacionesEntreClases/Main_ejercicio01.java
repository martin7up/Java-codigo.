
package tercerGuia_RelacionesEntreClases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main_ejercicio01 {
    public static void main(String[] args) {
        
        Kiosco coskio = new Kiosco("El Chakan 24hs", "Dan Lorenzo 997", "25-999824-01");
        
        coskio.incorporarEmpleado(new Empleado("Jorge ","Krenick",LocalDate.parse("25/09/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")),33025889L));
        coskio.incorporarEmpleado(new Empleado(" Damian"," Albertini  ",LocalDate.parse("15/10/1979", DateTimeFormatter.ofPattern("dd/MM/yyyy")),33025849L));
        coskio.incorporarEmpleado(new Empleado("Jor ge","Dalam",LocalDate.parse("13/02/2009", DateTimeFormatter.ofPattern("dd/MM/yyyy")),30015889L));
        coskio.incorporarEmpleado(new Empleado("Carlos","Oconnor",LocalDate.parse("02/12/1999", DateTimeFormatter.ofPattern("dd/MM/yyyy")),34025889L));
        coskio.incorporarEmpleado(new Empleado("Erica"," Gutierrez   ",LocalDate.parse("23/08/2015", DateTimeFormatter.ofPattern("dd/MM/yyyy")),31025889L));
        
        
        System.out.println(coskio.toString());
        System.out.println(coskio.mayorAntiguedad().toString());
        
        System.out.println(coskio.buscarEmpleado(33025889L, "KRENICK"));
        System.out.println(coskio.buscarEmpleado(53025829L, "KRENICK"));
        
        coskio.desvincularEmpleado(coskio.buscarEmpleado(33025889L, "KRENICK"));
        System.out.println("\n"+coskio.toString());
 
    }
}

final class Kiosco{
    private String nombre, direccion, cuit;
    private Empleado[] empleados;
    private byte cantEmpleados = -1;//Para evitar el uso de for en metodo agregarEmpleado
    
    public Kiosco(){this.empleados = new Empleado[3];}
    public Kiosco(String direccion, String nombre, String cuit){
        this.nombre=nombre;
        this.direccion=direccion;
        this.cuit=cuit;
        this.empleados = new Empleado[3];
    }
    
    public void incorporarEmpleado(Empleado empleado){
        if(cantEmpleados<2){ 
            cantEmpleados++;
            empleados[cantEmpleados] = empleado;
        }
    }
    
    public byte buscarEmpleado(long dni, String apellido){
        if(cantEmpleados==-1) return -1;
        for(byte i= 0; i<this.cantEmpleados; i++){
            if(empleados[i].getDni()== dni && empleados[i].getApellido().toLowerCase().contains(apellido.toLowerCase()))
                return i;
        }
        return -1;
    }//En este metodo deveuelve -1 si : no hay empleados contratados o si no se encontro ninguna coincidencia.
    
    public void desvincularEmpleado(byte i){
        this.empleados[i]= null;
    }
    
    public Empleado mayorAntiguedad(){
        if(cantEmpleados==-1) return null;
        Empleado mayor = this.empleados[0];
        for(Empleado empleado : this.empleados) mayor = (empleado!=null && empleado.getFechaIngreso().isBefore(mayor.getFechaIngreso()))? empleado : mayor;
        return mayor;
    }

    @Override
    public String toString() {
        return "Kiosco{" + "nombre=" + nombre + ", direccion=" + direccion + ", cuit=" + cuit + ",\t\n empleados=\t\n" + Arrays.toString(empleados) + '}';
    }
    //Setters y Getters
    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.trim();
    }

    public void setCuit(String cuit) {
        this.cuit = cuit.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCuit() {
        return cuit;
    }
    
}

class Empleado{
    private String nombre, apellido;
    private final LocalDate fechaIngreso;
    private long dni;
    
    public Empleado(String nombre, String apellido, LocalDate fechaIngreso, long dni){
        this.nombre = nombre.trim();
        this.apellido = apellido.trim();
        this.fechaIngreso = fechaIngreso;
        this.dni = (dni>0&&dni<=Long.MAX_VALUE)? dni : -1L;    
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public long getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    public void setApellido(String apellido) {
        this.apellido = apellido.trim();
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", Fecha Ingreso=" +fechaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +'}'+"\n";
    }
    
}