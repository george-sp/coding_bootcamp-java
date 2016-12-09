package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.composite_employees.Employee;

public class CompositeEmployeesClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Composite Employees =====");

		// Create some Employees
		Employee ceo = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);
		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		// Create the department level hierarchy
		ceo.add(headSales);
		ceo.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// Print all Employees top to bottom
		System.out.println(ceo);
		for (Employee headEmployee : ceo.getSubordinates()) {
			System.out.println(headEmployee);
			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}
}
