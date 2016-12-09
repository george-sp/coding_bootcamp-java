package com.advanced_oop.exercises.design_patterns;

import com.advanced_oop.exercises.exercise5.FacadeMetrics;
import com.advanced_oop.exercises.exercise5.MetricCalculatorType;

public class AppEx4 {

	public static void main(String[] args) {
		FacadeMetrics facadeMetrics = new FacadeMetrics(MetricCalculatorType.STRING_COMPARISON);
		facadeMetrics.analyseJavaFile("Test.java", "Metrics.csv");
	}
}
