package service;

import java.util.List;

import dao.StudentDAO;
import domain.Student;

/**
 * Service class that executes all required login regarding Students.
 * 
 * @author george
 *
 */
public class StudentService {

	private StudentDAO studentDAO = new StudentDAO();

	/**
	 * Registers a new Student to the database.
	 * 
	 * @param student
	 *            The Student to be registered
	 * @throws Exception
	 */
	public void registerStudent(Student student) throws Exception {
		studentDAO.registerStudent(student);
	}

	/**
	 * Finds the Student with the given rn
	 * 
	 * @param rn
	 * @return The Student with the specified rn
	 * @throws Exception
	 */
	public Student findStudentByRn(String rn) throws Exception {
		return studentDAO.findStudentByRn(rn);
	}

	/**
	 * Finds all registered Students in the database
	 * 
	 * @return A List with all registered Students
	 * @throws Exception
	 */
	public List<Student> findAllStudents() throws Exception {
		return studentDAO.findAllStudents();
	}

}
