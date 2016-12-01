
package servlet;


import com.google.gson.Gson;
import dto.UserRegistro.DireccionResponse;
import dto.UserRegistro.UsuarioResponse;
import gestores.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
name ="ObtenerDireccion",
urlPatterns = {"/usuario/direccion"}
)

public class ObtenerDireccionServlet extends HttpServlet{
    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idFoodTruck = Integer.parseInt(request.getParameter("idFoodTruck"));
        
        GestorBD gestor = GestorBD.getInstance();
        DireccionResponse direccion = gestor.obtenerDireccion(idFoodTruck);

        response.setContentType("application/json");
        String json = new Gson().toJson(direccion);
        
        PrintWriter out = response.getWriter();
        out.print(json);
        
    }
    
}
