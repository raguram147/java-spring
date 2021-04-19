package demo.jdbc.mysql.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.jdbc.mysql.connect.MySqlConnection;
public class PreparedStmtDemo {
	static MySqlConnection mysqlconn = new MySqlConnection();
	static Connection conn = null;
	static void selectDepartment(){
		conn=mysqlconn.mysqlConnection();
		String qurey="select dId,dName from dep where dId=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(qurey);
			pstmt.setInt(1, 2);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("dId")+" | "+(rs.getString("dName")));
			}
		}
		catch(SQLException sqe) {
    		sqe.printStackTrace();
    	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectDepartment();

	}

}
