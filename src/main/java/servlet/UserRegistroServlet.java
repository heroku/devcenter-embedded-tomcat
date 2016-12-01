package servlet;

import com.google.gson.Gson;
import dto.UserRegistro.ClienteResponse;
import dto.UserRegistro.UsuarioRequest;
import dto.UserRegistro.UsuarioResponse;
import gestores.GestorBD;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "UsuarioRegistro",
        urlPatterns = {"/usuario/registro"}
)

public class UserRegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hola heroku de shit".getBytes());
        out.flush();
        out.close();
    }

    
    //luego de registrar al usuario , el apliactivo te lleva a la pagina de login
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        Gson gson = new Gson();
        GestorBD gestor = GestorBD.getInstance();

        UsuarioRequest usuarioRequest = gson.fromJson(request.getReader(), UsuarioRequest.class);

        UsuarioResponse usuarioResponse = gestor.RegistrarUsuario(usuarioRequest);

        response.getOutputStream().print(gson.toJson(usuarioResponse));
        response.getOutputStream().flush();

    }

}
