package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.strategy.Context;
import com.advanced_oop.design_patterns_examples.strategy.OperationAddition;
import com.advanced_oop.design_patterns_examples.strategy.OperationMultiplication;
import com.advanced_oop.design_patterns_examples.strategy.OperationSubtraction;

public class StrategyOperationClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Strategy Operation =====");

		int num1 = 3;
		int num2 = 5;

		Context context = new Context(new OperationAddition());
		System.out.println("Addition: " + num1 + " + " + num2 + " = " + context.executeOperation(num1, num2));

		context = new Context(new OperationSubtraction());
		System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + context.executeOperation(num1, num2));

		context = new Context(new OperationMultiplication());
		System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + context.executeOperation(num1, num2));
	}
}
