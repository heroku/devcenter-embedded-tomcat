package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	
    @Override
	public void init() throws ServletException {
		System.out.println("initializing HelloServlet");
		super.init();
	}
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("initializing HelloServlet");
    	super.init();
    }

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("hello heroku!!!".getBytes());
        out.flush();
        out.close();
    }
    
}
