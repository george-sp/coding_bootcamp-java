package com.advanced_oop.design_patterns_examples.factory_students;

public class Master implements Student {

	private String name;
	private int id;

	protected Master(String name, int id) {
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
		return "Master Student: \n\tname: " + this.name + "\n\tid: " + this.id;
	}
}
