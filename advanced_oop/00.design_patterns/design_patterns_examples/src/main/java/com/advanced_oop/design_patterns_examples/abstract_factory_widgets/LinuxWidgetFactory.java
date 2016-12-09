package com.advanced_oop.design_patterns_examples.abstract_factory_widgets;

public class LinuxWidgetFactory extends AbstractWidgetFactory {

	@Override
	public Button createButton() {
		return new LinuxButton();
	}

	@Override
	public Frame createFrame() {
		return new LinuxFrame();
	}
}
