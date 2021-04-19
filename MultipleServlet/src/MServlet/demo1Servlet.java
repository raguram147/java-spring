package MServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demo1Servlet
 */

public class demo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() {
        System.out.println("hi init");

	}
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demo1Servlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("hi constructor");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append("fgy");
	}
	public void destroy() {
    	System.out.println("this is servlet1 destroy method");
    }

	

}
