package com.advanced_oop.design_patterns_examples.abstract_factory_widgets;

public class WindowsButton extends Button {

	@Override
	public void clicked() {
		System.out.println("Windows Button is pressed");
	}
}
