package polym;

public class TesterPolym {

	public static void main(String[] args) {
		// create animals
		Animal animal1 = new Animal();// default constructor
		Animal animal2 = new Animal("Lacy");// overloaded constructor

		System.out.println(animal1);
		System.out.println(animal2);
		// animal1.getLegs(); ILLEGAL!!

		// create Dogs
		Animal dog1 = new Dog();// default constructor
		Animal dog2 = new Dog("Lacy", 4);// overloaded constructor

		System.out.println(dog1);
		System.out.println(dog2);
		System.out.println(dog2.getTail()); // inherited method
		dog2.move();// calling the overridden method
		// dog1.dogOnlyMethod(); ILLEGAL!!
		// dog1.getLegs(); ILLEGAL!!

		/**
		 * When reference variable of Parent class refers to the object of Child
		 * class, it is known as upcasting.
		 **/
		Animal animal3 = new Dog("Rex", 4);
		animal3.move();// calling subclass overridden move
		// animal3.getLegs(); ILLEGAL!!

		/*
		 * When Subclass type refers to the object of Parent class, it is known
		 * as downcasting.
		 */
		Dog dog3 = (Dog) animal3;
		System.out.println(dog3.getLegs());
		// System.out.println(((Dog)animal3).getLegs()); // lines 36 & 37 in one
	}

}
