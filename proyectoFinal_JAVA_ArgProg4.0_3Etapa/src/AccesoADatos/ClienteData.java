package AccesoADatos;

import Entidades.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;


public class ClienteData {
    private Connection con = null;
    
    public ClienteData(){
        con=Conexion.getConexion();
    }
    //Se asume que la instancia pasada p/param consta de todos los atributos requeridos.
    public int agregarCliente(Cliente cliente) {
        String sql="INSERT INTO cliente(dni,apellido,nombre,domicilio,telefono) "+
                    "VALUES(?,?,?,?,?);";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,cliente.getDni());
            ps.setString(2,cliente.getApellido());
            ps.setString(3,cliente.getNombre());
            ps.setString(4,cliente.getDomicilio());
            ps.setString(5,cliente.getTelefono());
            ps.executeUpdate();
           
            rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                cliente.setIdCliente(rs.getLong(1));
                JOptionPane.showMessageDialog(null,"Cliente agregado ");
            }
            
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla cliente.\n"
                    + "O numero de DNI previamente acentado.");
            //sqle.printStackTrace();
        } finally {
            sql = null;
            try {
                rs.close();
                ps.close();
            } catch (SQLException | NullPointerException sqle) {
                sqle.printStackTrace();
            }
            return (cliente.getIdCliente()!=0) ? (int)cliente.getIdCliente() : -1;
        }
    }
    
    public void modificarCliente(Cliente cliente){
        String sql="UPDATE cliente SET dni=?,apellido=?,nombre=?,domicilio=?,telefono=? "+
                    "WHERE idCliente=? ;";
        PreparedStatement ps = null;
        
        try {
            ps=con.prepareStatement(sql);
            ps.setLong(1,cliente.getDni());
            ps.setString(2,cliente.getApellido());
            ps.setString(3,cliente.getNombre());
            ps.setString(4,cliente.getDomicilio());
            ps.setString(5,cliente.getTelefono());
            ps.setLong(6,cliente.getIdCliente());
            
            if(ps.executeUpdate()==1){
                JOptionPane.showMessageDialog(null,"Cliente Modificado");
            }
                
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Cliente");
            sqle.printStackTrace();
       
        } finally {
            sql = null;
            try {
                ps.close();
            } catch (SQLException | NullPointerException sqle) {
                sqle.printStackTrace();
            }
        }       
    }
    
    public void eliminarClienteXId(long idCliente) {
        
        String sql0 = "DELETE FROM detalleventa WHERE detalleventa.idVenta \n" +
                     "IN (SELECT venta.idVenta FROM venta JOIN cliente ON (venta.idCliente = cliente.idCliente) \n" +
                     "WHERE cliente.idCliente = ?);";
        String sql1 ="DELETE FROM venta WHERE venta.idCliente = ?;";
        String sql2 ="DELETE FROM cliente WHERE cliente.idCliente = ?;";
        
        PreparedStatement ps = null; PreparedStatement qs = null; PreparedStatement rs = null; 
        try {
            
            (ps = con.prepareStatement(sql0)).setLong(1, idCliente);
            (qs = con.prepareStatement(sql1)).setLong(1, idCliente);
            (rs = con.prepareStatement(sql2)).setLong(1, idCliente);
            
            ps.executeUpdate();
            qs.executeUpdate();
            int filasEliminadasTablaCliente = rs.executeUpdate();
            
            if(filasEliminadasTablaCliente == 1)
                JOptionPane.showMessageDialog(null, "Informacion y Movimientos del Cliente Eliminadas/os.");
            
        } catch (SQLException | NullPointerException sqle) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la BD");
            sqle.printStackTrace();
        } finally {
            sql0=null;sql1=null;sql2=null;
            try {
                ps.close();
                qs.close();
                rs.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
    
    public Cliente buscarClienteXDni(long dniCliente){
        Cliente cl = null;
        
        String sql = "SELECT * FROM cliente WHERE dni = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
           
            (ps = con.prepareStatement(sql)).setLong(1, dniCliente);
            
            rs = ps.executeQuery();
                
           
            if(rs.next()){
    
                
                cl = new Cliente();
                cl.setIdCliente(rs.getInt("idCliente"));
                cl.setApellido(rs.getString("apellido"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDni(rs.getInt("dni"));
                cl.setDomicilio(rs.getString("domicilio"));
                cl.setTelefono(rs.getString("telefono"));
            }
        } catch(SQLException | NullPointerException sqlNpe){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
            sqlNpe.printStackTrace();
        } finally {
            sql = null;
            try {
                rs.close();
                ps.close();
            } catch (SQLException sqle) {}
  
            return cl;
        }
    }
    
    public Cliente buscarClienteXId(long idCliente){
        Cliente cl = null;
        
        String sql = "SELECT * FROM cliente WHERE idCliente = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
           
            (ps = con.prepareStatement(sql)).setLong(1, idCliente);
            
            rs = ps.executeQuery();
                
           
            if(rs.next()){
    
                
                cl = new Cliente();
                cl.setIdCliente(rs.getLong("idCliente"));
                cl.setApellido(rs.getString("apellido"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDni(rs.getLong("dni"));
                cl.setDomicilio(rs.getString("domicilio"));
                cl.setTelefono(rs.getString("telefono"));
            }
        } catch(SQLException | NullPointerException sqlNpe){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
            sqlNpe.printStackTrace();
        } finally {
            sql = null;
            try {
                rs.close();
                ps.close();
            } catch (SQLException sqle) {}
  
            return cl;
        }
    }
    
    public List<Cliente> buscarClienteXApellido(String apellido){

        List <Cliente> clientes = null;
        Cliente cl = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cliente WHERE apellido LIKE ?;";
       
        try {
           
            (ps = con.prepareStatement(sql)).setString(1, "%" + apellido + "%");

            rs = ps.executeQuery();
            clientes = new ArrayList <>();
            
            if(rs.next()){
                cl = new Cliente();
                cl.setIdCliente(rs.getInt("idCliente"));
                cl.setApellido(rs.getString("apellido"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDni(rs.getInt("dni"));
                cl.setDomicilio(rs.getString("domicilio"));
                cl.setTelefono(rs.getString("telefono"));
               
                clientes.add(cl);
            }
           
            ps.close();
           
        } catch(SQLException | NullPointerException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
            sqlE.printStackTrace();
        } finally {
            cl = null;
            sql = null;
            try {
                rs.close();
                ps.close();
            } catch (SQLException sqle) {}
            return clientes;
        }
    }
    
    public Collection<Cliente> listarClientes(){
        
            LinkedList<Cliente> clientes = null;       
            ResultSet rs = null;
            Cliente cliente = null;
            String sql = "SELECT * FROM cliente ORDER BY dni DESC;";
            
        try {
            
            rs = con.prepareStatement(sql).executeQuery();
            clientes = new LinkedList<>();

            while(rs.next()){

                cliente = new Cliente();
                
                cliente.setIdCliente((int) Long.parseLong(rs.getString("idCliente")));//Aquie pueden reemplazar el Long por Int
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni((int) Long.parseLong(rs.getString("dni")));//Aquie pueden reemplazar el Long por Int
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                
                clientes.add(cliente);    
            }
            
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, "mmm... algo salio mal al acceder a la base de datos.");
            sqlE.printStackTrace();
        } finally {
            cliente = null;
            sql = null;
            try {
                rs.close();
            } catch (SQLException | NullPointerException sqle) {}
            return clientes;
        }
    }
    
    public boolean cerrar(){
        boolean bool = false;
        try {
            this.con.close();
            bool  = con.isClosed();
            this.con=null;
            
        } catch (SQLException ex) {
            
        }
        return bool;
    }
}
    


