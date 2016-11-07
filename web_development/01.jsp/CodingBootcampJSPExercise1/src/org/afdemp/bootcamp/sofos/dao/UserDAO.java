package org.afdemp.bootcamp.sofos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.afdemp.bootcamp.sofos.domain.User;

public class UserDAO {

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

private Connection con = null;
	
	public void open() throws SQLException {
		try {
			// dynamically load the driver's class file into memory
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			
			throw new SQLException("MySQL Driver error: " + e.getMessage());
		}

		try {
			// establish a connection with the database and creates a Connection
			// object (con)
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp_db", "root", "pass");
		} catch (Exception e) {
			con = null;
			// throw SQLException if a database access error occurs
			throw new SQLException("Could not establish connection with the Database Server: " + e.getMessage());
		}

	} // End of open

	public void close() throws SQLException {
		try {
			// if connection is open
			if (con != null)
				con.close(); // close the connection to the database to end database session			

		} catch (Exception e3) {
			
			throw new SQLException("Could not close connection with the Database Server: " + e3.getMessage());
		}

	}// end of close
	
	public User authenticateUser (String username, String password) throws Exception {
		
		if(con == null) {
			throw new Exception("You must open a connection first");
		}
		
		String sqlquery= "SELECT * FROM user_table WHERE username=? AND password=?;";
		
		try {
			
			PreparedStatement stmt2 = con.prepareStatement(sqlquery);
			stmt2.setString( 1, username );
			stmt2.setString( 2, password );
			
			ResultSet rs = stmt2.executeQuery();
			
			if(!rs.next()) {
				rs.close();
				stmt2.close();
				throw new Exception("Wrong username or password");
			}
			
			rs.previous();
			
			User user = null;
			
			while(rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"))  ;				
			}
			
			rs.close();
			stmt2.close();
			
			return user;			
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
		
	} //End of authenticateUser
	
} //End of class
