import java.util.Date;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Welcome to the Library!");

		/** Create Random authors */
		Author ruth = new Author("Ruth");
		Author diane = new Author("Diane");
		Author jacqueline = new Author("Jacqueline");
		Author rachel = new Author("Rachel");
		Author joan = new Author("Joan");
		Author theresa = new Author("Theresa");
		Author angela = new Author("Angela");
		Author helen = new Author("Helen");
		Author lisa = new Author("Lisa");
		Author[] authorsArray = { ruth, diane, jacqueline, rachel, joan, theresa, angela, helen, lisa };
		AuthorList authors = new AuthorList(authorsArray);

		// Add an author named George.
		authors.addAuthor(new Author("George"));
		// Remove Theresa from authors.
		authors.removeAuthor(authors.findAuthor("Theresa"));
		// Find Angela in authors.
		System.out.println(authors.findAuthor("Angela").toString());
		// Print the number of authors.
		authors.printSize();
		System.out.println(authors.toString());

		/** Create Random books from the above authors */
		Book book1 = new Book("Book1", ruth, "368777540-2", 10, 2, 20);
		Book book2 = new Book("Book2", diane, "963099898-2", 10, 1, 22);
		Book book3 = new Book("Book3", jacqueline, "005382097-2", 10, 0, 23);
		Book book4 = new Book("Book4", rachel, "538310208-2", 10, 3, 24);
		Book book5 = new Book("Book5", joan, "562448132-2", 10, 4, 26);
		Book book6 = new Book("Book6", theresa, "670364563-2", 10, 2, 21);
		Book book7 = new Book("Book7", angela, "466916869-2", 10, 5, 17);
		Book book8 = new Book("Book8", helen, "764674973-2", 10, 0, 15);
		Book book9 = new Book("Book9", lisa, "052469721-2", 10, 6, 17);
		Book book10 = new Book("Book10", ruth, "609291817-2", 10, 3, 13);
		Book book11 = new Book("Book11", diane, "451378028-2", 10, 8, 12);
		Book book12 = new Book("Book12", jacqueline, "142352773-2", 10, 6, 20);
		Book book13 = new Book("Book13", rachel, "115135166-2", 10, 0, 20);
		Book book14 = new Book("Book14", joan, "631942468-2", 10, 3, 20);
		Book book15 = new Book("Book15", theresa, "323662444-2", 10, 0, 23);
		Book book16 = new Book("Book16", angela, "121360492-2", 10, 0, 12);
		Book book17 = new Book("Book17", helen, "391199302-2", 10, 0, 20);
		Book book18 = new Book("Book18", ruth, "549307784-2", 10, 1, 20);
		Book book19 = new Book("Book19", ruth, "368777230-2", 10, 23, 20);
		Book book20 = new Book("Book20", ruth, "793027213-2", 10, 0, 20);
		/** Add the books to a Book array */
		Book[] booksArray = { book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12,
				book13, book14, book15, book16, book17, book18, book19, book20 };
		BookList books = new BookList(booksArray);
		// Add two more Books to the books BookList.
		books.addBook(new Book("Book21", authors.findAuthor("George"), "345434245-5", 10, 0, 5));
		books.addBook(new Book("Book22", authors.findAuthor("George"), "345434245-5", 10, 0, 5));
		// Remove a Book from the BookList.
		books.removeBook(book20);
		// Print number of stored books.
		books.printSize();
		// Find a book in the BookList.
		if (books.has("Book22"))
			System.out.println(books.findBook("Book22").toString());
		System.out.println(books.toString());

		/* Assign the book collection to the library */
		Library library = new Library(books, authors);
		/**
		 * Librarian the_guy_who _knows_a_lot undertakes the operation of the
		 * library
		 */
		Librarian the_guy = new Librarian(library);

		/* Testing if the initialization of Library works correctly! */
		the_guy.findMeAvailableBooks();
		the_guy.findMeBook("Book13");
		the_guy.findMeBooksFromAuthor("Ruth");
		the_guy.findMeAuthor(the_guy.getAuthor("Joan"));
		the_guy.findMeAuthor(the_guy.getAuthor("Joand"));
		the_guy.addNewBookToLibrary("Book23", authors.findAuthor("George"), "345434111-1", 4, 3, 0);

		if (books.has("Book23"))
			System.out.println(books.findBook("Book23").toString());

		/** Create Random users */
		User user1 = new User("George");
		User user2 = new User("John");
		User user3 = new User("George-Jason");
		User user4 = new User("Dimitris");
		User user5 = new User("Olga");
		UserList users = new UserList();
		users.addUser(user1);
		users.addUser(user2);
		users.addUser(user3);
		users.removeUser(user3);
		users.addUser(user4);
		
		library.setUserList(users);
		
		the_guy.findMeUser(the_guy.getUser("George"));
		the_guy.findMeUser(the_guy.getUser("Johny"));
		
		the_guy.rentBook("Book23", "George");
		the_guy.rentBook("Book3", "George");
		the_guy.rentBook("Book14", "George-Jason");
		the_guy.returnBook("Book3", "George");
	}
}
