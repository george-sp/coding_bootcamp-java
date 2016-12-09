package com.advanced_oop.exercises.exercise5;

import java.io.File;

public class MetricCalculatorString extends MetricCalculator {

	public MetricCalculatorString(File javaFile) {
		super(javaFile);
	}

	@Override
	public int calculateNoL(String javaCode) {
		int lineCounter = 0;
		String[] allLines = javaCode.split("\r\n|\r|\n");
		for (String line : allLines) {
			if (!isEmpty(line)) {
				lineCounter++;
			}
		}
		return lineCounter;
	}

	@Override
	public int calculateNoC(String javaCode) {
		int classCounter = 0;
		String[] allLines = javaCode.split("\r\n|\r|\n");
		for (String line : allLines) {
			if (!(line = line.trim()).equals("")) {
				if (line.startsWith("public ") | line.startsWith("private ") | line.startsWith("protected "))
					line = line.replaceFirst("(public|private|protected) ", "");
				if (line.startsWith("static ") | line.startsWith("final ") | line.startsWith("abstract "))
					line = line.replaceFirst("(static|final|abstract) ", "");
				if (line.startsWith("static ") | line.startsWith("final ") | line.startsWith("abstract "))
					line = line.replaceFirst("(static|final|abstract) ", "");
				if (line.startsWith("class ")) {
					line = line.replaceFirst("class ", "");
					if (line.endsWith("{") & line.split(" ").length == 2)
						if (Character.isAlphabetic(line.split(" ")[0].toCharArray()[0]))
							classCounter++;
				}
			}
		}
		return classCounter;
	}

	@Override
	public int calculateNoM(String javaCode) {
		int methodCounter = 0;
		String[] allLines = javaCode.split("\r\n|\r|\n");
		for (String line : allLines) {
			if (!(line = line.trim()).equals("")) {
				if (line.startsWith("public ") | line.startsWith("private ") | line.startsWith("protected "))
					line = line.replaceFirst("(public|private|protected) ", "");
				if (line.startsWith("static ") | line.startsWith("final ") | line.startsWith("abstract "))
					line = line.replaceFirst("(static|final|abstract) ", "");
				if (line.startsWith("static ") | line.startsWith("final ") | line.startsWith("abstract "))
					line = line.replaceFirst("(static|final|abstract) ", "");
				if (line.startsWith("strictfp ") | line.startsWith("synchronized ") | line.startsWith("transient ")
						| line.startsWith("volatile ") | line.startsWith("native "))
					line = line.replaceFirst("(strictfp|synchronized|transient|volatile|native) ", "");
				String[] simpleMethod = line.split(" ");
				if (line.endsWith(") {")) {
					String returnType = simpleMethod[0];
					String methodName = simpleMethod[1];
					if (Character.isAlphabetic(returnType.toCharArray()[0])
							& Character.isAlphabetic(methodName.toCharArray()[0]) & methodName.contains("("))
						methodCounter++;
				}
			}
		}
		return methodCounter;
	}

	private boolean isEmpty(String line) {
		return (line.trim()).equals("");
	}
}
