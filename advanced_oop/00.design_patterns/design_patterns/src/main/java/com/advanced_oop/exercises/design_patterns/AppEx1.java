package com.advanced_oop.exercises.design_patterns;

import com.advanced_oop.exercises.exercise1.Course;
import com.advanced_oop.exercises.exercise1.Instructor;
import com.advanced_oop.exercises.exercise1.Organizer;
import com.advanced_oop.exercises.exercise1.Student;

/**
 * Hello world!
 *
 */
public class AppEx1 {
	public static void main(String[] args) {
		Course course = new Course("10:00");

		course.addObserver(new Student());
		course.addObserver(new Instructor());
		course.addObserver(new Organizer());

		course.setTime("9:30");
	}
}
