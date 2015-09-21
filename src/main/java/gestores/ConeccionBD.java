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
        } catch (Exception ex) {
            conexion = null;
        }
        return conexion;
    }
}
