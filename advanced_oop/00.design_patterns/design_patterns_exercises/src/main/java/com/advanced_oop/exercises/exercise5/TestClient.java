package com.advanced_oop.exercises.exercise5;

import java.io.File;

public class TestClient {

	public static void main(String[] args) {
		File testJavaFile = new File("Test.java");

		// Use a MetricCalculator that uses Regular Expression comparison
		MetricCalculator metricCalculator = MetricCalculatorFactory.createMetricCalculator(testJavaFile,
				MetricCalculatorType.REGEX_COMPARISON);
		metricCalculator.calculateAll(FileHandler.readFile(metricCalculator.getJavaFile()));
		System.out.println("Regular Expression comparison: " + metricCalculator.getJavaFile() + "\n"
				+ metricCalculator.displayMetricSet());

		// Use a MetricCalculator that uses String comparison
		metricCalculator = MetricCalculatorFactory.createMetricCalculator(testJavaFile,
				MetricCalculatorType.STRING_COMPARISON);
		metricCalculator.calculateAll(FileHandler.readFile(metricCalculator.getJavaFile()));
		System.out.println(
				"String comparison: " + metricCalculator.getJavaFile() + "\n" + metricCalculator.displayMetricSet());
	}
}
