import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class JDBCMysql {
	
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
    		
    		ResultSet rs=stmt.executeQuery("select e_id,e_name from emp"); 
    		while(rs.next()) {
    			System.out.println(rs.getInt("e_id")+" | "+(rs.getString("e_name")));
    		}
    		stmt.close();
    		rs.close();
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
		// TODO Auto-generated method stub
		connectToMysql();
	}

}
