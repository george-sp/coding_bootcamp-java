import java.util.ArrayList;
import java.util.Date;

public class Library {
	// Library is responsible for accessing and modifying the author list.
	private AuthorList authors;
	// Library is responsible for accessing and modifying the book list.
	private BookList books;
	// Library is responsible for accessing and modifying the user list.
	private UserList users;
	
	/** Constructors */
	public Library() {}
	
	public Library(BookList books, AuthorList authors) {
		this.books = books;
		this.authors = authors;
	}
	
	public Library(BookList books, AuthorList authors, UserList users) {
		this.books = books;
		this.authors = authors;
		this.users = users;
	}
	
	/** Getters and Setters */
	public void setBookList(BookList books) {
		this.books = books;
	}
	
	public void setAuthorList(AuthorList authors) {
		this.authors = authors;
	}
	
	public void setUserList(UserList users) {
		this.users = users;
	}
	
	public void printAvailableBooks() {
		ArrayList<Book> availableBooks = books.getAvailableBooks();
		StringBuilder availableBooksString = new StringBuilder("Available Books:\n");
		for (Book book : availableBooks) {
			availableBooksString.append(book.getTitle()).append("\n");
		}
		System.out.println(availableBooksString);
	}
	
	public void printBookDetails(String book_title) {
		Book foundBook = books.findBook(book_title);
		if (foundBook != null) {
			System.out.println(foundBook.toString());
		} else {
			System.out.println("Book not found!");
		}
	}
	
	public void printBookFromAuthor(String author_name) {
		ArrayList<Book> books = this.books.getAllBooks();
		boolean bookFound = false;
		StringBuilder stringBuilder = new StringBuilder("Books from " + author_name + "\n");
		for (Book book : books) {
			if (book.hasAuthor(author_name)) {
				bookFound = true;
				stringBuilder.append(book.toString());
			}
		}
		if (!bookFound) {
			System.out.println("No book with author: " + author_name);
		} else {
			System.out.println(stringBuilder.toString());
		}
	}
	
	public void printAuthor(Author author) {
		if (author != null) {
			System.out.println(author.toString());
		} else {
			System.out.println("Author not found!");
		}
	}
	
	public void printUser(User user) {
		if (user != null) {
			System.out.println(user.toString());
		} else {
			System.out.println("User not found!");
		}
	}
	
	public Author getAuthor(String author_name) {
		return authors.findAuthor(author_name);
	}
	
	public Book getBook(String title) {
		return books.findBook(title);
	}
	
	public User getUser(String name) {
		return users.findUser(name);
	}
	
	public void addNewBook(String title, Author author, String isbn,
			int physical_copies, int available_copies, int times_rented) {
		books.addBook(new Book(title, author, isbn, physical_copies, available_copies, times_rented));
	}
	
	public void rentBook(String title, String userName) {
		Book book = this.getBook(title);
		User user = this.getUser(userName);
		if (book != null && user != null){			
			book.rentPhysicalCopy();
			Transaction bookRentalTransaction = new BookRental(book, new Date(), null, user.getUserID());
		}
	}
	
	public void returnBook(String title, String user) {
		//TODO
	}
	
	public void printPendingTransactions() {
		//TODO
	}
}
