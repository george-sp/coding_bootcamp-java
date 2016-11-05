package html_to_sevlet_error_handling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet receives an http POST request and checks if all the
 * parameters(required fields) have values. If all the parameters have values it
 * forwards the requests to the DataPrinterServlet, otherwise it forwards the
 * request to the ErrorHandlerServlet to print the errors.
 * 
 * Servlet implementation class DataRecieverServlet
 */
@WebServlet("/DataReceiverServlet")
public class DataReceiverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataReceiverServlet() {
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
		String age = request.getParameter("ageField");

		try {
			/*
			 * checks if all the parameters have value.
			 */
			if (!(name.length() > 0) || !(surname.length() > 0) || !(username.length() > 0) || !(password.length() > 0)
					|| preferences.equals("0") || gender == null || age == null) {
				/*
				 * forwards the request to the ErrorHandlerServlet
				 * 
				 * Note: The ErrorHandlerServlet must have the same method
				 * (POST) with the DataReceiverServlet.
				 */
				RequestDispatcher errorDispatcher = getServletContext()
						.getRequestDispatcher("/ErrorHandlerServlet");
				errorDispatcher.forward(request, response);
			} else {
				/*
				 * forwards the request to the DataPrinterServlet
				 * 
				 * Note: The DataPrinterServlet must have the same method (POST)
				 * with the DataReceiverServlet.
				 */
				RequestDispatcher printerDispatcher = getServletContext().getRequestDispatcher("/DataPrinterServlet");
				printerDispatcher.forward(request, response);
			}
		} catch (Exception ex) {
			out.println("<html>");
			out.println("<body>");
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
			out.println("</html>");
		}
	}

}