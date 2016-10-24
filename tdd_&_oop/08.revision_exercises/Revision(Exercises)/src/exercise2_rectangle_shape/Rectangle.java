package exercise2_rectangle_shape;

public class Rectangle {

	int sideA;
	int sideB;

	public Rectangle() {
	}

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

	public boolean areEqual(Rectangle r) {
		return this.sideA * this.sideB == r.sideA * r.sideB;
	}

	public boolean isSquare() {
		return this.sideA == this.sideB;
	}

	public String draw() {
		String str = "";
		for (int i = 0; i <= this.sideA; i++) {
			if (i == 0 || i == sideA) {
				for (int j = 0; j < this.sideB; j++) {
					str += "-";
				}
				str += "\n";
			}
			if (i < this.sideA) {
				for (int j = 0; j < this.sideB; j++) {
					if (j == 0 || j == this.sideA - 1) {
						str += "| ";
					} else {
						str += " ";
					}
				}
				str += "\n";
			}
		}
		return str;
	}

	public Rectangle copy() {
		return this;
	}
}
