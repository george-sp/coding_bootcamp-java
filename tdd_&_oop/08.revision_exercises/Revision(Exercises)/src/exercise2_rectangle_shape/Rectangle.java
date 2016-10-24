package exercise2_rectangle_shape;

public class Rectangle {
	
	int sideA;
	int sideB;
	
	public Rectangle() {}
	
	public Rectangle(int a, int b) {
		this.sideA = a;
		this.sideB = b;
	}
	
	public void setSideA(int a) {
		this.sideA = a;
	}
	
	public int getSideA() {
		return this.sideA;
	}
	
	public void setSideB(int b) {
		this.sideB = b;
	}
	
	public int getSideB() {
		return this.sideB;
	}
	
	public String toString() {
		return "Rectangle\n\tsideA: " + sideA + "\n\tsideB: " + sideB;
	}
}
