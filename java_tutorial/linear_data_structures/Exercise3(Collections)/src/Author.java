
public class Author {
	/** members */
	private String name;
	
	/** Constructors */
	Author () {}
	Author (String name) { this.name = name; }
	
	/** Getters and Setters */
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	@Override
	public String toString() { return "author name: " + name; }
}
