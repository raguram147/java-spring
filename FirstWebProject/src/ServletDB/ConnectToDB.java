package ServletDB;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class ConnectToDB extends HttpServlet{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
	  ServletConfig config=getServletConfig();  
	  String driver=config.getInitParameter("driver");  
      final String DB_URL="jdbc:mysql://localhost/bank";

      
      final String USER = "root";
      final String PASS = "root";
      
      //Servlet context
      ServletContext context=getServletContext();  
      String ur=context.getInitParameter("uid");
      if(ur.equals("ragu")) {
    	  System.out.println("Hi,, Ragu");
      }

      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      try {

         Class.forName(driver);

         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         Statement stmt = conn.createStatement();
         String sql;
         sql = "SELECT e_id, e_name, sal, city FROM emp";
         ResultSet rs = stmt.executeQuery(sql);

         while(rs.next()){
            int id  = rs.getInt("e_id");
            String name = rs.getString("e_name");
            int salary = rs.getInt("sal");
            String city = rs.getString("city");

            //Display values
            out.println("ID: " + id + "<br>");
            out.println(", Name: " + name + "<br>");
            out.println(", Salary: " + salary + "<br>");
            out.println(", City: " + city + "<br>");
            out.println("<br>");
         }
         out.println("</body></html>");

         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {

         se.printStackTrace();
      } catch(Exception e) {
         e.printStackTrace();
      } 
   }
} 
