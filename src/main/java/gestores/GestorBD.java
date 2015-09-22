package gestores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.UserRegistro.UsuarioRequest;
import dto.UserRegistro.UsuarioResponse;


/**
 * @author GARY
 */
public class GestorBD {
    //Metodos de BD

    public UsuarioResponse RegistrarUsuario(UsuarioRequest usuario) {

        UsuarioResponse response = new UsuarioResponse();

        String sql = "INSERT INTO ft_usuario (usuario,pass,nombre,email) VALUES(?,?,?,?)";

        try {
            Connection conn = ConeccionBD.GetConnection();
            if(conn==null){
                throw  new ClassNotFoundException();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPass());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getEmail());

            int confirmacion = ps.executeUpdate();

            if (confirmacion == 1) {
                response.setMsgStatus("Usuario Registrado");
                response.setMsgError(null);
            } else {
                response.setMsgStatus("Error");
                response.setMsgError("Hubo un problema al crear usuario, verifique los campos de datos.");
                //problema hecho por el usuario
            }
        } catch (SQLException ex) {
            response.setMsgStatus("Error");
            response.setMsgError("Error al registrar el usuario. " + ex.getCause().getMessage());
            //error de sintaxis de sql
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            response.setMsgStatus("Error");
            response.setMsgError("Error al establecer conexión con base de datos.");
            //error de sintaxis de sql
            ex.printStackTrace();
        }
        return response;
    }
}
