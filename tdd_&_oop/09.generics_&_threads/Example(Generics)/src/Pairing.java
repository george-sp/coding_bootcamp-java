
class Pairing<O1, O2> {
	private O1 obj1;
	private O2 obj2;

	public Pairing(O1 o1, O2 o2) {
		obj1 = o1;
		obj2 = o2;
	}

	public O1 getFirst() {
		return this.obj1;
	}

	public O2 getSecond() {
		return this.obj2;
	}

	public String toString() {
		return "(" + obj1.toString() + ", " + obj2.toString() + ")";
	}
}
