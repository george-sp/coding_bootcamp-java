package com.advanced_oop.exercises.exercise5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class FileHandler {

	/**
	 * Read the text context of the specified file.
	 * 
	 * @param file
	 *            The file to read from
	 * @return The text read from the file
	 */
	public static String readFile(File file) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * Write the some text in the specified file.
	 * 
	 * @param file
	 *            The file to write to
	 * @param text
	 *            The text to be written in file
	 */
	public static void writeFile(File file, String text) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			bufferedWriter.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
