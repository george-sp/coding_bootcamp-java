package course_registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseRegistrationServlet
 */
@WebServlet("/CourseRegistrationServlet")
public class CourseRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseRegistrationServlet() {
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
			out.println(
					"<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
			out.println("<html>");
			out.println("  <head>");
			out.println("    <title>Course registration page</title>");
			out.println("    <meta http-equiv='content-type' content='text/html; charset=iso-8859-7'>");
			out.println("    <link rel='stylesheet' href='css/design.css' type='text/css'>");
			out.println("  </head>");
			out.println("  <body>");
			out.println("    <div id='wrapper'>");
			out.println("      <div id='page'>");
			out.println("        <h1>Course registration form</h1>");
			out.println("        <form action='RegisterCustomer' method='post' name='registrationform'>");
			out.println("        <fieldset>");
			out.println("          <legend>Contact information</legend>");
			out.println("          <table>");
			out.println("          <tr>");
			out.println("            <th>Name:</th>");
			out.println(
					"            <td><input name='name' type='text' size='30' > <span class='asterisc'>*</span></td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Surname:</th>");
			out.println(
					"            <td><input name='surname' type='text' size='30' > <span class='asterisc'>*</span></td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Email:</th>");
			out.println(
					"            <td><input name='mail' type='text' size='30' > <span class='asterisc'>*</span></td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Address:</th>");
			out.println(
					"            <td><input name='address' type='text' size='30' > <span class='asterisc'>*</span></td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Phone:</th>");
			out.println(
					"            <td><input name='phone' type='text' size='30' > <span class='asterisc'>*</span></td>");
			out.println("          </tr>");
			out.println("          </table>");
			out.println("        </fieldset>");
			out.println("        <fieldset>");
			out.println("          <legend>Personal information</legend>");
			out.println("          <table>");
			out.println("          <tr>");
			out.println("            <th>Gender:</th>");
			out.println(
					"            <td><input type='radio' value='Male' name='gender'> male <input type='radio' value='Female' name='gender'> female <span class='asterisc'>*</span></td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Date of birth:</th>");
			out.println("            <td>");
			out.println(
					"            <input type='text' maxlength='2' size='2' name='dd' id='dd'> <span class='small'>(DD)</span> /");
			out.println(
					"            <input type='text' maxlength='2' size='2' name='mm' id='mm'> <span class='small'>(MM)</span> /");
			out.println(
					"            <input type='text' maxlength='4' size='4' name='yyyy' id='yyyy'> <span class='small'>(YYYY)</span>");
			out.println("            <span class='asterisc'>*</span>");
			out.println("            </td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Native language:</th>");
			out.println("            <td>");
			out.println("            <input name='language' type='text' size='30' > <span class='asterisc'>*</span>");
			out.println("            </td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Level of Greek:</th>");
			out.println("            <td>");
			out.println("            <select name='gr_level' >");
			out.println("              <option value='0'> </option>");
			out.println("              <option value='none'>none</option>");
			out.println("              <option value='weak'>weak</option>");
			out.println("              <option value='intermediate'>intermediate</option>");
			out.println("              <option value='good'>good</option>");
			out.println("              <option value='very good'>very good</option>");
			out.println("            </select>");
			out.println("            <span class='asterisc'>*</span>");
			out.println("            </td>");
			out.println("          </tr>");
			out.println("          <tr>");
			out.println("            <th>Occupation:</th>");
			out.println("            <td>");
			out.println(
					"            <input name='occupation' type='text' size='30' id='occupation' > <span class='asterisc'>*</span>");
			out.println("            </td>");
			out.println("          </tr>");
			out.println("          </table>");
			out.println("        </fieldset>");
			out.println("        <fieldset>");
			out.println("          <legend>Course enrollment</legend>");
			out.println("          <p>");
			out.println(
					"          <span class='question'>Please select which course you are applying for:</span> <span class='asterisc'>*</span>");
			out.println("          <br>");
			out.println("          <input type='checkbox' value='Art and Design' name='course1'> Art and Design");
			out.println("          <br>");
			out.println("          <input type='checkbox' value='Business' name='course2'> Business");
			out.println("          <br>");
			out.println("          <input type='checkbox' value='Engineering' name='course3'> Engineering");
			out.println("          <br>");
			out.println("          <input type='checkbox' value='Computing' name='course4'> Computing");
			out.println("          <br>");
			out.println(
					"          <input type='checkbox' value='Travel and Tourism' name='course5'> Travel and Tourism");
			out.println("          </p>");
			out.println("          <p>");
			out.println(
					"          <span class='question'>Please let us know any comments or questions that you might have.</span>");
			out.println("            <br>");
			out.println("            <textarea name='commentsfield' cols='55' rows='3'></textarea>");
			out.println("          </p>");
			out.println("        </fieldset>        ");
			out.println("              ");
			out.println("        <p class='buttons'>");
			out.println("          <input type='submit' value='Submit' name='submit'>");
			out.println(
					"          <input type='reset' value='Reset' name='reset'> Required fields <span class='asterisc'>*</span>          ");
			out.println("        </p>");
			out.println("        ");
			out.println("        </form>");
			out.println("        ");
			out.println("        <div id='w3cvalidator'>");
			out.println("        <a href='http://validator.w3.org/check?uri=referer'><img");
			out.println(
					"          src='http://www.w3.org/Icons/valid-html401' alt='Valid HTML 4.01 Transitional' height='31' width='88'></a>");
			out.println("        </div> <!-- end of w3cvalidator link and icon-->");
			out.println("        ");
			out.println("      </div> <!-- end of page -->");
			out.println("    </div>  <!-- end of wrapper -->");
			out.println("  </body>");
			out.println("</html>");

		} catch (Exception e) {
			out.println("Exception: " + e.getMessage());
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
