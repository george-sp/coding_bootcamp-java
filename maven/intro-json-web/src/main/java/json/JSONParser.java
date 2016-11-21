package json;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	// An object responsible for loading classes
	private ClassLoader classLoader;

	public JSONParser() {
		// Get the ClassLoader for the class
		this.classLoader = getClass().getClassLoader();
	}

	/**
	 * @param fileName
	 *            the name of the file in resources directory
	 * @return the content of the given file in String format
	 * @throws IOException
	 */
	public String readFile(String fileName) throws IOException {
		// Find a resource with the given name
		File file = new File(classLoader.getResource(fileName).getFile());

		// Build a String from the json file
		StringBuilder stringBuilder = new StringBuilder("");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			throw new IOException();
		}

		return stringBuilder.toString();
	}

	public String parseComments(String json) throws JSONException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		// Parse the JSON
		JSONArray commentsJSONArray;
		commentsJSONArray = new JSONArray(readFile(json));
		for (int i = 0, size = commentsJSONArray.length(); i < size; i++) {
			JSONObject commentJSONObject = commentsJSONArray.getJSONObject(i);
			stringBuilder.append("\n").append(i++).append(") ").append(commentJSONObject.getString("name"))
					.append(" by ").append(commentJSONObject.getString("email")).append("\n")
					.append(commentJSONObject.getString("body")).append("\n");
		}
		return stringBuilder.toString();
	}
}
