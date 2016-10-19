
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

	public void findMeAuthor(Author author) {
		this.lib.printAuthor(author);
	}
	
	public void findMeUser(User user) {
		this.lib.printUser(user);
	}
	
	public Author getAuthor(String name) {
		return this.lib.getAuthor(name);
	}
	
	public Book getBook(String title) {
		return this.lib.getBook(title);
	}
	
	public User getUser(String name) {
		return this.lib.getUser(name);
	}
	
	public void addNewBookToLibrary(String book_title, Author author,
			String isbn, int physical_copies, int available_copies, int times_rented) {
		this.lib.addNewBook(book_title, author, isbn, physical_copies, available_copies, times_rented);
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
	
	public void executePendingTransactions() {
		this.lib.executePendingTransactions();
	}
	
	public void printTransactionsHistory() {
		this.lib.printTransactionsHistory();
	}
}
