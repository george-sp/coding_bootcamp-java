package org.afdemp.bootcamp.sofos.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.afdemp.bootcamp.sofos.dao.UserDAO;
import org.afdemp.bootcamp.sofos.domain.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Get username and password from the login form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// String to store the error message
		String errorMessage = "";

		// Define an error RequestDispatcher to send the error message to login.jsp
		RequestDispatcher errorDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		// Define a register RequestDispatcher
		RequestDispatcher registerDispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		
		// Get the HttpSession that is associated with this request
				HttpSession session = request.getSession();
		
		// Define a UserDAO object to interact with the database
		UserDAO userDAO = new UserDAO();
		// Define a User object to store the User retrieved from the db
		User user = null;

		// Get a connection with the database via userDAO
		try {
			userDAO.open();
		} catch (SQLException e) {
			errorMessage += "Error during opening connection: " + e.getMessage() + "<br>";
		}

		// Get User object based on username and password
		try {
			user = userDAO.authenticateUser(username, password);
		} catch (Exception e) {
			errorMessage += "Error during User authentication: " + e.getMessage() + "<br>";
		}

		// Close the opened database connection
		try {
			userDAO.close();
		} catch (SQLException e) {
			errorMessage += "Error during closing connection: " + e.getMessage() + "<br>";
		}

		// Check if a user with the given username and password exists
		if (user != null) {
			// If user exists, bid the User object to the session
			session.setAttribute("user-object", user);
			registerDispatcher.forward(request, response);
		} else {
			// Set the error message as an attribute to the request and forward
			// it
			request.setAttribute("msg", errorMessage);
			errorDispatcher.forward(request, response);
		}
	}

}
