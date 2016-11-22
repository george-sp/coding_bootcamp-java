package com.maven.exercises;

/**
 * @author george
 *
 *         Triangle class represents a single triangle. Each triangle is
 *         represented by the length of its sides.
 */
public class Triangle {

	// the sides of the triangle
	private double a;
	private double b;
	private double c;

	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Sets value to side a
	 * 
	 * @param sideA
	 *            side a to set
	 */
	public void setSideA(double sideA) {
		this.a = sideA;
	}

	/**
	 * Sets value to side b
	 * 
	 * @param sideB
	 *            side b to set
	 */
	public void setSideB(double sideB) {
		this.b = sideB;
	}

	/**
	 * Sets value to side c
	 * 
	 * @param sideC
	 *            side c to set
	 */
	public void setSideC(double sideC) {
		this.c = sideC;
	}

	/**
	 * Get the length of side a
	 * 
	 * @return the current length of side a
	 */
	public double getSideA() {
		return this.a;
	}

	/**
	 * Get the length of side b
	 * 
	 * @return the current length of side b
	 */
	public double getSideB() {
		return this.b;
	}

	/**
	 * Get the length of side c
	 * 
	 * @return the current length of side c
	 */
	public double getSideC() {
		return this.c;
	}

	/**
	 * Checks if the three given sides can form a triangle.
	 * 
	 * Formula: - a < b + c, a > 0 - b < a + c , b > 0 - c < a + b , c > 0
	 * 
	 * @param a
	 *            side a of the triangle
	 * @param b
	 *            side b of the triangle
	 * @param c
	 *            side c of the triangle
	 * @return true if the given sides can form a triangle, otherwise false
	 */
	public static boolean isTriangle(double a, double b, double c) {
		return ((a > 0 & b > 0 & c > 0) & (a < (b + c) & b < (a + c) & c < (a + b)));
	}

	/**
	 * Returns the greater of three Triangle's side
	 * 
	 * @return the larger of a, b and c sides
	 */
	private double getLargerSide() {
		return Math.max(Math.max(a, b), c);
	}

	/**
	 * Checks if the Triangle is right
	 * 
	 * @return true if the Triangle is right, else false
	 */
	public boolean isRight() {
		double hypotenuse = getLargerSide();
		return (hypotenuse == Math.sqrt((a * a) + (b * b)) | hypotenuse == Math.sqrt((a * a) + (c * c))
				| hypotenuse == Math.sqrt((b * b) + (c * c)));
	}

	/**
	 * Calculate the Triangle's perimeter
	 * 
	 * @return the perimeter of the Triangle
	 */
	public double getPerimeter() {
		return a + b + c;
	}
}
