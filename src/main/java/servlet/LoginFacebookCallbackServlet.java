
package servlet;

import adapters.login.LoginAdapter;
import adapters.login.LoginFacebookAdapter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
name = "LoginFacebookCallbackServlet",
urlPatterns = {"/login-facebook-callback"}
)

public class LoginFacebookCallbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LoginAdapter loginAdapter = new LoginFacebookAdapter();
            loginAdapter.verificarLogin(request);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        response.sendRedirect("");
    }

}
