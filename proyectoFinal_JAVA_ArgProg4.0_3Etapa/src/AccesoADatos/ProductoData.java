
package AccesoADatos;


import Entidades.DetalleVenta;
import Entidades.Producto;
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {

    private Connection con = null;   
   
        
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
    
    public void registrarProducto(Producto producto){
        
        String sql = "INSERT INTO producto(nombreProducto,descripcion,precioActual,stock,estado)"
             + "VALUES (?,?,?,?,?)";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,producto.getNombreProducto());
            ps.setString(2,producto.getDescripcion());
            ps.setDouble(3,producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setBoolean(5,producto.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
               producto.setIdProducto(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"Producto agregado!" + producto.toString());
            }
            
            ps.close();
                     
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
            sqlE.printStackTrace();
        }
    }
    
    public void eliminarProducto(int idProducto){
        String sql = "UPDATE Producto SET Estado = 0 WHERE Producto.idProducto = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto");
        }
}
    
    public void modificarProducto(Producto producto){
        String sql="update producto set nombreProducto=?,descripcion=?,precioActual=?,stock=?,estado=? "
                + "where idProducto=? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,producto.getNombreProducto());
            ps.setString(2,producto.getDescripcion());
            ps.setDouble(3,producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setBoolean(5,producto.isEstado());
            ps.setInt(6,producto.getIdProducto());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Producto Modificado");
            }
            ps.close();    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Cliente");
        }
        
    }
    
    public Producto buscarProductoXId(int idProd){
       
        Producto prod = null;
       
        String sql = "SELECT * FROM producto WHERE producto.idProducto = ?;";
        /*Hay que ver como detectar cuando devuelve un objeto sin columnas desde BD*/
        try{
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProd);
            ResultSet rs = ps.executeQuery();
            prod = new Producto();
            while(rs.next()){
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setEstado(rs.getBoolean("estado"));
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
            }
           
            ps.close();
           
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }
       
        return prod;
    }

    public List<Producto> buscarProductoXNombre(String nombreProducto){
       

        List <Producto> productos = new ArrayList <>();
        String sql = "SELECT * FROM producto WHERE producto.nombreProducto LIKE ?; ";
        
        try{
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombreProducto + "%");
            ResultSet rs = ps.executeQuery();

                
            while(rs.next()){
                Producto prod = new Producto();
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setEstado(rs.getBoolean("estado"));
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
                
                productos.add(prod);
            }
           
            ps.close();
           
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }
       
        return productos;
    }
    
    public Collection<DetalleVenta> buscarProductoXIdVenta(int idVenta){
       
        Producto prod = null;
        Collection<DetalleVenta> detalleVta = new LinkedList <>();
       
        String sql = "SELECT producto.nombreProducto, producto.descripcion, detalleventa.cantidad "
                + " FROM venta JOIN detalleventa ON venta.idVenta = detalleventa.idVenta "
                + " JOIN producto ON detalleventa.idProducto = producto.idProducto "
                + "WHERE venta.idVenta = ?;";
        /*Hay que ver como detectar cuando devuelve un objeto sin columnas desde BD*/
        try{
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
           
            while(rs.next()){
                DetalleVenta deVta = new DetalleVenta();
                prod = new Producto();
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                deVta.setCantidad(rs.getInt("cantidad"));
                deVta.setProducto(prod);
                detalleVta.add(deVta);
            }
           
            ps.close();
           
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }
       
        return detalleVta;
    }
    
    public boolean cerrar(){
        boolean bool = false;
        try {
            this.con.close();
            bool  = con.isClosed();
            this.con=null;
            
        } catch (SQLException ex) {}
        return bool;
        
    }
}