package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.factory_students.Student;
import com.advanced_oop.design_patterns_examples.factory_students.StudentFactory;
import com.advanced_oop.design_patterns_examples.factory_students.StudentType;

public class AcademyDepartment {

	public static void main(String[] args) {
		Student undergrade = StudentFactory.createStudent(StudentType.UNDERGRADE, "John", 1);
		Student master = StudentFactory.createStudent(StudentType.MASTER, "Smith", 1);

		System.out.println(undergrade.toString());
		System.out.println(master.toString());
	}
}
