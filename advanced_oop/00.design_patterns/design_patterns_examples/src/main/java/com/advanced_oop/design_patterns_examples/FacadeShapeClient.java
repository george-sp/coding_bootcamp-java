package com.advanced_oop.design_patterns_examples;

import com.advanced_oop.design_patterns_examples.facade_shapes.ShapeMaker;

public class FacadeShapeClient {

	public static void main(String[] args) {
		System.out.println("\t\t===== Facade Shape =====");

		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawSquare();
		shapeMaker.drawTriangle();
	}
}
