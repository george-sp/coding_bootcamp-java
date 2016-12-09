package com.advanced_oop.exercises.exercise1;

import java.util.Observable;
import java.util.Observer;

public class Organizer implements Observer {

	@Override
	public void update(Observable observable, Object arg1) {
		System.out.println("Organizer: course time = " + ((Course) observable).getTime());
	}

}
