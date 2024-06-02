
package Entidades;

import java.lang.reflect.Method;


public class Producto implements Entidades{
    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioActual;
    private int stock;
    private boolean estado;

    public Producto() {
    }

    public Producto(String nombreProducto, String descripcion, double precioActual, int stock, boolean estado) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(int idProducto, String nombreProducto, String descripcion, double precioActual, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }
    @AnotacionMetodosGet
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    @AnotacionMetodosGet
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    @AnotacionMetodosGet
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @AnotacionMetodosGet
    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }
    @AnotacionMetodosGet
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    @AnotacionMetodosGet
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    


    @Override
    public String toString() {
        return "  " + nombreProducto + ", "+ descripcion+", Precio  = " + precioActual + ", stock=" + stock + ", ID=" + idProducto;
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
