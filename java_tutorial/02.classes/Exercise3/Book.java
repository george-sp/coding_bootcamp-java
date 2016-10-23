public class Book {

    // book's title
    private String title;
    // book's author
    private Author author;
    // book's isbn: should not be changed after the initialization
    private final String ISBN;
    // physcial copies of the book
    private int physicalCopies;
    // available copies of the book
    private int availableCopies;
    // times the book was rented
    private int timesRented;

    /**
     * Constructors
     */
    // Default Constructors
    public Book() {
        this.ISBN = "0991221344";
    }

    // Full argument Constructor
    public Book(String title, Author author, String isbn, int physicalCopies,
                int availableCopies, int timesRented) {
        this.title = title;
        this.author = author;
        this.ISBN = isbn;
        this.physicalCopies = physicalCopies;
        this.availableCopies = availableCopies;
        this.timesRented = timesRented;
    }

    /**
     * Setters & Getters
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPhysicalCopies(int physicalCopies) {
        this.physicalCopies = physicalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setTimesRented(int timesRented) {
        this.timesRented = timesRented;
    }

    public String getTitle() {
        return this.title;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public int getPhysicalCopies() {
        return this.physicalCopies;
    }

    public int getAvailableCopies() {
        return this.availableCopies;
    }

    public int getTimesRented() {
        return this.timesRented;
    }

    /**
     * Returns the details of the book in printable way.
     */
    public String toString() {
        return "Title: " + getTitle() +
               "\nAuthor: " + getAuthor().getName() +
               "\nISBN: " + getISBN() +
               "\nPhysical copies: " + getPhysicalCopies() +
               "\nAvailable copies: " + getAvailableCopies() +
               "\nTimes rented: " + getTimesRented() +
               "\n-------------------------------------------------------";
    }

    /**
     * Checks if there is an available copy for renting.
     * If yes, then it prints a message of success.
     */
    public void rentPhysicalCopy() {
        if (isAvailable()) {
            this.availableCopies--;
            System.out.println("Book rented!");
        }
    }

    /**
     * Returns true when there is at least one available copy of the book, otherwise false.
     */
    public boolean isAvailable() {
        if (this.availableCopies >= 1) {
            return true;
        }
        return false;
    }

    /**
     * Returns true or false if the given name is the name of the book's author.
     */
    public boolean hasAuthor(String name) {
        if (this.author.getName().equals(name)) {
            return true;
        }
        return false;
    }
}