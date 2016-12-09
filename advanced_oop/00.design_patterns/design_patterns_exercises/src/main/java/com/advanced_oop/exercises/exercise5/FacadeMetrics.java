package com.advanced_oop.exercises.exercise5;

import java.io.File;

public class FacadeMetrics {

	private MetricCalculatorType metricCalculatorType;
	private MetricCalculator metricCalculator;

	public FacadeMetrics(MetricCalculatorType metricCalculatorType) {
		this.metricCalculatorType = metricCalculatorType;
	}

	public void setMetricCalculatorType(MetricCalculatorType metricCalculatorType) {
		this.metricCalculatorType = metricCalculatorType;
	}

	public MetricCalculatorType getMetricCalculatorType() {
		return this.metricCalculatorType;
	}

	public void analyseJavaFile(String inputFile, String outputFile) {
		File readFile = new File(inputFile);
		File writeFile = new File(outputFile);

		calculateMetrics(readFile, this.metricCalculatorType);

		writeCsvFile(writeFile, metricCalculator.getCsv());
	}

	private void calculateMetrics(File readFile, MetricCalculatorType metricCalculatorType) {
		this.metricCalculator = MetricCalculatorFactory.createMetricCalculator(readFile, metricCalculatorType);
		metricCalculator.calculateAll(FileHandler.readFile(readFile));
	}

	private void writeCsvFile(File writeFile, String metricsText) {
		FileHandler.writeFile(writeFile, metricsText);
	}
}
