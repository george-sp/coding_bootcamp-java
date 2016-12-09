package com.advanced_oop.exercises.exercise5;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetricCalculatorRegEx extends MetricCalculator {

	public MetricCalculatorRegEx(File javaFile) {
		super(javaFile);
	}

	@Override
	public int calculateNoL(String javaCode) {
		int lineCounter = 0;
		Matcher m = Pattern.compile("(?m)^.*\\S+.*$").matcher(javaCode);
		while (m.find()) {
			lineCounter++;
		}
		return lineCounter;
	}

	@Override
	public int calculateNoC(String javaCode) {
		int classCounter = 0;
		Matcher m = Pattern
				.compile(
						"(?m)^.*(((public|private|protected)|(static|final))\\s{1}|(|static|final)\\s{1})class\\s+.+\\s{1}\\{$")
				.matcher(javaCode);
		while (m.find()) {
			classCounter++;
		}
		return classCounter;
	}

	@Override
	public int calculateNoM(String javaCode) {
		int methodCounter = 0;
		Matcher m = Pattern
				.compile(
						"(?m)^\\s*(((public|private|protected)\\s{1})?)(((|static|final)\\s{1})?)(((|static|final)\\s{1})?)((\\w+|void)\\s{1})\\w+\\(.*\\)\\s+\\{$")
				.matcher(javaCode);
		while (m.find()) {
			methodCounter++;
		}
		return methodCounter;
	}
}
