package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlConnector {
	static Scanner in =new Scanner (System.in);
	static String sqlname="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/bank";
    static String uid="root";
    static String pass="root";
    static void connectToMysql() {
    	try{
    		Class.forName(sqlname);
    		Connection conn= DriverManager.getConnection(url,uid,pass);
    		System.out.println("Connected Successfully to bank....");
    		//statement creation
    		
    		Statement stmt =conn.createStatement();
    		
    		System.out.println("Enter the chocie:");
    		int ch=in.nextInt();
    		in.nextLine();
    		 
    		if(ch==1) {
    			String sql = "INSERT INTO non_emp (non_id,non_ename,non_dep_id) VALUES (?, ?, ?, ?)";
    			 
    			PreparedStatement statement = conn.prepareStatement(sql);
    			statement.setInt(1, 1);
    			statement.setString(2, "ragu");
    			statement.setInt(3, 100);
    			 
    			int rowsInserted = statement.executeUpdate();
    			if (rowsInserted > 0) {
    			    System.out.println("A new Non TechEmployee was inserted successfully!");
    			}
    		}
    		else if(ch==2) {
    			String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
    			 
    			PreparedStatement statement = conn.prepareStatement(sql);
    			statement.setInt(1, 110);
    			statement.setString(2, "ram");
    			statement.setInt(3, 101);
    			int rowsUpdated = statement.executeUpdate();
    			if (rowsUpdated > 0) {
    			    System.out.println("An existing user was updated successfully!");
    			}
    			
    		}
    		else if(ch==3) {
    			
    			String sql = "DELETE FROM Users WHERE username=?";
    			 
    			PreparedStatement statement = conn.prepareStatement(sql);
    			statement.setInt(1, 113);
    			 
    			int rowsDeleted = statement.executeUpdate();
    			if (rowsDeleted > 0) {
    			    System.out.println("A user was deleted successfully!");
    			}
    		}
    		else if(ch==4) {
    			String sql = "SELECT * FROM dep";
    			 
    			Statement statement = conn.createStatement();
    			ResultSet result = statement.executeQuery(sql);
    			 
    			int count = 0;
    			 
    			while (result.next()){
    			    Integer id = result.getInt(1);
    			    String ename = result.getString("non_ename");
    			    Integer depid = result.getInt("non_dep_id");
    			 
    			    String output = "User #%d: %s - %s - %s - %s";
    			    System.out.println(String.format(output, ++count, id, pass, ename, depid));
    			}
    			
    		}
    		
    		stmt.close();
    		conn.close();
    	}
    	catch(ClassNotFoundException e) {
    		System.out.println(e);
    	}
    	catch(SQLException sqe) {
    		sqe.printStackTrace();
    	}
    }
	public static void main(String[] args) {
		connectToMysql() ;
	
		}
		

	}


