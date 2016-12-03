
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadImageController
 */
@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16177215)
public class UploadImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Parameter names
	private static final String PROFILE_IMAGE = "image";
	private static final String NAME = "name";
	// The upload location
	private static final String UPLOAD_LOCATION = "uploaded_images";
	// Dispatcher for the index page
	RequestDispatcher indexDispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImageController() {
		super();
	}

	@Override
	public void init() {
		indexDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served: ").append("name: ").append(request.getParameter("name\n"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter(NAME);
		// Obtain the upload file part in this multipart request
		Part imagePart = request.getPart(PROFILE_IMAGE);
		// Get the content type
		String contentType = imagePart.getContentType();

		String message = null;
		String status = null;

		if (imagePart.getSize() != 0) {
			// Check if the selected file is not an image
			if (!contentType.split("/")[0].equals("image")) {
				status = "error";
				message = "Error in uploading an image file!";
				request.setAttribute("status", status);
				request.setAttribute("message", message);
				indexDispatcher.forward(request, response);
				return;
			}

			// Get the absolute path of the web application
			String appPath = request.getServletContext().getRealPath("");
			// Construct path of the directory to save uploaded files
			String savePath = appPath + File.separator + UPLOAD_LOCATION;
			// Define the path to the final storage location
			File uploadFile = new File(savePath);
			if (!uploadFile.exists()) {
				uploadFile.mkdir();
			}
			contentType = "." + imagePart.getContentType().split("/")[1];
			String uploadFileName = name + contentType;
			File file = new File(uploadFile, uploadFileName);

			try (InputStream input = imagePart.getInputStream()) {
				Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
				status = "success";
				message = "<b>Image Uploaded Successfully!</b>" + "<br>name: " + name + "<br>contentType: "
						+ contentType + "<br>image size: " + imagePart.getSize() + "<br>appPath: " + appPath
						+ "<br>savePath: " + savePath + "<br>uploadFileName: " + uploadFileName + "<br><b>"
						+ UPLOAD_LOCATION + "/" + uploadFileName + "</b>";
				request.setAttribute("status", status);
				request.setAttribute("message", message);
				request.setAttribute("uploaded", uploadFileName);
				indexDispatcher.forward(request, response);
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
