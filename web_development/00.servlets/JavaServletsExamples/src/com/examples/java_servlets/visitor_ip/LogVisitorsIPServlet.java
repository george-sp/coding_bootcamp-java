package visitor_ip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogVisitorsIPServlet
 */
@WebServlet("/LogVisitorsIPServlet")
public class LogVisitorsIPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// the String that holds all the IP addresses
	private String visitorsLogger = "";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogVisitorsIPServlet() {
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
		try {
			String visitorsIPAddress = request.getRemoteAddr();
			visitorsLogger += visitorsIPAddress + "<br>";
			out.println("<html>");
			out.println("<head>");
			out.println("  <title>LogVisitorsIPServlet</title>");
			out.println("    <meta http-equiv='Content-Type' content='text/html; charset=windows-1253'>");
			out.println("</head>");
			out.println("  <bodybgcolor='#FFFF99'>");
			out.println("  <h1>LogVisitorsIPServlet is running...</h1><br>");
			out.println("<b>The IPs below have been recorded:</b><br>");
			out.println("<hr>" + visitorsLogger + "<hr>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("  </body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
