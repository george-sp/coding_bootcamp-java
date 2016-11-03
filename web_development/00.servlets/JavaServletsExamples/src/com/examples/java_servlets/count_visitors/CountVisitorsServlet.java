package count_visitors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountVisitorsServlet
 */
@WebServlet("/CountVisitorsServlet")
public class CountVisitorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// the integer that counts the visitors
	private int visitorsCounter = 0;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CountVisitorsServlet() {
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
			out.println("<html>");
			out.println("<head>");
			out.println("  <title>CountVisitorsServlet</title>");
			out.println("    <meta http-equiv='Content-Type' content='text/html; charset=windows-1253'>");
			out.println("</head>");
			out.println("  <bodybgcolor='#FFFF99'>");
			out.println("  <h1>CountVisitorsServlet is running...</h1><br>");
			out.println("Αυτή την σελίδα την έχουν δει <b>" + ++visitorsCounter + "</b> επισκέπτες!<br>");
			out.println("  </body>");
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
