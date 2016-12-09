package com.advanced_oop.design_patterns_examples.factory_shapes;

public class ShapeFactory {

	public Shape createShape(ShapeType shapeType) {
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
