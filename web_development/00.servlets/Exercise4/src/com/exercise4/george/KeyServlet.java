package com.exercise4.george;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KeyServlet
 */
@WebServlet("/key")
public class KeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<html>");
        response.getWriter().append("<body>");
        response.getWriter().append("<form action=\"/Exercise4/key\" method=\"POST\">");
        response.getWriter().append("<input name=\"username\">");
        response.getWriter().append("<input type=\"password\" name=\"password\">");
        response.getWriter().append("<input type=\"submit\" value=\"Servlet post\">");
        response.getWriter().append("</form>");
        response.getWriter().append("</body>");
        response.getWriter().append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> keys = request.getParameterNames();
		String key = keys.nextElement();
		while (key != null) {
			response.getWriter().append(key);
			response.getWriter().append(": ");
			response.getWriter().append(request.getParameter(key));
			response.getWriter().append("\n");
			key = keys.nextElement();
		}
	}

}
