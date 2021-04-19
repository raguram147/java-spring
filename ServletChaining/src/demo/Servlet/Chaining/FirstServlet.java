package demo.Servlet.Chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    RequestDispatcher rd;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		//including the html page in servlet
		//rd=request.getRequestDispatcher("html/index.html");
		String uid=request.getParameter("user");
		String pass=request.getParameter("pass");
		if(uid.equals("ragu")&&pass.equals("ragu")) {
			rd=request.getRequestDispatcher("/WelcomeUser");

			rd.include(request, response);
		}
		else {
			response.sendRedirect("http://localhost:8090/ServletChaining/html/index.html");
			
		}
		out.println("Invalid User");
			
		
		
	}

}
