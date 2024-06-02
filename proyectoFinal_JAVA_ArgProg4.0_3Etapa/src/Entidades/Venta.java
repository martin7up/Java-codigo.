
package Entidades;

import java.lang.reflect.Method;
import java.time.LocalDate;


public class Venta implements Entidades{
    private int idVenta;
    private Cliente cliente;
    private LocalDate fechaVenta;
    private boolean estado;

    public Venta() {
    }

    public Venta(Cliente cliente, LocalDate fechaVenta, boolean estado) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public Venta(int idVenta, Cliente cliente, LocalDate fechaVenta, boolean estado) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }
    @AnotacionMetodosGet
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    @AnotacionMetodosGet(isAnObject = true)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    @AnotacionMetodosGet
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    @AnotacionMetodosGet
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idVenta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        return true;
    }
  
    @Override
    public String toString() {
        return idVenta+"(<-idVenta)"+" "+cliente.getApellido()+" "+cliente.getNombre()+ " (" + fechaVenta+ ")";
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
