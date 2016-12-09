package com.advanced_oop.exercises.exercise5;

import java.io.File;

public abstract class MetricCalculator {

	private MetricSet metricSet;
	protected File javaFile;

	public MetricCalculator(File javaFile) {
		this.metricSet = new MetricSet();
		this.javaFile = javaFile;
	}

	public File getJavaFile() {
		return javaFile;
	}

	public void setJavaFile(File javaFile) {
		this.javaFile = javaFile;
	}

	/**
	 * Calculates the number of lines in code snippet.
	 * 
	 * @return number of lines(code)
	 */
	public abstract int calculateNoL(String javaCode);

	/**
	 * Calculates the number of classes in code snippet.
	 * 
	 * @return number of classes
	 */
	public abstract int calculateNoC(String javaCode);

	/**
	 * Calculates the number of methods in code snippet.
	 * 
	 * @return number of methods
	 */
	public abstract int calculateNoM(String javaCode);

	/**
	 * Calculates the numbers of lines, classes, methods in code snippet and
	 * stores the results in the MetricSet.
	 */
	public void calculateAll(String javaCode) {
		this.metricSet.setNumberOfLines(calculateNoL(javaCode));
		this.metricSet.setNumberOfClasses(calculateNoC(javaCode));
		this.metricSet.setNumberOfMethods(calculateNoM(javaCode));
	}

	public String displayMetricSet() {
		return this.metricSet.toString();
	}
}
