package com.example.maven.intro_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataFetcher {

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
			// Get the stack trace of the exception as a String
			StringWriter stringWriter = new StringWriter();
			try (PrintWriter printWriter = new PrintWriter(stringWriter)) {
				e.printStackTrace(printWriter);
			}
			stringBuilder.append("Exception stack trace converted to String:\n").append(stringWriter.toString());
		}
		return stringBuilder.toString();
	}
}
