package com.advanced_oop.design_patterns_examples.abstract_factory_widgets;

public class WindowsWidgerFactory extends AbstractWidgetFactory {

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public Frame createFrame() {
		return new WindowsFrame();
	}
}
