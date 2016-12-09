package com.advanced_oop.exercises.exercise3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetricsUtils {

	/**
	 * Compute the lines of code in the given snippet of java code
	 * 
	 * @param codeSnippet
	 * @return the LOC (lines of code)
	 */
	public static int countLOC(String codeSnippet) {
		int lineCounter = 0;
		Matcher m = Pattern.compile("(?m)^.*\\S+.*$").matcher(codeSnippet);
		while (m.find()) {
			lineCounter++;
			System.out.println("line " + lineCounter + ": " + m.group());
		}
		return lineCounter;
	}

	/**
	 * Compute the number of classes in the given snippet of java code
	 * 
	 * @param codeSnippet
	 * @return the number of Classes
	 */
	public static int countClasses(String codeSnippet) {
		int classCounter = 0;
		Matcher m = Pattern
				.compile(
						"(?m)^.*(((public|private|protected)|(static|final))\\s{1}|(|static|final)\\s{1})class\\s+.+\\s{1}\\{$")
				.matcher(codeSnippet);
		while (m.find()) {
			classCounter++;
			System.out.println("line " + classCounter + ": " + m.group());
		}
		return classCounter;
	}

	/**
	 * Compute the number of methods in the given snippet of java code
	 * 
	 * @param codeSnippet
	 * @return the number of Classes
	 */
	public static int countMethods(String codeSnippet) {
		int methodCounter = 0;
		Matcher m = Pattern
				.compile(
						"(?m)^\\s*(((public|private|protected)\\s{1})?)(((|static|final)\\s{1})?)(((|static|final)\\s{1})?)((\\w+|void)\\s{1})\\w+\\(.*\\)\\s+\\{$")
				.matcher(codeSnippet);
		while (m.find()) {
			methodCounter++;
			System.out.println("line " + methodCounter + ": " + m.group());
		}
		return methodCounter;
	}
}
