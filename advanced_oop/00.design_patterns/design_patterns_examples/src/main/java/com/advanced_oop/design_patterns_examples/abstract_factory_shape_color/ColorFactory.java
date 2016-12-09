package com.advanced_oop.design_patterns_examples.abstract_factory_shape_color;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(ColorType colorType) {
		if (colorType == ColorType.BLUE)
			return new Blue();
		else if (colorType == ColorType.RED)
			return new Red();
		else if (colorType == ColorType.YELLOW)
			return new Yellow();
		else
			return null;
	}

	@Override
	public Shape getShape(ShapeType shapeType) {
		return null;
	}
}
