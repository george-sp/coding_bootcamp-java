
public class Shape implements Agreeable{

	private int width;
	private int height;
	
	public Shape() {}
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public boolean isSmallerThan(Agreeable other) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int calcArea() {
		return width * height;
	}
}
