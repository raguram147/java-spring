package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelect {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/sample";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public static void selectAll() {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
//	      DBTablePrinter.printTable(conn, "Boat");
	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery("SELECT * FROM Boat");
	      System.out.println("========================================");
	      System.out.println("ID          Boat Name         Capacity  ");
	      System.out.println("========================================");   
	         while (rs.next()) {
	        	 
	            int id = rs.getInt("ID");
	            String name = rs.getString("Boat_name");
	            int cap = rs.getInt("capacity");
	            System.out.println(id+"          "+name+"              "+cap);
	         }
	     
//	      //STEP 5: Extract data from result set
//	         int id;
//	         String name=null;
//	         int cap;
//	         while(rs.next()){
//	         //Retrieve by column name
//	         id  = rs.getInt(2);
//	         name = rs.getString(1);
//	         cap = rs.getInt(3);
//	         
//
//	         //Display values
//	         System.out.println(  id+"   "  + name +"      " + cap);
//	         System.out.println(", Last: " + last);

	      rs.close();
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

}}