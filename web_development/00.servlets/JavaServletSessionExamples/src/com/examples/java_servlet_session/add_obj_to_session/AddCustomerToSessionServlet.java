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
 * This servlet reads data(parameters) from an http request and adds them to the
 * Customer Object. Finally, store the Object Customer to Session.
 * 
 * Servlet implementation class AddCustomerToSessionServlet
 */
@WebServlet("/AddCustomerToSessionServlet")
public class AddCustomerToSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomerToSessionServlet() {
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
		 * gets parameters from the request.
		 */
		String name = request.getParameter("nameField");
		String surname = request.getParameter("surnameField");
		String username = request.getParameter("usernameField");
		String password = request.getParameter("passwordField");
		String preferences = request.getParameter("preferencesField");
		String gender = request.getParameter("genderField");
		String age = request.getParameter("ageField");

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
			out.println("<title>AddCustomerToSessionServlet</title>");
			out.println("</head>");
			out.println("<body bgcolor='#99CCFF'>");
			out.println("<h1>AddCustomerToSessionServlet is running...</h1>");

			/*
			 * checks if all the parameters have value.
			 */
			if (!(name.length() > 0) || !(surname.length() > 0) || !(username.length() > 0) || !(password.length() > 0)
					|| preferences.equals("0") || gender == null || age == null) {
				out.println("<h1>You have not filled in all the required fields!!!</h1>");
				return;
			}

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
			age = new String(age.getBytes("ISO-8859-1"), "ISO-8859-7");

			/*
			 * Initialize Customer Object and put the data.
			 */
			Customer customer = new Customer();
			customer.setName(name);
			customer.setSurname(surname);
			customer.setUsername(username);
			customer.setPassword(password);
			customer.setPreferences(preferences);
			customer.setGender(gender);
			customer.setAge(age);

			/*
			 * Store Object customer to Session in a variable named 'Customer'
			 */
			session.setAttribute("Customer", customer);

			out.println("<h2>Customer object was stored in Session!</h2>");
			out.println(
					"<br><a href='ReadCustomerFromSessionServlet'>Read Customer object from ReadObjectFromSessionServlet</a>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
