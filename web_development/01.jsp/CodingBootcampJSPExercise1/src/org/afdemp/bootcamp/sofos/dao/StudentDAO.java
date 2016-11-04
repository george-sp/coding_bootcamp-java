package org.afdemp.bootcamp.sofos.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import org.afdemp.bootcamp.sofos.domain.Student;

public class StudentDAO {

	public StudentDAO() {
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp", "root", "pass");
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
				con.close(); // close the connection to the database to end
								// database session

		} catch (Exception e3) {

			throw new SQLException("Could not close connection with the Database Server: " + e3.getMessage());
		}

	}// end of close

	public List<Student> getStudents() throws Exception {

		try {

			if (con == null) {
				throw new Exception("You must open a connection first");
			}

			String sqlquery = "SELECT * FROM student_table;";

			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Student> studentList = new ArrayList<Student>();

			while (rs.next()) {

				studentList.add(new Student(rs.getString("name"), rs.getString("surname"), rs.getString("am")));

			}

			rs.close();
			stmt1.close();

			return studentList;

		} catch (Exception e) {

			throw new Exception("An error occured while getting students from database: " + e.getMessage());
		}

	}// End of getStudents

	public void registerStudent(Student student) throws Exception {

		try {

			if (con == null) {
				throw new Exception("You must open a connection first");
			}

			String sql = "INSERT INTO  student_table (am, name, surname) VALUES (?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, student.getAm());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getSurname());

			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e) {

			throw new Exception("Student with AM: " + student.getAm() + " already exists");

		} catch (Exception e) {

			throw new Exception("An error occured while inserting student to database: " + e.getMessage());
		}

	}// End of getStudents

	/*
	 * You must complete the code
	 */
	public Student findStudentByAM(String am) throws Exception {

		Student student = null;
		
		try {

			if (con == null) {
				throw new Exception("You must open a connection first");
			}

			String sqlquery = "SELECT * FROM student_table WHERE student_table.am = ?;";

			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			stmt1.setString(1, am);
			ResultSet rs = stmt1.executeQuery();

			if (rs.next()) {

				student = new Student(rs.getString("name"), rs.getString("surname"), rs.getString("am"));

			}

			rs.close();
			stmt1.close();

		} catch (Exception e) {

			throw new Exception("An error occured while searching for student in the database: " + e.getMessage());
		}
		
		return student;
	}// End of getStudents

}// End of class
