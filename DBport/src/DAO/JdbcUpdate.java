package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.Statement;

public class JdbcUpdate {

	
	public static void updatecap(int cap, int id) {
		if(CheckBoat.checkBoat(id)==1){
			String dbURL = "jdbc:mysql://localhost:3306/sample";
			String username = "root";
			String password = "root";
			
			try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
				
				PreparedStatement ps=conn.prepareStatement("UPDATE boat set Capacity=? where ID=?");
				ps.setInt(1, cap);
				ps.setInt(2, id);
				int r=ps.executeUpdate();
				if(r>0){
				System.out.println("A Boat capacity was Updated successfully!");
								}
				

				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}		
		}
			else {
				System.out.println("Boat not Found New Entry");
			}
		}
		// TODO Auto-generated method stub
		
	}


