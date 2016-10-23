package polym;

public class Dog extends Animal {
	private int legs;

	public Dog(String name, int legs) {
		super(name);
		this.legs = legs;
	}

	public Dog() {
		// all dogs that will be named Azor
		super("Azor"); 
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public String dogOnlyMethod() {
		return "Dog only Method.";
	}
	
	@Override
	public void move() {
		super.move();
		System.out.println(" and barks");
	}

	@Override
	public String toString() {
		return super.toString() + " also Dog [legs=" + legs + "]";
	}
}
