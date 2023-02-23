package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	
	static String URL;
	static String username;
	static String password;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fatal Error! Unable to start application");
			e.printStackTrace();
		}
		ResourceBundle bundle=ResourceBundle.getBundle("dbdetails");
		
		URL= bundle.getString("url");
		username =bundle.getString("username");
		password = bundle.getString("password");
	}
	
	public static Connection connectToDatabase() throws SQLException{
		return DriverManager.getConnection(URL,username,password);
	}
	
	public static void closeConnection(Connection conn) throws SQLException{
		conn.close();
	}

}
