
public class Tester {

	public static void main(String[] args) {
		Shape shape1 = new Shape(2,3);
		Agreeable shape2 = new Shape(4,4);
		System.out.println(shape1.isSmallerThan(shape2));
	}

}
