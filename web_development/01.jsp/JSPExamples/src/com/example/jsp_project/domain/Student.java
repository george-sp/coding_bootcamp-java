package domain;

/**
 * Simple Student class with the attributes: - registration number - name -
 * surname - username - password.
 * 
 * @author george
 *
 */
public class Student {

	private String rm;
	private String name;
	private String surname;
	private String username;
	private String password;

	public Student() {
	}

	public Student(String rm, String name, String surname, String username, String password) {
		this.rm = rm;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Student:" + " am/" + this.rm + ", name" + this.name + ", surname" + this.surname + ", username"
				+ this.username + ", password" + this.password;
	}

}
