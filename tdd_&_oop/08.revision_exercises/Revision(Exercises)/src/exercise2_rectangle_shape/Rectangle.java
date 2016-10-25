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
		String newLine = "\n";
		String lineEdge = "-";
		String lineSeperator = "-";
        // Generate the lineSeperator.
        for (int z = 0; z < this.sideA; z++) {
            lineEdge += "----";
            if (z == this.sideA - 1) lineSeperator += "----";
            else lineSeperator += "---+";
        }
		
		StringBuilder drawBuilder = new StringBuilder();
		drawBuilder.append(lineEdge).append(newLine);
		for (int i = 0; i < this.getSideB(); i++) {
            drawBuilder.append("| ");
            for (int j = 0; j < this.getSideA(); j++) {
            	drawBuilder.append("  | ");
            }
            drawBuilder.append("\n");
            if (i == this.sideB - 1) drawBuilder.append(lineEdge);
            else drawBuilder.append(lineSeperator).append(newLine);
        }
        return drawBuilder.toString();
	}
	
	public Rectangle copy() {
		return this;
	}
}
