package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    //Constantes
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="FraveMax";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;

    public Conexion() {}
    
     public static Connection getConexion(){
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                JOptionPane.showMessageDialog(null,"CONECTADO");                
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar los driver./Error al cargarse la BD.");
                ex.printStackTrace();             
            }
        }
     return connection;
    }
    
}
            //Habria que modificar los metodos de las clases de servicio para que
            //sus argumentos sean valores primitivos o Strings y no Entidades.