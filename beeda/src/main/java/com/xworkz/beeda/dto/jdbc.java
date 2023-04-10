package com.xworkz.beeda.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connobject = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root",
					"Gagan5144@");
			String insertQuery = "insert into beeda_table values(0, 'xworkz', 'omkar', 'sweet' , 10, 2 )";
			java.sql.Statement statement = connobject.createStatement();
			statement.executeUpdate(insertQuery);

			int rowsAffected = statement.executeUpdate(insertQuery);
			System.out.println("rowsAffected" + rowsAffected);

			connobject.close();
		} catch (ClassNotFoundException e) {
			System.out.println("class not found" + e.getMessage());
		}

		catch (SQLException se) {
			System.out.println("SQLException" + se.getMessage());
		}
	}

}
