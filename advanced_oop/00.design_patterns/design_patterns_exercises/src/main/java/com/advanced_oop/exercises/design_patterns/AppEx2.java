package com.advanced_oop.exercises.design_patterns;

import com.advanced_oop.exercises.exercise2.FileUtils;

public class AppEx2 {
	public static void main(String[] args) {
		String filePath = "Test.java";
		String text = "public class Test {" + "\n\tpublic static void main(String[] args) {"
				+ "\n\t\tSystem.out.println(\"Hello Test\");" + "\n\t}" + "\n}";

		// Write some text to the file Test.java
		FileUtils.writeFile(filePath, text);
		// Read the text from the file Test.java
		System.out.println(FileUtils.readFile(filePath));
	}
}
