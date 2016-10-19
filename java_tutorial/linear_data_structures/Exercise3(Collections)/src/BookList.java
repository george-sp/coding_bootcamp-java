import java.util.ArrayList;

/**
 * Represents a List data structure that stores Book objects.
 * 
 * @author george
 *
 */
public class BookList {

	/* Fields */
	private Book firstBook;

	/* Constructors */
	public BookList() {
		this.firstBook = null;
	}

	public BookList(Book[] books) {
		this();
		for (Book book : books) {
			this.addBook(book);
		}
	}

	/* Setters & Getters */
	public void setFirstBook(Book book) {
		this.firstBook = book;
	}

	public Book getFirstBook() {
		return this.firstBook;
	}

	/**
	 * Adds a book to the BookList
	 * 
	 * @param book
	 *            The Book object to be added.
	 */
	public void addBook(Book book) {
		if (this.firstBook == null) {
			this.firstBook = book;
		} else {
			Book currentBook = this.firstBook;
			while (currentBook.getNext() != null) {
				currentBook = currentBook.getNext();
			}
			currentBook.setNext(book);
		}
	}

	public void removeBook(Book book) {
		if (this.firstBook == null) {
			System.out.println("Cannot remove a not found book.");
		} else {
			if (this.firstBook == book) {
				firstBook = (firstBook.getNext() != null) ? firstBook.getNext() : null;
			}
			Book previousBook;
			Book currentBook = this.firstBook;
			while (currentBook.getNext() != null) {
				previousBook = currentBook;
				currentBook = currentBook.getNext();
				if (currentBook == book) {
					previousBook.setNext((currentBook.getNext() != null) ? currentBook.getNext() : null);
					return;
				}
			}
		}
		System.out.println("Cannot remove a not found book!");
	}

	/**
	 * Checks if the BookList contains the given book.
	 * 
	 * @param book
	 *            The book to check if it is in the BookList.
	 * @return The book with the specified title.
	 */
	public Book findBook(String title) {
		if (this.firstBook != null) {
			if (firstBook.getTitle().equals(title)) {
				return firstBook;
			}
			Book currentBook = this.firstBook;
			while (currentBook.getNext() != null) {
				currentBook = currentBook.getNext();
				if (currentBook.getTitle().equals(title)) {
					return currentBook;
				}
			}
		}
		return null;
	}

	/**
	 * Searches if book exists
	 */
	public boolean has(String title) {
		if (this.firstBook != null) {
			if (firstBook.getTitle().equals(title)) {
				return true;
			}
			Book currentBook = this.firstBook;
			while (currentBook.getNext() != null) {
				currentBook = currentBook.getNext();
				if (currentBook.getTitle().equals(title)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns the available books.
	 */
	public ArrayList<Book> getAvailableBooks() {
		ArrayList<Book> availableBooks = new ArrayList<>();
		if (this.firstBook != null) {
			if (firstBook.isAvailable()) {
				availableBooks.add(firstBook);
			}
			Book currentBook = this.firstBook;
			while (currentBook.getNext() != null) {
				currentBook = currentBook.getNext();
				if (currentBook.isAvailable()) {
					availableBooks.add(currentBook);
				}
			}
		}
		return availableBooks;
	}
	
	/**
	 * Returns all books.
	 */
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> availableBooks = new ArrayList<>();
		if (this.firstBook != null) {
			Book currentBook = this.firstBook;
			availableBooks.add(firstBook);
			while (currentBook.getNext() != null) {
				currentBook = currentBook.getNext();
				availableBooks.add(currentBook);
			}
		}
		return availableBooks;
	}

	public void printSize() {
		int booksCounter = 0;
		if (this.firstBook != null) {
			Book currentBook = this.firstBook;
			booksCounter++;
			while (currentBook.getNext() != null) {
				booksCounter++;
				currentBook = currentBook.getNext();
			}
		}
		System.out.println("Number of stored books: " + booksCounter);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (this.firstBook != null) {
			Book currentBook = this.firstBook;
			stringBuilder.append(firstBook.toString());
			while (currentBook.getNext() != null) {
				currentBook = currentBook.getNext();
				stringBuilder.append(currentBook.toString());
			}
		}
		return stringBuilder.toString();
	}
}
