
public class Circle implements Shape{

	protected double radius;
	
	public Circle() {}
	
	@Override
	public void getParameter() {
		System.out.println("getParameter()");
		// 2 * 3.14 * radius
	}
	
	@Override
	public void getArea() {
		System.out.println("getArea()");
		// 3.14 * Math.pow(radius)
	}
	
	
}
