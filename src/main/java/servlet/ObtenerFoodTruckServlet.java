
package servlet;

import com.google.gson.Gson;
import dto.UserRegistro.FoodTruckResponse;
import gestores.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(

name = "ObtenerFoodTruckServlet",
urlPatterns = {"/usuario/foodTruck"}
        
)


public class ObtenerFoodTruckServlet extends HttpServlet{
    
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idFoodTruck=Integer.parseInt(request.getParameter("idFoodTruck"));
        GestorBD gestor = GestorBD.getInstance();

        FoodTruckResponse foodTruck=new FoodTruckResponse();
        foodTruck.setIdFoodTruck(idFoodTruck);


        gestor.obtenerFoodTruck(foodTruck);
        String json=new Gson().toJson(foodTruck);


        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
        

    }
    
    
    
    
    
}
