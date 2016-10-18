
public class Librarian {
	private Library lib;
	
	Librarian() {}
	Librarian(Library lib) { 
		this.lib = lib; 
	}
	
	public void findMeBooksFromAuthor(String author_name) {
		this.lib.printBookFromAuthor(author_name);
	}
	
	public void findMeAvailableBooks() {
		this.lib.printAvailableBooks();
	}
	
	public void findMeBook(String book_title) {
		this.lib.printBookDetails(book_title);
	}
	
	public Author getAuthor(String name) {
		return this.lib.getAuthor(name);
	}
	
	public void addNewBookToLibrary(String book_title, Author author,
			String isbn, int physical_copies, int available_copies, int times_rented) {
		//TODO
	}
	
	public void rentBook(String title, String user) {
		this.lib.rentBook(title, user);
	}
	
	public void returnBook(String title, String user) {
		this.lib.returnBook(title, user);
	}
	
	public void printPendingTransactions() {
		this.lib.printPendingTransactions();
	}
}
