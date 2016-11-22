package com.example.maven.intro_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataFetcher {

	/**
	 * Reads the response of a GET request to the given URL and converts it to a
	 * String.
	 * 
	 * @param url
	 *            the URL to send the HTTP GET request
	 * @return the response of the request
	 */
	public static String fromURL(URL url) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String tempStr;
			while (null != (tempStr = bufferedReader.readLine())) {
				stringBuilder.append(tempStr);
			}
		} catch (IOException e) {
			stringBuilder.append("Exception stack trace (fromURL) converted to String:\n")
					.append(convertStackTraceToString(e));
		}
		return stringBuilder.toString();
	}

	/**
	 * Formats a String containing the posts from the given JSON input
	 * 
	 * @param json a String in JSON format to be parsed
	 * @return a String containing the posts
	 */
	public static String parsePosts(String json) {
		StringBuilder stringBuilder = new StringBuilder();
		// Parse the JSON
		JSONArray postsJSONArray;
		try {
			postsJSONArray = new JSONArray(json);
			System.out.println(postsJSONArray.length());
			for (int i = 0, size = postsJSONArray.length(); i < size; i++) {
				System.out.println(i);
				JSONObject postJSONObject = postsJSONArray.getJSONObject(i);
				stringBuilder.append("\n").append(i+1).append(") \"").append(postJSONObject.getString("title"))
						.append("\" by ").append("user id: ").append(postJSONObject.getInt("userId")).append("\n")
						.append(postJSONObject.getString("body")).append("\n");
			}
		} catch (JSONException e) {
			stringBuilder.append("JSONException stack trace (parsePosts()) converted to String:\n")
					.append(convertStackTraceToString(e));
		}
		return stringBuilder.toString();
	}

	/**
	 * Converts the stack trace of the given Exception to a String
	 * 
	 * @param e the caught Exception
	 * @return a String representing the stack trace of the Exception
	 */
	private static String convertStackTraceToString(Exception e) {
		// Get the stack trace of the exception as a String
		StringWriter stringWriter = new StringWriter();
		try (PrintWriter printWriter = new PrintWriter(stringWriter)) {
			e.printStackTrace(printWriter);
		}
		return stringWriter.toString();
	}
}
