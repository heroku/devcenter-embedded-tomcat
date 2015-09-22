package servlet;

import dto.UsuarioRequest;
import gestores.GestorBD;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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

        GestorBD gestor = new GestorBD();

        InputStream is = request.getInputStream();
        Reader reader = new InputStreamReader(is, "utf-8");

        //UsuarioRequest ususario=new  Gson().fromJson(reader,Usuario.class);
        UsuarioRequest request1 = new UsuarioRequest();
        request1.setNombre("ESTO LO INICIO DESDE CELULAR");
        request1.setEmail("lalala1212@gmail.com");
        request1.setUsuario("p1231212");
        request1.setPass("hola");

        boolean completo = gestor.RegistrarUsuario(request1);

        ServletOutputStream out = response.getOutputStream();
        out.write(("rpta:"+completo).getBytes());
        out.flush();
        out.close();


    }
    
}
