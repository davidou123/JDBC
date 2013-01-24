package com.davidou;

import java.sql.*;

// delete a employee data
public class DeleteDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db03";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			String del_stmt = "DELETE employee WHERE empno=?";
			PreparedStatement pstmt = conn.prepareStatement(del_stmt);
			pstmt.setInt(1, 1009);
			int num = pstmt.executeUpdate();
			System.out.println("delete count = " + num);
			
			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("empname") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(Exception e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class DeleteDemo
