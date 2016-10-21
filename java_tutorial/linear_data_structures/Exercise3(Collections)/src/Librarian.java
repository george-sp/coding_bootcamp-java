import java.util.ArrayList;

public class Librarian {
	private Library lib;
	
	Librarian() {}
	Librarian(Library lib) { 
		this.lib = lib; 
	}
	
	public void findMeBooksFromAuthor(String author_name) {
		this.lib.printBookFromAuthor(author_name);
	}

	public void findMeAllBooks() {
		this.lib.printAllBooks();
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
	
	public void findMeUsersByName(ArrayList<User> users) {
		this.lib.printUsers(users);
	}
	
	public void findMeUserByID(int userID) {
		this.lib.printUserByID(userID);
	}
	
	public Author getAuthor(String name) {
		return this.lib.getAuthor(name);
	}
	
	public Book getBook(String title) {
		return this.lib.getBook(title);
	}
	
	public ArrayList<User> getUsers(String name) {
		return this.lib.getUsers(name);
	}
	
	public void addNewBookToLibrary(String book_title, Author author,
			String isbn, int physical_copies, int available_copies, int times_rented) {
		this.lib.addNewBook(book_title, author, isbn, physical_copies, available_copies, times_rented);
	}
	
	public void registerUser(String name) {
		this.lib.registerUser(name);
	}
	
	public void unregisterUser(int userID) {
		this.lib.unregisterUser(userID);
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
