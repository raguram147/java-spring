package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//+*import java.util.ArrayList;

//import Model.Boat;

public class JdbcInsert {
	static CheckBoat cb=new CheckBoat();
	public static void insert(String name,int id,int capacity) {
		if(CheckBoat.checkBoat(id)!=1){
		String dbURL = "jdbc:mysql://localhost:3306/sample";
		String username = "root";
		String password = "root";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO Boat (Boat_name,ID ,Capacity) VALUES (?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,name);
			statement.setInt(2, id);
			statement.setInt(3, capacity);
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new Boat was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
		else {
			System.out.println("Boat Already Exist You can Update");
		}
	}

}
