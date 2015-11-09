
package servlet;

import com.google.gson.Gson;
import dto.UserRegistro.GustosResponse;
import gestores.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
name ="GustosServlet",
urlPatterns = {"/usuario/gustos"}

)

public class SeleccionarGustosServlet extends HttpServlet{
    
    
@Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       response.setContentType("application/json");
       
       List<GustosResponse> gustos=GestorBD.getInstance().seleccionarGustos();
       String json=new Gson().toJson(gustos);
       
       response.setContentType("application/json");
       PrintWriter out = response.getWriter();
       out.print(json); 
 
 }    
    
}
