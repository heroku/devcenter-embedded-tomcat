package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dto.UsuarioRequest;


/**
 * @author GARY
 */
public class GestorBD {
    //Metodos de BD

    public boolean RegistrarUsuario(UsuarioRequest usuario) {

        String sql = "insert into ft_usuario (usuario,pass,nombre,email) values(?,?,?,?)";

        try {

            Connection conn = ConeccionBD.GetConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPass());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getEmail());

            int confirmacion = ps.executeUpdate();

            if (confirmacion == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
