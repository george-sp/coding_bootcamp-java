package modifiers;

import polym.Animal;

class Cat extends Animal {
	private String independance = "high";

	public Cat() {
		super();
	}

	public Cat(String name, String independance) {
		super(name);
		this.independance = independance;
	}

	public String getIndependance() {
		return independance;
	}

	@Override
	public String toString() {
		return super.toString() + " also Cat [independance=" + independance + "]";
	}

	public void setIndependance(String independance) {
		this.independance = independance;
	}

	public String nickname() {
		return super.name + "kitty";

	}

	@Override
	public void move() {
		super.move();
		System.out.print(" and purring\n");
	}
}
