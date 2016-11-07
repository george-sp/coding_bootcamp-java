package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class used for retrieving database connections.
 * 
 * @author george
 *
 */
public class DAOUtils {

	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/bootcamp_db?useSSL=false";

	// Database credentials
	private static final String USER = "root";
	private static final String PASS = "pass";

	/**
	 * Attempts to establish a connection to the database.
	 * 
	 * @return A connection to the DB_URL
	 * @throws SQLException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection()
			throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
		if (!DriverManager.getDrivers().hasMoreElements()) {
			registerDriver();
		}
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	/**
	 * Registers the JDBC driver with the DriverManager.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 */
	private static void registerDriver()
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
		DriverManager.registerDriver((Driver) Class.forName(JDBC_DRIVER).newInstance());
	}

	/**
	 * Utility method for preparing database resources.
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void prepareResources(Connection connection, PreparedStatement preparedStatement,
			ResultSet resultSet) {
		connection = null;
		preparedStatement = null;
		resultSet = null;
	}

	/**
	 * Utility method for closing open database resources.
	 *
	 * @param resultSet
	 * @param statement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection)
			throws SQLException {
		// Close resources with the opposite turn that they were opened.
		if (resultSet != null)
			resultSet.close();
		if (preparedStatement != null)
			preparedStatement.close();
		if (connection != null) {
			connection.close();
		}
	}
}
