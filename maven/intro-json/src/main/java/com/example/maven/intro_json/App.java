package com.example.maven.intro_json;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!\nFetching data from: https://jsonplaceholder.typicode.com/todos\n");
		try {
			System.out.println(DataFetcher.fromURL(new URL("https://jsonplaceholder.typicode.com/posts")));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
