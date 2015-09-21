/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author GARY
 */
public class ConeccionBD {

    public static Connection GetConnection()

    {
        Connection conexion = null;

        try {

            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }
        return conexion;
    }
}
   
   
   


    
    
    
    
    
    
    
  /*  private Connection conexion;    
    public  Connection getConexion(){    
    this.conectar();        
    return  conexion;    
    }
    
    public void setConexion(Connection conexion){
    this.conexion=conexion;
    }
     
     public void conectar(){
             
      try {
          
      Class.forName("oracle.jdbc.OracleDriver");
      String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";  
         
       try {
              
          conexion = DriverManager.getConnection(BaseDeDatos, "system","nisekoi");
        
        if (conexion != null) {

            System.out.println("Conexion exitosa!");

        }else {

            System.out.println("Conexion fallida!");

        }
              
              
         } catch (SQLException ex) {
              
            Logger.getLogger(ConeccionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error en la conexion");
              
          }
         
          
          
          
      } catch (ClassNotFoundException ex) {
          
          Logger.getLogger(ConeccionBD.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("error en la cadena de conexion");
      
      } */


}
