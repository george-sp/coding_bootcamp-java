package com.advanced_oop.exercises.exercises2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class FileUtils {

	/**
	 * Read the text context of the file from the specified path.
	 * 
	 * @param filePath
	 * @return the text of the file
	 */
	public static String readFile(String filePath) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + "\n");
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
	 * @param filePath
	 * @param text
	 */
	public static void writeFile(String filePath, String text) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath)))) {
			bufferedWriter.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
