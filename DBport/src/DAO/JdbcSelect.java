package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controller.Bill;
import Controller.Receipt;
import Model.Boat;
import Model.bills;

public class JdbcSelect {
	public static int t,ca,bid1,b;
	static String bname,st;
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

}

	public static void updatecap(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      con = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
//		      DBTablePrinter.printTable(conn, "Boat");
		      stmt = con.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM Boat where ID="+id);

		      int id1 = 0,cap = 0;
		      String name = null;
		         while (rs.next()) {
		        	 
		            id1 = rs.getInt("ID");
		            name = rs.getString("Boat_name");
		            cap = rs.getInt("capacity");
		            
		         }
		   Boat bt=new Boat(id1,name,cap);
		   bt.setBoatCapacity(cap);
		   Boat b1=new Boat();
		   bid1=b1.getBoatNumber();
		   ca=b1.getBoatCapacity();
		   bname=b1.getBoatName();
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
	            con.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(con!=null)
	            con.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
		
	}

	public static ArrayList<bills> bill(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.cj.jdbc.Driver");

		      //STEP 3: Open a connection
		      con = DriverManager.getConnection(DB_URL, USER, PASS);
		      stmt = con.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * FROM bills where Boat_ID="+id);
		      ArrayList<bills>bill = new ArrayList<>();
		  		while (rs.next()) {
		  		          bills b = new bills(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4));
		  		          bill.add(b);
		  		}
		  		      return bill;
		  		   
		   
//		   int amt=Receipt.bill(t,ca);
//			Receipt.display(b,t,bid1,ca,bname,amt,st);
		   
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
	            con.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(con!=null)
	            con.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
		return null;
		
			
	}
	
	


	}