public class Librarian {

	// the library that he manages
	private Library library;
	
	/**
	 * Constructors
	 */
	// Default Constructor
	public Librarian(){}
	
	public Librarian(Library library) {
		this.library = library;
	}
	
	/**
	 * Setters & Getters
	 */
	public void setLibrary(Library library) {
		this.library = library;
	}
	
	public Library getLibrary() {
		return this.library;
	}
	
	/**
	 * Receives an author name and delegates the request 
	 * to the library's printBookFromAuthor method.
	 * @param authorName
	 */
	public void findMeBooksFromAuthor(String authorName) {
		this.library.printBookFromAuthor(authorName);
	}
	
	/**
	 * Delegates the request to the library's printAvailableBooks method.
	 */
	public void findMeAvailableBooks() {
		this.library.printAvailableBooks();
	}
	
	/**
	 * Receives a book's title and delegates the request
	 * to the library's printBookDetails method.
	 * @param bookTitle
	 */
	public void findMeBook(String bookTitle) {
		this.library.printBookDetails(bookTitle);
	}
}
