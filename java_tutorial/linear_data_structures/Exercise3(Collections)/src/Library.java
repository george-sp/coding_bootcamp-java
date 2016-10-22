import java.util.ArrayList;
import java.util.Date;

public class Library {
	// Library is responsible for accessing and modifying the author list.
	private AuthorList authors;
	// Library is responsible for accessing and modifying the book list.
	private BookList books;
	// Library is responsible for accessing and modifying the user list.
	private UserList users;
	// Transaction that have been validated but not yet executed should be stored in queue.
	private TransactionQueue transactionQueue;
	// All executed Transactions should be stored in history.
	private TransactionHistory transactionHistory;

	/** Constructors */
	public Library() {
		this.authors = new AuthorList();
		this.books = new BookList();
		this.users = new UserList();
		this.transactionQueue = new TransactionQueue();
		this.transactionHistory = new TransactionHistory();
	}

	public Library(BookList books, AuthorList authors) {
		this();
		this.books = books;
		this.authors = authors;
	}
	
	public Library(BookList books, AuthorList authors, UserList users) {
		this();
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

	public void setTransactionQueue(TransactionQueue transactions) {
		this.transactionQueue = transactions;
	}

	public void setTransactionHistory(TransactionHistory transactions) {
		this.transactionHistory = transactions;
	}

	public void printAllBooks() {
		ArrayList<Book> books = this.books.getAllBooks();
		StringBuilder booksString = new StringBuilder("Books:\n");
		for (Book book : books) {
			booksString.append(book.getTitle()).append("\n");
		}
		System.out.println(booksString);
	}
	
	public void printAvailableBooks() {
		ArrayList<Book> availableBooks = this.books.getAvailableBooks();
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

	public void printUsers(ArrayList<User> users) {
		if (!users.isEmpty()) {
			for (User user : users) {
				System.out.println(user.toString());
			}
		} else {
			System.out.println("User not found!");
		}
	}
	
	public void printUserByID(int userID) {
		User user = this.users.findUserByID(userID);
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

	public ArrayList<User> getUsers(String name) {
		return users.findUser(name);
	}
	
	public User getUserByID(int userID) {
		return users.findUserByID(userID);
	}

	public void addNewBook(String title, Author author, String isbn, int physical_copies, int available_copies,
			int times_rented) {
		books.addBook(new Book(title, author, isbn, physical_copies, available_copies, times_rented));
	}

	public void addNewAuthor(String name) {
		authors.addAuthor(new Author(name));
	}
	
	public void registerUser(String name) {
		users.addUser(new User(name));
	}
	
	public void unregisterUser(int userID) {
		users.removeUser(users.findUserByID(userID));
	}
	
	public void rentBook(String title, int userID) {
		Book book = this.getBook(title);
		User user = this.getUserByID(userID);
		if (book != null && user != null) {
			if (book.rentPhysicalCopy()) {
				book.rentPhysicalCopy();
				Transaction bookRentalTransaction = new BookRental(book, new Date(), null, user.getUserID());
				this.transactionQueue.insertTransaction(bookRentalTransaction);
			}
		}
	}

	public void returnBook(String title, int userID) {
		Book book = this.getBook(title);
		User user = this.getUserByID(userID);
		if (book != null && user != null) {
			book.returnPhysicalCopy();
			Transaction bookReturnTransaction = new BookReturn(book, new Date(), null, user.getUserID());
			this.transactionQueue.insertTransaction(bookReturnTransaction);
		}
	}

	public void printPendingTransactions() {
		System.out.println(this.transactionQueue.toString());
	}

	public void executePendingTransactions() {
		if (this.transactionQueue.isEmpty()) {
			System.out.println("No Pending Transactions.");
		}
		while (!this.transactionQueue.isEmpty()) {
			Transaction firstTransaction = this.transactionQueue.getFirstInQueue();
			firstTransaction.setServedDate(new Date());
			this.transactionHistory.addTransactionToHistory(firstTransaction);
			this.transactionQueue.removeTransaction();
		}
	}
	
	public void printTransactionsHistory() {
		System.out.println(this.transactionHistory.toString());
	}
}
