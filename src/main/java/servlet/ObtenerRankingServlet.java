
package servlet;

import com.google.gson.Gson;
import dto.UserRegistro.FoodTruckResponse;
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
name="ObtenerRankginServlet",
urlPatterns = {"/usuario/ranking"}
      
)

public class ObtenerRankingServlet extends HttpServlet{
    
    
    @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor=GestorBD.getInstance();
        //List<FoodTruckResponse>ranking=gestor.obtenerRanking();
        
       // String json=new Gson().toJson(ranking);
        response.setContentType("application/json");
        
        PrintWriter out = response.getWriter();
        //out.print(json);
 
        
     
     
 
 }    
}
