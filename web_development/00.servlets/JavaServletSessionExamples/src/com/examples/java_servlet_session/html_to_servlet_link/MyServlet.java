package html_to_servlet_link;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-7");
	    PrintWriter out = new PrintWriter(response.getWriter(), true);

	    String name = request.getParameter("nameField");
	    String surname = request.getParameter("surnameField");

	    try {
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<Meta Http-Equiv='Content-Type' Content='text/html; Charset=windows-1253'>");
	      out.println("<title>Sending Data</title>");
	      out.println("</head>");
	      out.println("<body>");

	      if ((name == null) || (surname == null) || !(name.length() > 0)
	          || !(surname.length() > 0)) {
	        out.println("<h1>Not all information given!!!</h1>");
	        return;
	      }

	      name = new String(name.getBytes("ISO-8859-1"), "ISO-8859-7");
	      surname = new String(surname.getBytes("ISO-8859-1"), "ISO-8859-7");

	      out.println("<h1>You entered the following information:</h1>");
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
