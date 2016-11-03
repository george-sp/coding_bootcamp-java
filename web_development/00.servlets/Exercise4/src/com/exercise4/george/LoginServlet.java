package com.exercise4.george;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<body>");
		response.getWriter().append("<form action=\"/Exercise4/login\" method=\"POST\">");
		response.getWriter().append("username:<br>");
		response.getWriter().append("<input name=\"username\">");
		response.getWriter().append("<br>password:<br>");
		response.getWriter().append("<input type=\"password\" name=\"password\">");
		response.getWriter().append("<br><br>");
		response.getWriter().append("<input type=\"submit\" value=\"Servlet post\">");
		response.getWriter().append("</form>");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (password != null && password.equals("pass")) {
			response.getWriter().append("Hello, " + username);
		} else {
			response.getWriter().append("Sorry, wrong input");
		}
	}

}
