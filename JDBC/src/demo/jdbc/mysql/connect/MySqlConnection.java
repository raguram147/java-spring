package demo.jdbc.mysql.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	static String url="jdbc:mysql://localhost:3306/bank";
	static String uid="root";
    static String pass="root";
    static Connection conn=null;
    static Connection mysqlConnection() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,uid,pass);
			System.out.println("Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    
    }
    

}
