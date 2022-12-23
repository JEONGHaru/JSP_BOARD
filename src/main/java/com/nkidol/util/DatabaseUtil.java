package com.nkidol.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	
	public static Connection getConnection() {
		
		String dbURL = "jdbc:mysql://localhost:3306/BBS";
		String dbID = "jky";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbURL,dbID,dbPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
