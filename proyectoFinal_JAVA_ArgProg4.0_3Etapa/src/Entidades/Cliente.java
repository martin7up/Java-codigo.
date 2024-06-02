
package Entidades;

import java.lang.reflect.Method;
import java.text.Annotation;

public class Cliente implements Entidades{
    private long idCliente;
    private long dni;
    private String apellido;
    private String nombre;
    private String domicilio;
    private String telefono;

    public Cliente() {
    }

    public Cliente(long dni, String apellido, String nombre, String domicilio, String telefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Cliente(long idCliente, long dni, String apellido, String nombre, String domicilio, String telefono) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    @AnotacionMetodosGet(order = 1)
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    @AnotacionMetodosGet(order = 2)
    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
    @AnotacionMetodosGet(order = 3)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @AnotacionMetodosGet(order = 4)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @AnotacionMetodosGet(order = 5)
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    @AnotacionMetodosGet(order = 6)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return apellido + " " + nombre + " (Dni: " + dni + ")";
    }  
    
    @Override
    public int metodosAnotados(){
        int i = 0;
        for (Method method : this.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(AnotacionMetodosGet.class)) {
                i++;//Se cuenta cuantos son anotados
            }
        }
        return i;
    }
}
