package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher registrationDispatcher = getServletContext()
				.getRequestDispatcher("/student_registration.html");
		registrationDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Define RequestDispatcher to forward if student registered
		// successfully in db.
		RequestDispatcher successDispatcher = getServletContext().getRequestDispatcher("/registration_success.jsp");
		// Define RequestDispatcher to forward any errors occurred during
		// registration.
		RequestDispatcher errorDispatcher = getServletContext().getRequestDispatcher("/registration_error.jsp");

		// Read parameters from request
		String registrationNumber = request.getParameter("rn");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Student student = new Student(registrationNumber, name, surname, username, password);
		StudentService studentService = new StudentService();
		try {
			studentService.registerStudent(student);
			// Add Student object to request
			request.setAttribute("student", student);
			// Forward request to registration_success.jsp
			successDispatcher.forward(request, response);
		} catch (Exception e) {
			// Add error to request
			request.setAttribute("error", e.getMessage());
			// Forward errors to the registration_error.jsp
			errorDispatcher.forward(request, response);
		}
	}

}
