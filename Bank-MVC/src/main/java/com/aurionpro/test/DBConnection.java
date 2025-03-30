package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	public static  Connection getConnection() throws SQLException
	{
		try {
			if(conn==null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdemo","root","admin");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
