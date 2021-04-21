package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckBoat {
	public static int checkBoat(int num) {
	String dbURL = "jdbc:mysql://localhost:3306/sample";
	String username = "root";
	String password = "root";
	
	try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
		String sql = "SELECT Boat_name, ID FROM Boat where id="+num;
		PreparedStatement statement = conn.prepareStatement(sql);
		boolean result=statement.execute();
		if(result==true) {
			return 1;
		}
		
//		
//		else {
//			return 0;
//		}
		conn.close();
		statement.close();

	}
	catch (SQLException ex) {
		ex.printStackTrace();
	}
	return 0;	
	}
}

