package com.advanced_oop.exercises.design_patterns;

import com.advanced_oop.exercises.exercise2.FileUtils;
import com.advanced_oop.exercises.exercise3.MetricsUtils;

public class AppEx3 {

	public static void main(String[] args) {
		String filePath = "Test.java";
		String javaText = FileUtils.readFile(filePath);

		System.out.println("\nLOC: " + MetricsUtils.countLOC(javaText) + "\n");
		System.out.println("\nClasses: " + MetricsUtils.countClasses(javaText) + "\n");
		System.out.println("\nMethods: " + MetricsUtils.countMethods(javaText));
	}

}
