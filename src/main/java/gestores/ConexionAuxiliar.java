
package gestores;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionAuxiliar {
    
        public static Connection GetConnection() {
        Connection conexion;
        try {

            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            conexion = null;
        }
        return conexion;
    }
    
    
    
    
    
    
    
    
}
