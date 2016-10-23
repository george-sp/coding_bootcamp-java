package modifiers;

import polym.Animal;
import polym.Dog;

public class TesterModifiers {
	public static void main(String[] args) {

		Cat cat = new Cat();
		// System.out.println(cat.tail); ILLEGAL!!
		// System.out.println(cat.name); ILLEGAL!!
		System.out.println(cat); // protected field variable
		System.out.println(cat.nickname()); // protected field variable

		System.out.println("\n*** Print Animal Array***");

		Animal animals[] = new Animal[3];
		// upcasting
		animals[0] = new Cat("Claire", "high");
		animals[1] = new Dog();
		animals[2] = new Animal();

		System.out.println(((Cat) animals[0]).nickname());
		// System.out.println(((Cat)animals[1]).nickname()); ILLEGAL!!
		// System.out.println(((Cat)animals[2]).nickname()); ILLEGAL!!

		int i = 0;
		for (Animal animal : animals) {
			System.out.println("animal[" + i + "] : " + " " + animal.getClass());
			System.out.print("     ");
			animal.move();
			// animal.nickname(); ILLEGAL!!
			// ((Cat)animal).nickname(); seems legal but is not **WHY???***
			if (animal instanceof Animal)
				System.out.println("     Animal instance");
			if (animal instanceof Dog)
				System.out.println("     Dog instance");
			else if (animal instanceof Cat) {
				System.out.println("     Cat instance called " + ((Cat) animal).nickname());// downcasting
				System.out.println(animal);
			}
			i++;
			System.out.println("\n");
		}
	}
}
