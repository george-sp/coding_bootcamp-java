package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Student;

/**
 * Class for accessing database data regarding Students.
 * 
 * @author george
 *
 */
public class StudentDAO {

	// Student table fields in database.
	private static final String STUDENT_TABLE = "student_table";
	private static final String STUDENT_RN_TAG = "rn";
	private static final String STUDENT_NAME_TAG = "name";
	private static final String STUDENT_SURNAME_TAG = "surname";
	private static final String STUDENT_USERNAME_TAG = "username";
	private static final String STUDENT_PASSWORD_TAG = "password";

	// Necessary resources for a connection to the db.
	private Connection conn;
	private PreparedStatement preStmt;
	private ResultSet rs;

	public StudentDAO() {
	}

	/**
	 * Registers a new Student to the database.
	 * 
	 * @param student
	 *            The Student to be registered
	 * @throws Exception
	 */
	public void registerStudent(Student student) throws Exception {
		String sql = "INSERT INTO " + STUDENT_TABLE + "(" + STUDENT_RN_TAG + ", " + STUDENT_NAME_TAG + ", "
				+ STUDENT_SURNAME_TAG + ", " + STUDENT_USERNAME_TAG + ", " + STUDENT_PASSWORD_TAG
				+ ") VALUES (?, ?, ?, ?, ?);";
		DAOUtils.prepareResources(conn, preStmt, rs);
		try {
			conn = DAOUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, student.getRn());
			preStmt.setString(2, student.getName());
			preStmt.setString(3, student.getSurname());
			preStmt.setString(4, student.getUsername());
			preStmt.setString(5, student.getPassword());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Student with RM: " + student.getRn() + " already exists!");
		} catch (Exception e) {
			throw new Exception("An error occured while registering student to database: " + e.getMessage());
		} finally {
			DAOUtils.closeResources(rs, preStmt, conn);
		}
	}

	/**
	 * Finds the Student with the given rn
	 * 
	 * @param rn
	 * @return The Student with the specified rn
	 * @throws Exception
	 */
	public Student findStudentByRn(String rn) throws Exception {
		Student student = null;
		String sql = "SELECT * FROM " + STUDENT_TABLE + " WHERE " + STUDENT_RN_TAG + "=?;";
		DAOUtils.prepareResources(conn, preStmt, rs);
		try {
			conn = DAOUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, rn);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				student = StudentDAO.populate(rs);
			}
		} catch (Exception e) {
			throw new Exception("An error occured while searching for student in database: " + e.getMessage());
		} finally {
			DAOUtils.closeResources(rs, preStmt, conn);
		}
		return student;
	}

	/**
	 * Finds all registered Students in the database
	 * 
	 * @return A List with all registered Students
	 * @throws Exception
	 */
	public List<Student> findAllStudents() throws Exception {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT * FROM " + STUDENT_TABLE;
		DAOUtils.prepareResources(conn, preStmt, rs);
		try {
			conn = DAOUtils.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				Student studentFound = StudentDAO.populate(rs);
				students.add(studentFound);
			}
		} catch (Exception e) {
			throw new Exception("An error occured while getting Students from database: " + e.getMessage());
		} finally {
			DAOUtils.closeResources(rs, preStmt, conn);
		}
		return students;
	}

	/**
	 * Utility method that takes a result set and returns a Student object.
	 * 
	 * @param rs
	 * @return A Student object
	 * @throws SQLException
	 */
	private static Student populate(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setRn(rs.getString(STUDENT_RN_TAG));
		student.setName(rs.getString(STUDENT_NAME_TAG));
		student.setSurname(rs.getString(STUDENT_SURNAME_TAG));
		student.setUsername(rs.getString(STUDENT_USERNAME_TAG));
		student.setPassword(rs.getString(STUDENT_PASSWORD_TAG));
		return student;
	}
}
