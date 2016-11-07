package domain;

/**
 * Simple Student class with the attributes: - registration number - name -
 * surname - username - password.
 * 
 * @author george
 *
 */
public class Student {

	private String rn;
	private String name;
	private String surname;
	private String username;
	private String password;

	public Student() {
	}

	public Student(String rn, String name, String surname, String username, String password) {
		this.rn = rn;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
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
		return "Student:" + " rn/" + this.rn + ", name" + this.name + ", surname" + this.surname + ", username"
				+ this.username + ", password" + this.password;
	}

}
