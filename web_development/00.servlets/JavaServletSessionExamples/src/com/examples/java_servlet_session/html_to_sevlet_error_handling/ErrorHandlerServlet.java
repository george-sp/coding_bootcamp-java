package html_to_sevlet_error_handling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet receives an http POST request, informs and prints which
 * parameter does not have a value.
 * 
 * Servlet implementation class ErrorHandlerServlet
 */
@WebServlet("/ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorHandlerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-7");
		PrintWriter out = new PrintWriter(response.getWriter(), true);

		try {
			/*
			 * gets parameters from the request.
			 */
			String name = request.getParameter("nameField");
			String surname = request.getParameter("surnameField");
			String username = request.getParameter("usernameField");
			String password = request.getParameter("passwordField");
			String preferences = request.getParameter("preferencesField");
			String gender = request.getParameter("genderField");
			String age = request.getParameter("ageField");
			/*
			 * An integer to count errors (optional).
			 */
			int countErrors = 0;

			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>ErrorHandlerServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>ErrorHandlerServlet is running...</h1><br>");
			out.println("<h3>You made the following mistakes:</h3>");
			out.println("<font color='#FF0000'>");

			/*
			 * if user did not type anything in field name
			 */
			if (!(name.length() > 0))
				out.println("<font color='#FF0000'><b>" + ++countErrors + ") You have not filled in Name!</b><br>");
			/*
			 * if user did not type anything in field surname
			 */
			if (!(surname.length() > 0))
				out.println("<b>" + ++countErrors + ") You have not filled in Surname!</b> <br>");
			/*
			 * if user did not type anything in field username
			 */
			if (!(username.length() > 0))
				out.println("<b>" + ++countErrors + ") You have not filled in username!</b> <br>");
			/*
			 * if user did not type anything in field password
			 */
			if (!(password.length() > 0))
				out.println("<b>" + ++countErrors + ") You have not filled in password!</b> <br>");
			/*
			 * if user did not choose anything in field preferences
			 */
			if (preferences.equals("0"))
				out.println("<b>" + ++countErrors + ") You have not filled in Intersts!</b> <br>");
			/*
			 * if user did not choose anything in field gender
			 */
			if (gender == null)
				out.println("<b>" + ++countErrors + ") You have not filled in gender!</b> <br>");
			/*
			 * if user did not check the field age
			 */
			if (age == null)
				out.println("<b>" + ++countErrors + ") You have not over 18!</b> <br>");

			out.println("</font>");
			out.println("</body></html>");

		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
