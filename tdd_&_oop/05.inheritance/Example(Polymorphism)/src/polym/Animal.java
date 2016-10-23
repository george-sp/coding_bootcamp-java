package polym;

public class Animal {
	public static Animal[] animals = new Animal[5];
	// each animal can have a different name
	protected String name;
	// every animal has one tail
	final int tail = 1;

	public Animal(String name) {
		super();// can be omitted
		this.name = name;
	}

	public Animal() {
		// super() is called implicitly
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void move() {
		System.out.print("The animal is moving");
	}

	public int getTail() {
		return tail;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", tail=" + tail + "]";
	}
}
