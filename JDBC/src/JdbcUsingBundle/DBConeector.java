package JdbcUsingBundle;
import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConeector {
	
	

	public static void main(String[] args) {
		try {
		ResourceBundle bundle= ResourceBundle.getBundle("resources",Locale.US);
		String dbname =  bundle.getString("dbname");
        String url =  bundle.getString("url");
        String userid =  bundle.getString("userid");
        String pass = bundle.getString("pass");
        String tablename = "dep";

        Class.forName(dbname);
        System.out.println("DRIVERS LOADED...");
        
        Connection conn = DriverManager.getConnection(url, userid, pass);
        
       CallableStatement stmt=conn.prepareCall("{call display(?,?)}");  
        System.out.println("CONNECTION CREATED...");
       // CallableStatement rstmt=conn.prepareCall("{call countDept(?,?)}"); 
        ResultSet rs = stmt.executeQuery("select *from dep");
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("=================================|");
        
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

            System.out.print(rsmd.getColumnName(i) + "	 |");
        }
       System.out.println("");
       System.out.println("TOTAL DEPARTMENTS   ");
      System.out.println("=================================|");
        while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+(rs.getString(2))+" | "+(rs.getInt(3))+"                 |");
			System.out.println("---------------------------------|");
		}
		stmt.close();
		rs.close();
		conn.close();
		System.out.println("=================================");
      
   } catch (Exception e) {
        e.printStackTrace();
    }
}
		
}


