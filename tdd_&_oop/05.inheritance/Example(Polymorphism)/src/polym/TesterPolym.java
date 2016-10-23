package polym;

public class TesterPolym {

	public static void main(String[] args) {
		// create animals
		Animal animal1 = new Animal();// default constructor
		Animal animal2 = new Animal("Lacy");// overloaded constructor

		System.out.println(animal1);
		System.out.println(animal2);
		// animal1.getLegs(); illegal!!
	}

}
