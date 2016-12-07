package com.advanced_oop.design_patterns_examples.abstract_factory_shape_color;

public class FactoryProducer {

	public static AbstractFactory getFactory(FactoryType factoryType) {
		if (factoryType == FactoryType.COLOR)
			return new ColorFactory();
		else if (factoryType == FactoryType.SHAPE)
			return new ShapeFactory();
		else
			return null;
	}
}
