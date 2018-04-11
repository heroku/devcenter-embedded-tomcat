package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
)
public class HelloServlet extends HttpServlet {

    @Resource(name = "jdbc/TestDB")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Connection con = ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(HelloServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ServletOutputStream out = resp.getOutputStream();
        out.write("helloooo heroku".getBytes());
        out.flush();
        out.close();
    }

}
