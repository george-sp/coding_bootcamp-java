package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A simple Servlet that handles a GET request.
 *
 * @author George Spyridakis
 */
public class HelloServlet extends HttpServlet {

    /**
     * Handles GET requests.
     *
     * @param request the HTTP request.
     * @param response the HTTP resopnse.
     * @throws IOException in case an I/O occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type of the response
        response.setContentType("text/html");
        // Initialize a PrintWriter object to null
        PrintWriter out = null;
        try {
            // Get a PrintWriter object
            out = response.getWriter();
            out.println("<h1>" + "Hello Servlet!" + "</h1>");
        } finally {
            if (out != null) {
                // Close the stream and release the resources
                out.close();
            }
        }
    }
}