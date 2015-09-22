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

    public static Connection GetConnection() {
        Connection conexion = null;
        try {
            /*
            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
*/

            String username = "bd6a400a5871b4";
            String password = "22857d4d";
            String dbUrl = "jdbc:mysql://us-cdbr-iron-east-02.cleardb.net";

            Class.forName("com.mysql.jdbc.Driver");

            conexion = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            conexion = null;
        }
        return conexion;
    }
}
