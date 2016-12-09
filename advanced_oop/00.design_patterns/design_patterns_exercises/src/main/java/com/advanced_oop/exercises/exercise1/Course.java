package com.advanced_oop.exercises.exercise1;

import java.util.Observable;

public class Course extends Observable {

	String time;

	public Course(String time) {
		this.time = time;
	}

	public void setTime(String time) {
		this.time = time;
		setChanged();
		notifyObservers();
	}

	public String getTime() {
		return time;
	}
}
