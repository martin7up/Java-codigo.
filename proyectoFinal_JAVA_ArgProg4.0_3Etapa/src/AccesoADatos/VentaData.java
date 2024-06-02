
package AccesoADatos;

import Entidades.Cliente;
import Entidades.Entidades;
import Entidades.Venta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;


public class VentaData {
    ClienteData clData;
    private Connection con = null; 
    
    public VentaData(){
        con = Conexion.getConexion();
    }

    public void registraVenta(Venta venta){
        
        String sql = "INSERT INTO venta(idVenta,idCliente,fechaVenta,estado) VALUES (null,?,?,0);";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,venta.getCliente().getIdCliente());
            ps.setDate(2,Date.valueOf(venta.getFechaVenta()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                venta.setIdVenta(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"Venta Registrada!\nId : "+venta.getIdVenta());
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
        }
    }
    
    public void eliminarVenta(int idVenta){//Esto, creo, no funciona; viola restricciones de claves foraneas en tabla detalleVenta en BD.
        String sql = "DELETE FROM venta WHERE Venta.idVenta = ?;";
 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            JOptionPane.showMessageDialog(null, "Va a eliminar la venta " + idVenta);
            ps.setInt(1, idVenta);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Venta Eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta");
        }
    }
    
    public void modificarVenta(Venta venta){
        String sql="UPDATE venta SET idCliente=? ,fechaVenta= ? WHERE idVenta=? ;";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1,venta.getCliente().getIdCliente());
            ps.setDate(2,Date.valueOf(venta.getFechaVenta()));
            ps.setInt(3,venta.getIdVenta());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Venta Modificada");
            }
            ps.close();    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Venta");
        }     
    }
    
    public Collection<Venta> listarVentasDeUnCliente(long idCliente){
        
        Collection ventas = null;
        
        String sql = "SELECT idVenta, fechaVenta FROM venta WHERE "
                + "venta.idCliente = ? ORDER BY venta.fechaVenta DESC;";
        try{
            //Preparacion de consulta p/BD
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, idCliente);
            //Ejecucion de consulta y almacenamiento de respuesta desde BD
            ResultSet rs = ps.executeQuery();
            //Preparacion de retorno.
            ventas = new LinkedList<>();
            //En este metodo todas las ventas tienen el mismo cliente, no es necesario que esta linea este dentro del while().
            Cliente cliente = new Cliente();
            cliente.setIdCliente(idCliente);

            while(rs.next()){
                Venta venta = new Venta();//Si se deja fuera del while esta linea,
                                            //produce un resultado indeseado en la
                venta.setCliente(cliente);  //tabla de la vista VentaFormulario.
                venta.setIdVenta(Integer.parseInt(rs.getString("idVenta")));
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());

                ventas.add(venta);
                venta = null;
                cliente = null;
            }
            //Cierre de conexion.
            ps.close();

        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta.");
        }
        return ventas;
    }
    
    public Collection<Venta> listarTodasLasVentas(String campo, String orden){
        
        Collection<Venta> ventas = null;
        
        String sql = "SELECT venta.idVenta, venta.idCliente, venta.fechaVenta , venta.estado, "+
                "cliente.dni, cliente.apellido, cliente.nombre FROM venta JOIN "+
                "cliente ON(venta.idCliente=cliente.idCliente) "+
                "ORDER BY "+campo+" "+orden+" ;";
            
        try{
            //Preparacion de consulta p/BD
            PreparedStatement ps = con.prepareStatement(sql);
            //Ejecucion de consulta y almacenamiento de respuesta desde BD
            ResultSet rs = ps.executeQuery();
            //Preparacion de retorno.
            ventas = new LinkedList<>();

            while(rs.next()){
                //En este metodo cada venta tiene un cliente diferente.
                Cliente cliente = new Cliente();
                cliente.setIdCliente((int) Long.parseLong(rs.getString("idCliente")+""));
                cliente.setDni((int) Long.parseLong(rs.getString("dni")+""));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                //Instanciacion de cada venta traida desde BD.
                Venta venta = new Venta();
                venta.setCliente(cliente);
                venta.setIdVenta(Integer.parseInt(rs.getString("idVenta")+""));
                venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                venta.setEstado(rs.getBoolean("estado"));

                ventas.add(venta);
                cliente = null;
                venta = null;
            }
            //Cierre de conexion.
            ps.close();

        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta.");
            sqlE.printStackTrace();
        }
        return ventas;
    }
    
    public Collection<Venta> listarVentasXFecha(LocalDate fechaVenta){
        String sql="SELECT * FROM venta WHERE venta.fechaVenta = ?;";
        LinkedList<Venta> ventas = null;
        Venta vta;
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs=ps.executeQuery();
            
            ventas=new LinkedList<>();
            clData = new ClienteData();
            
            while(rs.next()){
                vta=new Venta();
                
                vta.setIdVenta(rs.getInt("idVenta"));
                vta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                vta.setCliente(clData.buscarClienteXId(rs.getLong("idCliente")));
                
                ventas.add(vta);
                vta = null;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
        }
        return ventas;
    }
    
    public Venta buscarVentaXId (int idVenta){
    
        Venta vta = null;
       
        String sql = "SELECT idVenta, fechaVenta FROM venta WHERE venta.idVenta = ?;";
        /*Hay que ver como detectar cuando devuelve un objeto sin columnas desde BD*/
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                vta = new Venta();
                
                vta.setIdVenta(idVenta);
                vta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());

            }

            ps.close();

        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }
       
        return  vta;
    }
    
    public boolean cerrar() throws SQLException{
        this.con.close();
        return con.isClosed();
        
    }
}