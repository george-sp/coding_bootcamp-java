package com.advanced_oop.design_patterns_examples.strategy;

public class OperationMultiplication implements StrategyOperation {

	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}
