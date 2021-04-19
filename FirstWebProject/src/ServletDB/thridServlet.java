package ServletDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class thridServlet
 */
@WebServlet("/thridServlet")
public class thridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public void init() {
           System.out.println("Welcome"+this.getClass().getSimpleName()+"from the init");

       }
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
    public thridServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Welcome"+this.getClass().getSimpleName()+"from the constructor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append("sdr");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
