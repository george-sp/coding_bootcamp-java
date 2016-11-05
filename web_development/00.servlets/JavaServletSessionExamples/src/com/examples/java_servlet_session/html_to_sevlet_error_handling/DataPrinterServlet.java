package html_to_sevlet_error_handling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet receives an http POST request and prints all the parameter's
 * values
 * 
 * Servlet implementation class DataPrinterServlet
 */
@WebServlet("/DataPrinterServlet")
public class DataPrinterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataPrinterServlet() {
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

		/*
		 * gets parameters from the request.
		 */
		String name = request.getParameter("nameField");
		String surname = request.getParameter("surnameField");
		String username = request.getParameter("usernameField");
		String password = request.getParameter("passwordField");
		String preferences = request.getParameter("preferencesField");
		String gender = request.getParameter("genderField");
//		String age = request.getParameter("ageField");

		try {
			/*
			 * Converts parameter's values from ISO-8859-1 to ISO-8859-7 (Greek)
			 * in case the user typed data in Greek.
			 */
			name = new String(name.getBytes("ISO-8859-1"), "ISO-8859-7");
			surname = new String(surname.getBytes("ISO-8859-1"), "ISO-8859-7");
			username = new String(username.getBytes("ISO-8859-1"), "ISO-8859-7");
			password = new String(password.getBytes("ISO-8859-1"), "ISO-8859-7");
			preferences = new String(preferences.getBytes("ISO-8859-1"), "ISO-8859-7");
			gender = new String(gender.getBytes("ISO-8859-1"), "ISO-8859-7");

			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>DataPrinterServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>DataPrinterServlet is running...</h3>");
			out.println("<hr><h2>You filled in the data below:</h2>");
			out.println("<b>Name: </b>" + name + "<br>");
			out.println("<b>Surname: </b>" + surname + "<br>");
			out.println("<b>username: </b>" + username + "<br>");
			out.println("<b>password: </b>" + password + "<br>");
			out.println("<b>Intersts: </b>" + preferences + "<br>");
			out.println("<b>Gender: </b>" + gender + "<br>");
			out.println("<b>Age: </b> > 18<br>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
