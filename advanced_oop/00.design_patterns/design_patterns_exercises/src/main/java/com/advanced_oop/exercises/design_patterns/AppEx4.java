package com.advanced_oop.exercises.design_patterns;

import java.io.File;

import com.advanced_oop.exercises.exercise5.FileHandler;
import com.advanced_oop.exercises.exercise5.MetricCalculator;
import com.advanced_oop.exercises.exercise5.MetricCalculatorFactory;
import com.advanced_oop.exercises.exercise5.MetricCalculatorType;

public class AppEx4 {

	public static void main(String[] args) {
		File testJavaFile = new File("Test.java");
		MetricCalculator metricCalculator = MetricCalculatorFactory.createMetricCalculator(testJavaFile,
				MetricCalculatorType.REGEX_COMPARISON);
		metricCalculator.calculateAll(FileHandler.readFile(metricCalculator.getJavaFile()));
		System.out.println("Regular Expression comparison: " + metricCalculator.getJavaFile() + "\n"
				+ metricCalculator.displayMetricSet());
	}
}
