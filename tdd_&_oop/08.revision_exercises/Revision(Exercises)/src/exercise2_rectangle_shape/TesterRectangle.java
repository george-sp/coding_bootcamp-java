package exercise2_rectangle_shape;

public class TesterRectangle {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(2,3);
		Rectangle r3 = new Rectangle(3,2);
		Rectangle r4 = new Rectangle(4,4);
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println("r1.areEqual(r2) " + r1.areEqual(r2));
		System.out.println("r2.areEqual(r3) " + r2.areEqual(r3));
		System.out.println("r3.isSquare() " + r3.isSquare());
		System.out.println("r4.isSquare() " + r4.isSquare());
		Rectangle r5 = r4.copy();
//		r5.setSideA(5);
		System.out.println(r4.toString());
		System.out.println(r5.toString());
		System.out.println(r3.draw());
	}
}
