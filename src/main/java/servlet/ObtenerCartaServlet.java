
package servlet;


import com.google.gson.Gson;
import dto.UserRegistro.ProductoResponse;
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

name="ObtenerCartasServlet",
urlPatterns = {"/usuario/productos"}
        
)

public class ObtenerCartaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idFoodTruck = Integer.parseInt(request.getParameter("idFoodTruck"));
        GestorBD gestor = GestorBD.getInstance();

        ///List<ProductoResponse> productos = gestor.obtenerProductos(idFoodTruck);
        //String json = new Gson().toJson(productos);
        
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        //out.print(json);


    }

}
