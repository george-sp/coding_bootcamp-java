package polym;

public class TesterPolym {

	public static void main(String[] args) {
		// create animals
		Animal animal1 = new Animal();// default constructor
		Animal animal2 = new Animal("Lacy");// overloaded constructor

		System.out.println(animal1);
		System.out.println(animal2);
//		animal1.getLegs(); illegal!!
		
		//create Dogs
		Animal dog1 = new Dog();//default constructor
		Animal dog2 = new Dog("Lacy",4);//overloaded constructor
		
		System.out.println(dog1);
		System.out.println(dog2);		
		System.out.println(dog2.getTail()); //inherited method
		dog2.move();//calling the overridden method
//		dog1.dogOnlyMethod(); illegal!!
	}

}
