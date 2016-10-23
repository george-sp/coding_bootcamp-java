
public class Book {
	/** members */
	private String title;
	private Author author;
	private final String isbn;
	private int physical_copies;
	private int available_copies;
	private int times_rented;
	private Book next;

	/** Constructor */
	Book(String title, Author author, String isbn, int physical_copies) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.physical_copies = physical_copies;
		this.available_copies = physical_copies;
		this.next = null;
	}

	Book(String title, Author author, String isbn, int physical_copies, int available_copies, int times_rented) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.physical_copies = physical_copies;
		this.available_copies = available_copies;
		this.times_rented = times_rented;
		this.next = null;
	}
	
	/** Getters and Setters */
	public void setNext(Book book) {
		this.next = book;
	}

	public Book getNext() {
		return next;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPhysicalCopies() {
		return physical_copies;
	}

	public void setPhysicalCopies(int physical_copies) {
		this.physical_copies = physical_copies;
	}

	public int getAvailableCopies() {
		return available_copies;
	}

	public void setAvailableCopies(int available_copies) {
		this.available_copies = available_copies;
	}

	public int getTimesRented() {
		return times_rented;
	}

	public void setTimesRented(int times_rented) {
		this.times_rented = times_rented;
	}

	public String getIsbn() {
		return isbn;
	}

	public boolean rentPhysicalCopy() {
		if (this.available_copies > 0) {
			this.available_copies--;
			this.times_rented++;
			return true;
		} 
		return false;
	}
	
	public boolean returnPhysicalCopy() {
		if (this.available_copies < this.physical_copies) {
			this.available_copies++;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Book \"" + this.title + "\"\n" + "\tisbn: " + this.isbn + "\n" + "\t" + this.author.toString() + "\n"
				+ "\tavailable copies: " + this.available_copies + "\n" + "\tphysical copies: " + this.physical_copies
				+ "\n" + "\ttimes rented: " + this.times_rented + "\n";
	}

	public boolean isAvailable() {
		return this.available_copies > 0;
	}

	public boolean hasAuthor(String author_name) {
		return this.author.getName().equalsIgnoreCase(author_name);
	}

}
