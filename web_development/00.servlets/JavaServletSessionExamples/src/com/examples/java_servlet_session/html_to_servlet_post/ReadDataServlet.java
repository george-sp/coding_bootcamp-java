package html_to_servlet_post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Servlet reads and prints data (parameters name and surname) from an http
 * request.
 * 
 * Servlet implementation class ReadDataServlet
 */
@WebServlet("/ReadDataServlet")
public class ReadDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = new PrintWriter(response.getWriter(), true);

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
			out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=utf-8'>");
			out.println("<title>Html-Servlet-Post</title>");
			out.println("</head>");
			out.println("<body bgcolor='#99CCFF'>");

			/*
			 * Converts the name from ISO-8859-1 to ISO-8859-7 (Greek) in case
			 * the user typed his/her name in Greek
			 */
			name = new String(name.getBytes("ISO-8859-1"), "ISO-8859-7");
			/*
			 * Converts the surname from ISO-8859-1 to ISO-8859-7 (Greek)in case
			 * the user typed his/her name in Greek
			 */
			surname = new String(surname.getBytes("ISO-8859-1"), "ISO-8859-7");

			/*
			 * Checks if there is an empty field
			 */
			if (!(name.length() > 0) || !(surname.length() > 0)) {
				out.println("<h1>Not all required information!!!</h1>");
				return;
			}

			out.println("<h1>You gave the information below:</h1>");
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
