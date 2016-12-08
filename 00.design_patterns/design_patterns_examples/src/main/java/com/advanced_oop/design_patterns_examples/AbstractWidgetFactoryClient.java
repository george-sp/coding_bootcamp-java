package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.abstract_factory_widgets.AbstractWidgetFactory;
import com.advanced_oop.design_patterns_examples.abstract_factory_widgets.Button;
import com.advanced_oop.design_patterns_examples.abstract_factory_widgets.Frame;
import com.advanced_oop.design_patterns_examples.abstract_factory_widgets.OSType;
import com.advanced_oop.design_patterns_examples.abstract_factory_widgets.WidgetFactoryProducer;

public class AbstractWidgetFactoryClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Abstract Factory (Operating System) =====");

		AbstractWidgetFactory windowsFactory = WidgetFactoryProducer.getWidgetFactory(OSType.WINDOWS);
		AbstractWidgetFactory linuxFactory = WidgetFactoryProducer.getWidgetFactory(OSType.LINUX);

		Frame windowsFrame = windowsFactory.createFrame();
		Button windowsButton = windowsFactory.createButton();
		windowsFrame.focused();
		windowsButton.clicked();

		Frame linuxFrame = linuxFactory.createFrame();
		Button linuxButton = linuxFactory.createButton();
		linuxFrame.focused();
		linuxButton.clicked();
	}
}
