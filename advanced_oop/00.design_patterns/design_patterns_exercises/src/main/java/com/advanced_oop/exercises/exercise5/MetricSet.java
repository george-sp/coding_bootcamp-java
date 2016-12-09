package com.advanced_oop.exercises.exercise5;

public class MetricSet {

	private int numberOfLines;
	private int numberOfClasses;
	private int numberOfMethods;

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public void setNumberOfLines(int numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	public int getNumberOfMethods() {
		return numberOfMethods;
	}

	public void setNumberOfMethods(int numberOfMethods) {
		this.numberOfMethods = numberOfMethods;
	}

	@Override
	public String toString() {
		return "LoC: " + numberOfLines + "\nNoC: " + numberOfClasses + "\nNoM: " + numberOfMethods;
	}
}
