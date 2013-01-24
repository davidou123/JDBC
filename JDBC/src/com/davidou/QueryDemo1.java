package com.davidou;

import java.sql.*;

// Query all employees using Statement
// �ĥ�Class Loader�覡����Driver����A�õ�U��Driver Manager���X�ʵ{����U��椤
public class QueryDemo1 {
	public static void main(String[] args) {
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db03";
			Connection conn = DriverManager.getConnection(connUrl, "sa", "sa123456");
		//	String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db01;user=sa;password=passw0rd;";
		//	Connection conn = DriverManager.getConnection(connUrl);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT empname, salary FROM employee");
			
			while(rs.next()) {
				System.out.println("name = " + rs.getString("empname"));
				System.out.println("salary = " + rs.getDouble("salary"));
				
			//	System.out.println("name = " + rs.getString(1));
			//	System.out.println("salary = " + rs.getDouble(2));
			}
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// end of main()
}// end of class QueryDemo1
