package com.example.maven.intro_json;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String url = "https://jsonplaceholder.typicode.com/posts";
		String jsonResponse = "";
		
		System.out.println("Hello World!\nFetching data from: " + url + "\n");
		
		// Fetch data from jsonplaceholder.typicode.com
		try {
			jsonResponse = DataFetcher.fromURL(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		// Print the parsed JSON response of posts
		System.out.println(DataFetcher.parsePosts(jsonResponse));
	}
}
