package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.AbstractFactory;
import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.Color;
import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.ColorType;
import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.FactoryProducer;
import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.FactoryType;
import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.Shape;
import com.advanced_oop.design_patterns_examples.abstract_factory_shape_color.ShapeType;

public class AbstractFactoryClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Abstract Factory (Shape/Color) =====");

		AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryType.SHAPE);
		AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryType.COLOR);

		Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
		Color blue = colorFactory.getColor(ColorType.BLUE);
		circle.draw();
		blue.fill();

		Shape square = shapeFactory.getShape(ShapeType.SQUARE);
		Color red = colorFactory.getColor(ColorType.RED);
		square.draw();
		red.fill();

		Shape rectangle = shapeFactory.getShape(ShapeType.RECTANGLE);
		Color yellow = colorFactory.getColor(ColorType.YELLOW);
		rectangle.draw();
		yellow.fill();
	}
}