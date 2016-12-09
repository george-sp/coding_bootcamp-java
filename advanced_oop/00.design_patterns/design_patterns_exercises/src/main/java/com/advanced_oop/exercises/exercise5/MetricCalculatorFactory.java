package com.advanced_oop.exercises.exercise5;

import java.io.File;

public final class MetricCalculatorFactory {

	public static MetricCalculator createMetricCalculator(File javaFile, MetricCalculatorType metricCalculatorType) {
		if (metricCalculatorType == MetricCalculatorType.REGEX_COMPARISON)
			return new MetricCalculatorRegEx(javaFile);
		else if (metricCalculatorType == MetricCalculatorType.STRING_COMPARISON)
			return new MetricCalculatorString(javaFile);
		return null;
	}
}
