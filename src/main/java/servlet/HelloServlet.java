package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "homeServlet",
        urlPatterns = {"/home"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("<style>".getBytes());
        out.write("h1 {".getBytes());
        out.write("font-family:arial,helvetica;".getBytes());
        out.write("}".getBytes());
        out.write("</style>".getBytes());

        out.write("<h1 style=\"text-align:center;\"> Typing Game! </h1>".getBytes());


        out.flush();
        out.close();
    }
    
}
