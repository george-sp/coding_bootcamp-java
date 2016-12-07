package com.advanced_oop.design_patterns_examples.abstract_factory_shape_color;

public abstract class AbstractFactory {

	public abstract Color getColor(ColorType colorType);

	public abstract Shape getShape(ShapeType shapeType);
}
