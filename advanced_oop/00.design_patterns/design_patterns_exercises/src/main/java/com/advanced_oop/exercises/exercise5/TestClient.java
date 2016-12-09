package com.advanced_oop.exercises.exercise5;

public class TestClient {

	public static void main(String[] args) {

		FacadeMetrics facadeMetrics = new FacadeMetrics(MetricCalculatorType.STRING_COMPARISON);
		facadeMetrics.analyseJavaFile("Test.java", "Metrics.csv");
	}
}
