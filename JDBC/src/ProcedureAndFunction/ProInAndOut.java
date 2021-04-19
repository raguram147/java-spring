package ProcedureAndFunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProInAndOut {
	public static void main(String[] args) {
		try {
		ResourceBundle bundle= ResourceBundle.getBundle("resources",Locale.US);
		String dbname =  bundle.getString("dbname");
        String url =  bundle.getString("url");
        String userid =  bundle.getString("userid");
        String pass = bundle.getString("pass");
        String tablename = "chennai";

        Class.forName(dbname);
        System.out.println("DRIVERS LOADED...");
        
        Connection conn = DriverManager.getConnection(url, userid, pass);
        System.out.println("CONNECTION CREATED...");
       CallableStatement stmt=conn.prepareCall("{call display(?,?)}");  
       ResultSet rs = stmt.executeQuery("SELECT *FROM dep");
       ResultSetMetaData rsmd = rs.getMetaData();
       System.out.println("=================================|");
       
       for (int i = 1; i <= rsmd.getColumnCount(); i++) {

           System.out.print(rsmd.getColumnName(i) + "	 |");
       }
      System.out.println("");
      System.out.println("=================================|");
      while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+(rs.getString(2))+" | "+(rs.getInt(3))+"                 |");
			System.out.println("---------------------------------|");
		}
		stmt.close();
		rs.close();
		conn.close();
        
		}
		catch (Exception e) {
	        e.printStackTrace();
	    }

}
}
