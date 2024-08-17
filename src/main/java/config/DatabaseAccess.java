package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess {
	private final static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost/RESTAURANT";
	private final static String USERNAME = "postgres";
	private final static String PASSWORD = "root";

	private DatabaseAccess() {
	}
	
	@SuppressWarnings("deprecation")
	public static Connection getConnection() throws SQLException {
		Connection cn = null;
		try {
			Class.forName(DRIVER_CLASS_NAME).newInstance();
			cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return cn;
	}

}
