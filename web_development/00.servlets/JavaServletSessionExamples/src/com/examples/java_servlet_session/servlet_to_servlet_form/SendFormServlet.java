package servlet_to_servlet_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Servlet sends data to the ReadFormServlet via an html form.
 * 
 * Servlet implementation class SendFormServlet
 */
@WebServlet("/SendFormServlet")
public class SendFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendFormServlet() {
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
			out.println("  <head>");
			out.println("    <title>Servlet to Servlet</title>");
			out.println("    <meta http-equiv='Content-Type' content='text/html; charset=windows-1253'>");
			out.println("  </head>");
			out.println("  <body bgcolor='#CCFFFF'>");
			out.println("    <h1>Form for username</h1>");
			out.println("    <br>");
			out.println("    <br>");
			out.println("    <form name='form1' method='post' action='ReadFormServlet'>");
			out.println("      <table width='20%' border='0'>");
			out.println("      <tr>");
			out.println("        <td width='13%'>");
			out.println("        <strong><font size='4' face='Times New Roman, Times, serif'>Name:</font></strong>");
			out.println("        </td>");
			out.println("        <td width='87%'>");
			out.println("        <input name='nameField' type='text' id='name'>");
			out.println("        </td>");
			out.println("      </tr>");
			out.println("      <tr>");
			out.println("        <td>");
			out.println("        <strong><font size='4' face='Times New Roman, Times, serif'>Surname:</font></strong>");
			out.println("        </td>");
			out.println("        <td>");
			out.println("        <input name='surnameField' type='text' id='surname'>");
			out.println("        </td>");
			out.println("      </tr>");
			out.println("      <tr>");
			out.println("        <td>");
			out.println("        <div align='right'>");
			out.println("          <input name='clear' type='reset' id='clear' value='Clear'>");
			out.println("        </div>");
			out.println("        </td>");
			out.println("        <td>");
			out.println("        <div align='left'>");
			out.println("          <input type='submit' name='Submit2' value='Next'>");
			out.println("        </div>");
			out.println("        </td>");
			out.println("      </tr>");
			out.println("      </table>");
			out.println("      </form>");
			out.println("  </body>");
			out.println("</html> ");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("</body>");
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
