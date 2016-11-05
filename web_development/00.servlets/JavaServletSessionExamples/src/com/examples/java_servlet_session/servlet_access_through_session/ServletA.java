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
 * This servlet when receives an http request stores a variable named 'login' in
 * Session with value 'login is correct' and provides a link to the ServletB.
 * 
 * Servlet implementation class ServletA
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletA() {
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
		HttpSession session = request.getSession(true);

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>AddDataToSessionServlet</title>");
			out.println("</head>");
			out.println("<body bgcolor='#CCFF99'>");
			out.println("<h1>ServletA is running...</h1>");

			/*
			 * Store a variable named 'login' in a Session with value 'login is
			 * correct'
			 */
			session.setAttribute("login", "login is correct");

			out.println("<div align ='center'><h2>The login was successfully</h2><br>");
			out.println("<h2>You can safely go to ServletB</h2>");
			out.println("<br><a href='ServletB'>Go to ServletB</a>");
			out.println("</html>");
			out.println("</div></body>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
