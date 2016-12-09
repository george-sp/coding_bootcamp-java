package com.advanced_oop.design_patterns_examples.strategy;

public class Context {

	private StrategyOperation strategy;

	public Context(StrategyOperation strategyOperation) {
		this.strategy = strategyOperation;
	}

	public int executeOperation(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
