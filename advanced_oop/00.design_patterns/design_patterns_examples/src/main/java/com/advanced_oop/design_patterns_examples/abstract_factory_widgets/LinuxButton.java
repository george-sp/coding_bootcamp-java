package com.advanced_oop.design_patterns_examples.abstract_factory_widgets;

public class LinuxButton extends Button {

	@Override
	public void clicked() {
		System.out.println("Linux Button is pressed");
	}
}
