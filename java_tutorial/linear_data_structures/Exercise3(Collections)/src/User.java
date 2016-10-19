
public class User {

	/* FIELDS */
	private String name;
	private static int usersCounter;
	private final int USER_ID;
	
	/* Constructors */
	public User() {
		usersCounter++;
		this.USER_ID = usersCounter;
	}
	
	public User(String name) {
		this();
		this.name = name;
	}
	
	/* Setters & Getters */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUsersCounter(int number) {
		usersCounter = number;
	}
	
	public int getUsersCounter() {
		return usersCounter;
	}
	
	public int getUserID() {
		return this.USER_ID;
	}
	
	public String toString() {
		return "User \"" + this.name + "\"\n" + "\tID: " + this.USER_ID + "\n";
	}
}
