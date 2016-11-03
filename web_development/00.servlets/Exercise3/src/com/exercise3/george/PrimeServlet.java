package com.exercise3.george;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeServlet
 */
@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrimeNumber prime;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrimeServlet() {
		super();
		prime = new PrimeNumber();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String htmlForm = "<!DOCTYPE html><html><body><form action=\"/Exercise3/prime\" method=\"POST\">Give a number:<br><input type=\"text\" name=\"entry\"><br><br><input type=\"submit\" value=\"Submit\"></form><p>Click the submit button to check if the given number is a prime one.</p></body></html>";
		response.getWriter().append(htmlForm);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.prime.setNumber(Integer.parseInt(request.getParameter("entry")));
		} catch (NumberFormatException e) {
			System.out.println("Hello Prime");
			e.printStackTrace();
		}

		if (prime.isPrime()) {
			response.getWriter().append("Success");
		} else {
			response.sendRedirect("/bootcamp/hello");
		}
	}

}
