
package servlet;

import adapters.perfil.PerfilAdapter;
import com.google.gson.Gson;
import dto.UserRegistro.ClienteResponse;
import factories.PerfilFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(
name="PerfilServlet",
urlPatterns = {"/usuario/perfil"}
)

public class MostrarPerfilServlet extends HttpServlet{
        
    //En este metodo get se debe enviar un indicador si el pefil a mostrar sera de cliente o foodtruck
    @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        int tipo= Integer.parseInt(request.getParameter("tipo"));
        
        ClienteResponse clienteSession=(ClienteResponse)session.getAttribute("cliente");
        PerfilAdapter perfil=PerfilFactory.getInstance().obtenerPerfil(tipo);         
        ClienteResponse cliente=perfil.mostrarPerfil(clienteSession.getId_Cliente(), tipo);
         
        response.setContentType("application/json");
        String json=new Gson().toJson(cliente);
        
        PrintWriter out = response.getWriter();
        out.print(json);  
     
     
 }   
    
     
}
