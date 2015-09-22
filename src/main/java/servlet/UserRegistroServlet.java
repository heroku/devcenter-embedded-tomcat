package servlet;

import com.google.gson.Gson;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        GestorBD gestor = new GestorBD();

        UsuarioRequest usuarioRequest = gson.fromJson(request.getReader(), UsuarioRequest.class);

        UsuarioRequest request1 = new UsuarioRequest();
        request1.setNombre("ESTO LO INICIO DESDE CELULAR");
        request1.setEmail("lalala1212@gmail.com");
        request1.setUsuario("p1231212");
        request1.setPass("hola");


        UsuarioResponse usuarioResponse = new UsuarioResponse();
        if (gestor.RegistrarUsuario(usuarioRequest)) {
            usuarioResponse.setMsgStatus("Ok");
        } else {
            usuarioResponse.setMsgError("Error!!");
        }

        response.getOutputStream().print(gson.toJson(usuarioResponse));
        response.getOutputStream().flush();

    }

}
