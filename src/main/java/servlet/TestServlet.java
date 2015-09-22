package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@WebServlet(
        name = "ServletWii",
        urlPatterns = {"/test"}
    )
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

            out.write(username.getBytes());
            out.write("|||".getBytes());
            out.write(password.getBytes());
            out.write("|||".getBytes());
            out.write(dbUrl.getBytes());
            out.write("|||".getBytes());


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        out.write("hola heroku de shit".getBytes());
        out.flush();
        out.close();
    }
    
}
