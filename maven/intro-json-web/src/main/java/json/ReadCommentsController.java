package json;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * Servlet implementation class ReadCommentsController
 */
public class ReadCommentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// A variable for the JSON file name
	private String JSONFileName;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCommentsController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.JSONFileName = config.getInitParameter("file-name");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath()).append("\nJSON file to open: ")
					.append(this.JSONFileName).append("\n").append(new JSONParser().parseComments(JSONFileName));
		} catch (JSONException e) {
			response.getWriter().append("JSONException:\n").append(ExceptionUtils.getStackTrace(e));
		} catch (IOException e) {
			response.getWriter().append("IOException:\n").append(ExceptionUtils.getStackTrace(e));
		} catch (Exception e) {
			response.getWriter().append("Exception:\n").append(ExceptionUtils.getStackTrace(e));
		}
	}

}
