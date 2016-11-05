package add_obj_to_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet retrieves and prints the Object Customer from the Session.
 * 
 * Servlet implementation class ReadCustomerFromSessionServlet
 */
@WebServlet("/ReadCustomerFromSessionServlet")
public class ReadCustomerFromSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCustomerFromSessionServlet() {
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
		 * Enable Session.
		 */
		HttpSession session = request.getSession(true);

		/*
		 * Retrieve Object Customer from Session.
		 */
		Customer customer = (Customer) session.getAttribute("Customer");

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>ReadCustomerFromSessionServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>ReadCustomerFromSessionServlet is running...</h1>");
			out.println("<h2>The Customer object that is stored in Session has the fields:</h2><hr>");
			out.println("<b>Name: </b>" + customer.getName() + "<br>");
			out.println("<b>Surname: </b>" + customer.getSurname() + "<br>");
			out.println("<b>username: </b>" + customer.getUsername() + "<br>");
			out.println("<b>password: </b>" + customer.getPassword() + "<br>");
			out.println("<b>Interests: </b>" + customer.getPreferences() + "<br>");
			out.println("<b>Gender: </b>" + customer.getGender() + "<br>");
			out.println("<b>Age: </b>" + customer.getAge() + "<br>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
