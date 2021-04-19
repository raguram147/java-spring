package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Boat;

public class ShowBoat {

	public static ArrayList<Boat> find(int num) {
		// TODO Auto-generated method stub
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost:3306/sample";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "root";
		   
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      stmt = conn.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM Boat where ID="+num);
		      ArrayList<Boat> boats = new ArrayList<>();
		      while (rs.next()) {
		          Boat bt = new Boat(rs.getInt(2), rs.getString(1), rs.getInt(3));
		          boats.add(bt);
		      }
		      return boats;
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return null;

	}
		
		

}
