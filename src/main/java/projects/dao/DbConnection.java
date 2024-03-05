package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {

	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER,
				PASSWORD);

		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Successfully obtained connection to projects.");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			throw new DbException(e);
		}
	}
}

/*
 * this class obtains a JDBC Connection object from the driver manager that
 * looks up the MySQL driver and loads it to establish a TCP connection to the
 * server. If the connection fails, a SQLException is thrown in a catch block.
 */