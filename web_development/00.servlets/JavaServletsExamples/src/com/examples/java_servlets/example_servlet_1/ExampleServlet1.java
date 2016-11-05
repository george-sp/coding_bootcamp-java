package example_servlet_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExampleServlet1
 */
@WebServlet("/ExampleServlet1")
public class ExampleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=windows-1253");
	    PrintWriter out = new PrintWriter(response.getWriter(), true);

	    try {
	      out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
	      out.println("<html>");
	      out.println("  <head>");
	      out.println("    <title>1ο παράδειγμα Java Servlet</title>");
	      out.println("    <meta http-equiv='Content-Type' content='text/html; charset=windows-1253'>");
	      out.println("  </head>");
	      out.println("  <body bgcolor='#FFFF99'>");
	      out.println("    <br>");
	      out.println("    <br>");
	      out.println("    <div align='center'>");
	      out.println("        <font size='5' face='Georgia, Times New Roman, Times, serif'>");
	      out.println("          <strong>Γιώργος Σπυριδάκης</strong>");
	      out.println("        </font>");
	      out.println("      </div>");
	      out.println("    </body>");
	      out.println(" </html>");

	    } catch (Exception ex) {
	      out.println("Exception: " + ex.getMessage());
	      out.println("</body>");
	      out.println("</html>");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
