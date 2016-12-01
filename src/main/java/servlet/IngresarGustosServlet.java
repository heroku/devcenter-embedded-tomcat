

package servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.UserRegistro.ClienteResponse;
import dto.UserRegistro.GustosResponse;
import gestores.GestorBD;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(
        name ="SeleccionarGustosServlet",
        urlPatterns = {"/usuario/sendGustos"}

)

public class IngresarGustosServlet extends HttpServlet{
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException,IOException {
    
        InputStream is= request.getInputStream();
        Reader reader=new InputStreamReader(is,"utf-8");
        
        GestorBD gestor=GestorBD.getInstance();
        List<GustosResponse> gustos=new Gson().fromJson(reader,new TypeToken<List<GustosResponse>>(){}.getType());
        
        HttpSession session=(HttpSession)request.getSession();        
        ClienteResponse cliente=(ClienteResponse)session.getAttribute("cliente");
        
        gestor.ingresarGustos(gustos, cliente);
        

        
    }
    
    
    
    
    
    
}
