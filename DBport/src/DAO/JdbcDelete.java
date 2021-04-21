package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A sample program that demonstrates how to execute SQL DELETE statement
 * using JDBC. 
*
*/
public class JdbcDelete {

	public static void DeleteDBOfBoat(int num) {
		String dbURL = "jdbc:mysql://localhost:3306/sample";
		String username = "root";
		String password = "root";
				
		 
		try {
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
			String sql = "DELETE FROM boat WHERE id="+num;
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A boat was deleted successfully!");
			}
//			else {
//				System.out.println("A boat Not Found");
//
//			}
			conn.close();
			statement.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		
	}
}
