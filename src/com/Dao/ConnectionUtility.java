package com.Dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFashion", "root", "8143486643");

			return con;
		}
	}