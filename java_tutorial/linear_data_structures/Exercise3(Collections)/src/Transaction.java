
/**
 * Stores information related to the renting and returning a book operations.
 * @author george
 *
 */
public class Transaction {
	
	/* Fields */
	// The book for which the transaction is being performed.
	private Book book;
	// The date of requesting the current transaction.
	private String requestedDate;
	// The date of serving of the current transaction.
	private String servedDate;
	// The user id of the library member requesting or return the book.
	private int userID;
	// A global counter that keeps the counter (auto increment).
	private static int transactionsCounter;
	// A unique identifier that takes the current count value.
	private final int TRANSACTION_ID;
	
	/* Constructors */
	public Transaction() {
		transactionsCounter++;
		this.TRANSACTION_ID = transactionsCounter;
	}
	
	public Transaction(Book book, String requestedDate, String servedDate, int userID) {
		this();
		this.book = book;
		this.requestedDate = requestedDate;
		this.servedDate = servedDate;
		this.userID = userID;
	}
	
	/* Setters & Getters */
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Book getBook() {
		return this.book;
	}
	
	public void setRequestedDate(String date) {
		this.requestedDate = date;
	}
	
	public String getRequestedDate() {
		return this.requestedDate;
	}
	
	public void setServedDate(String date) {
		this.servedDate = date;
	}
	
	public String getServedDate() {
		return this.servedDate;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public void setTransactionsCounter(int counter) {
		transactionsCounter = counter;
	}
	
	public int getTransactionsCounter() {
		return transactionsCounter;
	}
	
	public String toString() {
		return "Transaction \"" + this.book.getTitle() + "\"\n" + "\ttransaction ID: " + this.TRANSACTION_ID 
				+ "\n" + "\tdate of request: " + this.requestedDate + "\n"
				+ "\tdate of serve: " + this.servedDate + "\n"
				+ "\n" + "\tfrom user: " + this.userID + "\n";
	}
}
