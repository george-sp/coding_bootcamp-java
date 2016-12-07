package com.advanced_oop.design_patterns_examples.factory_students;

public class StudentFactory {

	public static Student createStudent(StudentType studentType, String studentName, int studentID) {
		if (studentType == StudentType.UNDERGRADE) {
			return new Undergrade(studentName, studentID);
		} else if (studentType == StudentType.MASTER) {
			return new Master(studentName, studentID);
		}
		return null;
	}
}
