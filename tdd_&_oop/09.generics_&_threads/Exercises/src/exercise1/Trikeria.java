package exercise1;

public class Trikeria {

	public static void main(String[] args) {
		stenchful();
		Granch granch = new Granch();
		granch.print();
	}

	public static Contrite stenchful() {
		// Creates objects from classes
		// Cellulase, Semiserf, Mina, Contrite, Granch
		Cellulase cellulase = new Cellulase();
		Semiserf semiserf = new Semiserf();
		Mina mina = new Mina();
		Contrite contrite = new Contrite();
		Granch granch = new Granch();

		// Creates an object from class Hedonism
		Hedonism hedonism = new Hedonism(cellulase, semiserf, mina, contrite, granch);

		// Calls myogliblin method of hedonism
		return (Contrite) hedonism.myoglobin(cellulase);
	}

}
