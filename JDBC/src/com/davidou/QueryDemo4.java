package com.davidou;

import java.sql.*;

// Query selected employees
public class QueryDemo4 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db03";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");			
			
		//	String empno = "1001";
		//	String qryStmt = "SELECT * FROM employee WHERE empno=" + empno;
		//	Statement stmt = conn.createStatement();
		//	ResultSet rs = stmt.executeQuery(qryStmt);
			
		//	PreparedStatement pstmt = conn.prepareStatement(qryStmt);
		//	ResultSet rs = pstmt.executeQuery();
		/*		
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE empno=?");
			pstmt.setString(1, empno);
			ResultSet rs = pstmt.executeQuery();
		*/
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE deptno=? and title=?");
			pstmt.setString(1, "100");
			pstmt.setString(2, "engineer");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("name = " + rs.getString("empname"));
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
}// end of class QueryDemo4
