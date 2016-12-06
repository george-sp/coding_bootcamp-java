package com.advanced_oop.design_patterns_examples.students_factory;

public class Undergrade implements Student {

	private String name;
	private int id;

	protected Undergrade(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public int getID() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Undergrade Student: \n\tname: " + this.name + "\n\tid: " + this.id;
	}
}
