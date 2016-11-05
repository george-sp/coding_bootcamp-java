package add_obj_to_session;

/**
 * The class represents the customer and all his or her characteristics.
 * 
 * @author George Spyridakis
 * @date 2016-11-05
 *
 */
public class Customer {
	/*
	 * Customer's name.
	 */
	private String name;

	/*
	 * Customer's surname.
	 */
	private String surname;

	/*
	 * Customer's username.
	 */
	private String username;

	/*
	 * Customer's password.
	 */
	private String password;

	/*
	 * Customer's preferences.
	 */
	private String preferences;

	/*
	 * Customer's gender.
	 */
	private String gender;

	/*
	 * Customer's age.
	 */
	private String age;

	/**
	 * A method to get customer's name
	 * 
	 * @return String ,customer's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * A method to get customer's surname
	 * 
	 * @return String ,customer's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * A method to get customer's username
	 * 
	 * @return String ,customer's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * A method to get customer's password
	 * 
	 * @return String ,customer's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * A method to get customer's preferences
	 * 
	 * @return String ,customer's preferences
	 */
	public String getPreferences() {
		return preferences;
	}

	/**
	 * A method to get customer's gender
	 * 
	 * @return String ,customer's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * A method to get customer's age
	 * 
	 * @return String ,customer's age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Sets customer's surname
	 * 
	 * @param surname,
	 *            String
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Sets customer's name
	 * 
	 * @param name,
	 *            String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets customer's username
	 * 
	 * @param name,
	 *            String
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Sets customer's password
	 * 
	 * @param name,
	 *            String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets customer's preferences
	 * 
	 * @param name,
	 *            String
	 */
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	/**
	 * Sets customer's gender
	 * 
	 * @param name,
	 *            String
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Sets customer's age
	 * 
	 * @param name,
	 *            String
	 */
	public void setAge(String age) {
		this.age = age;
	}

}