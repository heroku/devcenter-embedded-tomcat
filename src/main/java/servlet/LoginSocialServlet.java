/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import adapters.login.LoginAdapter;
import adapters.login.LoginFacebookAdapter;
import com.google.gson.Gson;
import dto.UserRegistro.UsuarioResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
name = "LoginSocialServlet",
urlPatterns = {"/login-social"}
)


public class LoginSocialServlet extends HttpServlet{
    
    
 @Override       
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
     LoginAdapter loginFacebook= new LoginFacebookAdapter();
     UsuarioResponse usuario;
        try {
        
            String urlCallback = loginFacebook.login(request);
            usuario=new UsuarioResponse("OK","", urlCallback);

        } catch (Exception ex) {
            usuario=new UsuarioResponse("Exception",ex.getMessage(),null);
               
        }
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(usuario));
     
     
     
     
     
 
 
 }    
    
    
    
    
    
    
    
}
