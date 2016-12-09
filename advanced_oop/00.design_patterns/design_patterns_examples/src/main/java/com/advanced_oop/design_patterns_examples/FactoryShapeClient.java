package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.factory_shapes.Shape;
import com.advanced_oop.design_patterns_examples.factory_shapes.ShapeFactory;
import com.advanced_oop.design_patterns_examples.factory_shapes.ShapeType;

public class FactoryShapeClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Factory Shape =====");
		
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape circle = shapeFactory.createShape(ShapeType.CIRCLE);
		Shape rectangle = shapeFactory.createShape(ShapeType.RECTANGLE);
		Shape square = shapeFactory.createShape(ShapeType.SQUARE);

		circle.draw();
		rectangle.draw();
		square.draw();
	}
}
