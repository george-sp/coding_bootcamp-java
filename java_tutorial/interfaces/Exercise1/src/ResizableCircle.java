
public class ResizableCircle extends Circle implements Resizable{

	public ResizableCircle() {
		super();
	}
	
	@Override
	public void resize(double percentage) {
		this.radius *= percentage;
	}
}
