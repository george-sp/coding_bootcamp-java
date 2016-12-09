package com.advanced_oop.design_patterns_examples.abstract_factory_shape_color;

public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Is filled with Red");
	}
}
