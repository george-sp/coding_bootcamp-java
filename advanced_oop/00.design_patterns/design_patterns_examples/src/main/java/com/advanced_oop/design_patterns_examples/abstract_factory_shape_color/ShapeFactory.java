package com.advanced_oop.design_patterns_examples.abstract_factory_shape_color;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(ColorType colorType) {
		return null;
	}

	@Override
	public Shape getShape(ShapeType shapeType) {
		if (shapeType == ShapeType.CIRCLE)
			return new Circle();
		else if (shapeType == ShapeType.RECTANGLE)
			return new Rectangle();
		else if (shapeType == ShapeType.SQUARE)
			return new Square();
		else
			return null;
	}

}
