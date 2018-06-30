package com.student.portal.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Utility implements Variable {

	public static Connection getConnection() {
		Connection connection = null;
		try {

			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("DBProp.properties");
			Properties p = new Properties();
			p.load(is);

			Class.forName(p.getProperty("CLASS"));
			connection = DriverManager.getConnection(p.getProperty("DBURL"), p.getProperty("USER"),
					p.getProperty("PASSWORD"));
			connection.setAutoCommit(false);
		} catch (Exception e) {

			System.err.println(e.getMessage());

		}
		return connection;

	}

	public static void closeConnection(Connection connection) {

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {

				System.err.println(e.getMessage());
			}

		}

	}

	public static void closeResources(PreparedStatement preparedStatement, ResultSet... rs) {

		for (ResultSet resultSet : rs) {

			if (resultSet != null) {

				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		if (preparedStatement != null) {

			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
