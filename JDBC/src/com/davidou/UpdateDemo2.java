package com.davidou;

import java.sql.*;

// Update employee data with CallableStatement
public class UpdateDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db03";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			CallableStatement cstmt = conn.prepareCall("{call upd_emp_salary(?, ?)}");
			cstmt.setDouble(1, 44000);
			cstmt.setInt(2, 1002);
			cstmt.execute();
			
			cstmt =  conn.prepareCall("{call qry_emp(?,?,?)}");
			cstmt.setInt(1, 1002);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.DOUBLE);
			cstmt.execute();
			String empName = cstmt.getString(2);
			double salary = cstmt.getDouble(3);
			
			System.out.print("name = " + empName + ", ");
			System.out.println("salary = " + salary);
			
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
}// end of class UpdateDemo2
