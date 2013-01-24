package com.davidou;

import java.sql.*;

// getType() practice 
/*
	empno		decimal(4)			PRIMARY KEY,
	empname		varchar(30)			NOT NULL,
	hiredate	datetime			NOT NULL,
	salary		decimal(10,2)		NOT NULL,
*/
public class QueryDemo2 {
	public static void main(String[] args) {
		Connection conn =null;
		try {     
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=db03";
			 conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			
			while(rs.next()) {
			
				/*	int empno = rs.getInt("empno");
				String empname = rs.getString("empname");
				java.util.Date hiredate = rs.getDate("hiredate"); // 2004-12-25
				/*int thisYear = hiredate.getYear() + 1900;//thisYear = 2003
				int thisMonth = hiredate.getMonth() + 1;//thisMonth = 5
				int thisDate = hiredate.getDate();//thisDate = 30
				double salary =  rs.getDouble("salary");  // 56000.0
			*/
				String empno = rs.getString("empno");
				String empname = rs.getString("empname");
				String hiredate = rs.getString("hiredate"); // 2004-12-25 00:00:00.0
				hiredate=hiredate.substring(0,4)+"/"+hiredate.substring(5,7)+"/"+hiredate.substring(8,10);
				String salary =  rs.getString("salary");  // 56000.00
				/*
				Object empno = rs.getObject("empno");
				Object empname = rs.getObject("empname");
				Object hiredate = rs.getObject("hiredate"); // 2004-12-25 00:00:00.0
				Object salary =  rs.getObject("salary");  // 56000.00
				
				int empno = rs.getInt(1);
				String empname = rs.getString(2);
			//	java.util.Date hiredate = rs.getDate(3); // 2004-12-25
				java.sql.Date hiredate = rs.getDate(3); // 2004-12-25, java.sql.Date extends java.util.Date
				double salary =  rs.getDouble(4);  // 56000.0
			*/	
				System.out.println("id = " + empno);
				System.out.println("name = " + empname);
				System.out.println("hire date = " + hiredate);
				//System.out.println("¤é´Á = " + thisYear+"/"+thisMonth+"/"+thisDate);
				System.out.println("salary = " + salary);
				System.out.println("----------------------------");

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
}// end of class QueryDemo2
