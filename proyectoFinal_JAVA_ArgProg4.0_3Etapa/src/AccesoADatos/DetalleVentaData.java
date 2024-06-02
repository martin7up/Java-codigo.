/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleVentaData {
    private Connection con=null;
    ClienteData clData = new ClienteData();
    VentaData vtaData = new VentaData();
    
    public DetalleVentaData(){
        con=Conexion.getConexion();
    }
    
    
    public void cargarDetalleVenta(DetalleVenta detVent){
        
        String sql0 = "SELECT producto.stock, producto.estado FROM producto WHERE idProducto = ?;";
        try {
            
            PreparedStatement ps=con.prepareStatement(sql0);
            ps.setInt(1, detVent.getProducto().getIdProducto());
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            JOptionPane.showMessageDialog(null,"Cantidad : "+rs.getInt("stock")+" disponible : "+rs.getBoolean("estado"));
            
            if(!rs.getBoolean("estado")){
                JOptionPane.showMessageDialog(null,"El producto no se encuentra disponible para la venta.\n Su estado es : "+rs.getBoolean("estado"));
                ps.close();
                rs = null;
                return;//Si el producto tiene estado false, se informa y no se asienta en BD.
            }
            
            if(rs.getInt("stock")<detVent.getCantidad()){
                JOptionPane.showMessageDialog(null,"Solo se dipone de : "+rs.getInt("stock")+" en stock.");
                ps.close();
                rs = null;
                return;//Si la cantidad requerida(a comprar) es mayor que la disponible, se informa y no se asienta en BD.
            }
            
            ps.close();
        
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
            sqlE.printStackTrace();//Permite ver el error por consola.
        }
        
        //Esta modificacion solo se intenta si no se ejecuto el cuerpo de alguno de los if.
        String sql1 = "INSERT INTO detalleventa(cantidad, idVenta, precioVenta, idProducto) VALUES (?,?,?,?);";
        String sql2 = "UPDATE producto,venta SET producto.stock = (producto.stock - ?), venta.estado = 1  WHERE producto.idProducto = ? and venta.idVenta = ?;"; 

        try {

            PreparedStatement ps=con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,detVent.getCantidad());
            ps.setInt(2,detVent.getVenta().getIdVenta());
            ps.setDouble(3,detVent.getPrecioVenta());
            ps.setInt(4,detVent.getProducto().getIdProducto());

            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();

            if(rs.next()){
               detVent.setIdDetalleVenta(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"DETALLE VENTA AGREGADO");
            }

            ps.close();
            
            //Aqui se intenta modificar el stock reduciendolo en la cantidad comprada.
            ps=con.prepareStatement(sql2);
            ps.setInt(1,detVent.getCantidad());
            ps.setInt(2,detVent.getProducto().getIdProducto());
            ps.setInt(3, detVent.getVenta().getIdVenta());
            
            int exito=ps.executeUpdate();
            if(exito>1){
                JOptionPane.showMessageDialog(null,"Stock Modificado");
            }
            
            ps.close(); 

        }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
                sqlE.printStackTrace();//Permite ver el error por consola.
        }
        
    }
    
    public List<Producto>listarProductoXfecha(LocalDate fechaVenta){
        String sql="SELECT * FROM producto WHERE producto.idProducto IN (SELECT detalleventa.idProducto"
                + " FROM Venta JOIN DetalleVenta ON venta.idVenta = detalleventa.idVenta"
                + " WHERE venta.fechaVenta = ?)";
        ArrayList<Producto>productos=new ArrayList();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Producto prod=new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setEstado(rs.getBoolean("estado"));
                
                productos.add(prod);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
        }
        
      return productos;  
    }
    
    
    
    public List<Cliente>listarClientesXProducto(int idProducto){
    String sql="SELECT * FROM cliente WHERE cliente.IdCliente IN (SELECT "
            + "venta.idCliente FROM venta WHERE venta.idVenta IN (SELECT "
            + "detalleventa.idVenta FROM detalleventa WHERE detalleventa.idProducto = ?));";
            
    
        ArrayList<Cliente>clientes=new ArrayList();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl=new Cliente();
                
                cl.setIdCliente(rs.getInt("idCliente"));
                cl.setDni(rs.getInt("DNI"));
                cl.setApellido(rs.getString("apellido"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDomicilio(rs.getString("domicilio"));

                clientes.add(cl);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
        }
        return clientes;
    }
    
    public DetalleVenta buscarDetalleVentaXId(int idDetalleVenta) {
    DetalleVenta detalleVenta = null;

    String sql = "SELECT detalleventa.cantidad " +
                 "FROM detalleventa " +
                 "WHERE detalleventa.idDetalleVenta = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idDetalleVenta);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            detalleVenta = new DetalleVenta();
            detalleVenta.setCantidad(rs.getInt("cantidad"));
        }

        ps.close();
    } catch (SQLException sqlE) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
        sqlE.printStackTrace();
    }

    return detalleVenta;
}
   
     public List<DetalleVenta> listarVentasDeUnCliente(long dni){
        
        ArrayList <DetalleVenta>ventas = new ArrayList<>();
        
            String sql = "SELECT * FROM detalleventa WHERE detalleventa.idVenta IN (SELECT venta.idVenta "
                    + "FROM venta JOIN cliente ON venta.idCliente = cliente.idCliente "
                    + "WHERE cliente.dni= ? ORDER BY venta.fechaVenta DESC)";
            
                try{
                    //Preparacion de consulta p/BD
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setLong(1, dni);
                    //Ejecucion de consulta y almacenamiento de respuesta desde BD
                    ResultSet rs = ps.executeQuery();
                    //Preparacion de retorno.

                    //En este metodo todas las ventas tienen el mismo cliente, no es necesario que esta linea este dentro del while().
                   
                    while(rs.next()){
                        DetalleVenta deVta = new DetalleVenta();
                        ProductoData prodData = new ProductoData();
                        VentaData vtaDta = new VentaData();
                        Venta venta =vtaDta.buscarVentaXId(rs.getInt("idVenta"));

                        Producto prod = prodData.buscarProductoXId(rs.getInt("idProducto"));
                       deVta.setProducto(prod);
                       deVta.setVenta(venta);
                       deVta.setCantidad(rs.getInt("cantidad"));
                       deVta.setPrecioVenta(rs.getDouble("precioVenta"));
                       deVta.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
   
                        ventas.add(deVta);
                    }
                    //Cierre de conexion.
                    ps.close();
                    
                }catch(SQLException sqlE){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta.");
                }
        return ventas;
    }
    
    public boolean cerrar() throws SQLException{
        this.con.close();
        return con.isClosed();
    }
}
