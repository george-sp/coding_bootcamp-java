import java.util.ArrayList;

/**
 * Represents a List data structure that stores User objects.
 * @author george
 *
 */
public class UserList {

	/* Fields */
	ArrayList<User> users;
	
	/* Constructors */
	public UserList() {
		this.users = new ArrayList<>();
	}
	
	public UserList(ArrayList<User> users) {
		this.users = users;
	}
	
	/* Setters & Getters */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	/**
	 * Adds a user.
	 */
	public void addUser(User user) {
		this.users.add(user);
	}

	/**
	 * Removes a user.
	 */
	public void removeUser(User user) {
		if (this.has(user)) {
			this.users.remove(user);
		}
	}

	/**
	 * Finds a user using the given name.
	 * 
	 * @param name
	 *            The name of user
	 * @return The user with the given name
	 */
	public User findUser(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}
	
	/**
	 * Searches if user exists
	 */
	public boolean has(User user) {
		return this.users.contains(user);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		int userCounter = 1;
		for (User user : users) {
			stringBuilder.append(userCounter)
						 .append(". ")
						 .append(user.getName())
						 .append("\n");
			userCounter++;
		}		
		return stringBuilder.toString();
	}
}

