public class Library {
    // the books of the library
    private Book[] books;

    /**
     * Constructors
     */
    // Default Constructor
    public Library() {}

    public Library(Book[] books) {
        this.books = books;
    }

    /**
     * Setters & Getters
     */
    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return this.books;
    }

    /**
     * Checks the book collection and prints those that are available.
     */
    public void printAvailableBooks() {
        int availableBookCounter = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBookCounter++;
                System.out.println(availableBookCounter + " " + book.getTitle());
            }
        }
    }

    /**
     * Searches for a book based on a given title.
     * If the book exists then its details should be printed,
     * otherwise an error message should be displayed
     * @param bookTitle
     */
    public void printBookDetails(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                System.out.println(book.toString());
            }
        }
    }

    /**
     * Prints only the books that have an author that matches a given name.
     * @param authorName
     */
    public void printBookFromAuthor(String authorName) {
        for (Book book : books) {
            if (book.hasAuthor(authorName)) {
                System.out.println(book.toString());
            }
        }
    }
}
