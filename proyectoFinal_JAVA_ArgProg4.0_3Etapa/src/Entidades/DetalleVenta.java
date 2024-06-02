
package Entidades;

import java.lang.reflect.Method;


public class DetalleVenta implements Entidades{
    private int idDetalleVenta;
    private int cantidad;
    private Venta venta;
    private double precioVenta;
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public DetalleVenta(int idDetalleVenta, int cantidad, Venta venta, double precioVenta, Producto producto) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }
    @AnotacionMetodosGet
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }
    @AnotacionMetodosGet
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    @AnotacionMetodosGet
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    @AnotacionMetodosGet
    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    @AnotacionMetodosGet
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", cantidad=" + cantidad + ", venta=" + venta + ", precioVenta=" + precioVenta + ", producto=" + producto + '}';
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
