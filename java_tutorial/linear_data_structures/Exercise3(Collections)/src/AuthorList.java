import java.util.ArrayList;

public class AuthorList {

	/* Fields */
	ArrayList<Author> authors;

	/* Constructors */
	public AuthorList() {
		this.authors = new ArrayList<>();
	}

	public AuthorList(Author[] authorsArray) {
		this();
		for (Author author : authorsArray) {
			this.addAuthor(author);
		}
	}

	/* Setters & Getters */
	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}

	public ArrayList<Author> getAuthors() {
		return this.authors;
	}

	/**
	 * Adds an author.
	 */
	public void addAuthor(Author author) {
		this.authors.add(author);
	}

	/**
	 * Removes an author.
	 */
	public void removeAuthor(Author author) {
		if (this.authors.has(author)) {
			this.authors.remove(author);
		}
	}

	/**
	 * Finds an author using the given name.
	 * 
	 * @param name
	 *            The name of author
	 * @return The author with the given name
	 */
	public Author findAuthor(String name) {
		for (Author author : authors) {
			if (author.getName().equals(name)) {
				return author;
			}
		}

		System.out.println("Author " + name + " not found in the author list");
		return null;
	}

	/**
	 * Prints the numbers of authors.
	 */
	public void printAuthors() {
		if (!this.authors.isEmpty()) {
			System.out.println("The number of authors is: " + this.authors.size());
		} else {
			System.out.println("No authors found");
		}
	}

	/**
	 * Searches if author exists
	 */
	public boolean has(Author author) {
		return this.authors.contains(author);
	}
}
