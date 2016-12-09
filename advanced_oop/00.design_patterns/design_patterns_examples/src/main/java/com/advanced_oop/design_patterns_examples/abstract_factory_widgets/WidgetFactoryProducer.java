package com.advanced_oop.design_patterns_examples.abstract_factory_widgets;

public class WidgetFactoryProducer {

	public static AbstractWidgetFactory getWidgetFactory(OSType operatingSystem) {
		if (operatingSystem == OSType.LINUX)
			return new LinuxWidgetFactory();
		else if (operatingSystem == OSType.WINDOWS)
			return new WindowsWidgerFactory();
		return null;
	}
}
