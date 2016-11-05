package servlet_access_through_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet retrieves a variable named 'login' from Session and checks if it
 * has the specific value 'login is correct'. By this way the servlet detects
 * user's direct access.
 * 
 * Servlet implementation class ServletB
 */
@WebServlet("/ServletB")
public class ServletB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Define the variable session here in order to be visible from both doGet
	 * and checkSessionVariable methods.
	 */
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletB() {
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
		 * Enable Session
		 */
		session = request.getSession(true);

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>AddDataToSessionServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>ServletB is running...</h1>");

			if (!checkSessionVariable()) {
				out.println("<br><b><font size='4' color='##FF0000'>Malicious Intervention!<br>");
				out.println("<br>Login was not accomplished via ServletA!!!</font><b>");
				return;
			}

			out.println("<br><font size='4' color='#009933'><b>Login via ServletA was successfully!</b></font>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * Checks variable 'login' in Session. Note: If variable 'login' does not
	 * exist in Session then a NullPointerException will be thrown.
	 * 
	 * @return boolean, true if in Session there is a variable named 'login'
	 *         with value 'login is correct', false otherwise.
	 */
	private boolean checkSessionVariable() {
		try {
			String loginStatus = session.getAttribute("login").toString();
			if (loginStatus.equals("login is correct"))
				return true;
			else
				return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

}
