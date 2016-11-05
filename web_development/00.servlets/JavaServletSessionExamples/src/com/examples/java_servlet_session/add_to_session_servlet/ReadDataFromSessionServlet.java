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
 * This servlet reads and prints the values of the Session's variables
 * sessionName and sessionSurname.
 * 
 * Servlet implementation class ReadDataFromServletSession
 */
@WebServlet("/ReadDataFromSessionServlet")
public class ReadDataFromSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadDataFromSessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-7");
		PrintWriter out = new PrintWriter(response.getWriter(), true);
		/*
		 * Enables Session
		 */
		HttpSession session = request.getSession(true);

		/*
		 * Gets name value from the Session variable named sessionName
		 */
		String name = session.getAttribute("sessionName").toString();

		/*
		 * Gets surname value from the Session variable named sessionSurname
		 */
		String surname = session.getAttribute("sessionSurname").toString();

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>AddDataToSessionServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>ReadDataFromSessionServlet is running...</h1>");
			out.println("<h2>You entered this values in the Session:</h2><hr>");
			out.println("<b>Name: </b>" + name + "<br>");
			out.println("<b>Surname: </b>" + surname + "<br>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}
}
