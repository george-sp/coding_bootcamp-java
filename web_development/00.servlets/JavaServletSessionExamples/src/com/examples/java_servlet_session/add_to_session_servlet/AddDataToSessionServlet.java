package add_to_session_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet reads data(parameters name and surname) from an http request and
 * adds them to the Session.
 * 
 * Servlet implementation class AddDataToSessionServlet
 */
@WebServlet("/AddDataToSessionServlet")
public class AddDataToSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDataToSessionServlet() {
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
		 * Enable Session
		 */
		HttpSession session = request.getSession(true);
		/*
		 * Gets name from html
		 */
		String name = request.getParameter("nameField");
		/*
		 * Gets surname from html
		 */
		String surname = request.getParameter("surnameField");

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>AddDataToSessionServlet</title>");
			out.println("</head>");
			out.println("<body bgcolor='#99CCFF'>");

			/*
			 * Converts the name from ISO-8859-1 to ISO-8859-7 (Greek) in case
			 * the user typed his/her name in Greek
			 */
			name = new String(name.getBytes("ISO-8859-1"), "ISO-8859-7");
			/*
			 * Converts the surname from ISO-8859-1 to ISO-8859-7 (Greek)in case
			 * the user typed his/her surname in Greek
			 */
			surname = new String(surname.getBytes("ISO-8859-1"), "ISO-8859-7");

			out.println("<h1>AddDataToSessionServlet is running...</h1>");

			/*
			 * Checks if there is an empty field
			 */
			if (!(name.length() > 0) || !(surname.length() > 0)) {
				out.println("<h1>You have not enterd your information!!!</h1>");
				return;
			}
			/*
			 * Store name in a Session variable named sessionName
			 */
			session.setAttribute("sessionName", name);

			/*
			 * Store surname in a Session variable named sessionSurname
			 */
			session.setAttribute("sessionSurname", surname);

			out.println("<h2>You entered the following information:</h2>");
			out.println("<b>Name: </b>" + name + "<br>");
			out.println("<b>Surname: </b>" + surname + "<br>");
			out.println(
					"<br><a href='/JavaServletSessionExamples/ReadDataFromSessionServlet'>Read the values of variables in session from the ReadDataFromSessionServlet.java</a>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
