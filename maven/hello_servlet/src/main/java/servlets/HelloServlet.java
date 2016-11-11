package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.File;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import java.util.Properties;
import java.util.Scanner;
import org.json.*;

/**
* A simple Servlet that handles a GET request.
*
* @author George Spyridakis
*/
public class HelloServlet extends HttpServlet {

    // author's name
    private String name;
    // A persistent set of properties
    private Properties properties;
    private String propertiesStr;
    // An object responsible for loading classes
    private ClassLoader classLoader;

    /**
    * Runs when HelloServlet is created.
    * Stores the parameter value from the servlet configuration object to private field name.
    */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.name = config.getInitParameter("param-name");
        // Create an empty properties list with no default values
        this.properties = new Properties();
        // Get the ClassLoader for the class
        this.classLoader = getClass().getClassLoader();
    }

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

        // Find a resource with the given name
        File file = new File(classLoader.getResource("users.json").getFile());

        // Build a String from the json file
        StringBuilder stringBuilder = new StringBuilder("");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Parse the json Array and get all names
        JSONArray jsonArray;
        try {
            jsonArray =  new JSONArray(stringBuilder.toString());
            for (int i = 0, size = jsonArray.length(); i < size; i ++) {
                this.name += ", " + jsonArray.getJSONObject(i).getString("first_name");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Get the value of the request parameter name
        String nameParam = request.getParameter("name");
        this.name = nameParam != null ? nameParam : this.name;

        // Read a property list from the input byte stream
        try (InputStream is = classLoader.getResourceAsStream("config.properties")) {
            this.properties.load(is);
            this.propertiesStr = "username: " + properties.getProperty("username") + ", password: " + properties.getProperty("password");
        }

        /*
         * Use an instance of PrintWriter to print to a text-output stream.
         *
         * NOTE: Use the try-with-resources Statement
         * because PrintWriter implements AutoCloseable interface.
         */
        try (PrintWriter out = response.getWriter()){
            out.println("<h1>" + this.propertiesStr + "</h1><br><h2>" + "Hello " + this.name + " !" + "</h2>");
        }
    }
}