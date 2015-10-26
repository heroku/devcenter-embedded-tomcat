
package servlet;


import com.google.gson.Gson;
import dto.UserRegistro.ClienteResponse;
import dto.UserRegistro.LoginRequest;
import dto.UserRegistro.UsuarioResponse;
import gestores.GestorBD;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
    
        
@Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    InputStream is = request.getInputStream();
    Reader reader = new InputStreamReader(is, "utf-8");

    LoginRequest log = new Gson().fromJson(reader, LoginRequest.class);

    GestorBD gestor = GestorBD.getInstance();
    ClienteResponse cliente = gestor.VerificarLogin(log.getUser(), log.getPassword());
    UsuarioResponse usuario;
    String json = "";
    
    if (cliente.getId_Cliente() != 0) {
        usuario = new UsuarioResponse("OK", "");
    } else {
        usuario = new UsuarioResponse("", "NO EXISTE");
    }
    
    json = new Gson().toJson(usuario);

    response.setContentType("application/json");
    response.getOutputStream().print(json);
    

     
     
     
 
 }   
    
    
    
    
}
