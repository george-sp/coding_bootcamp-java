import java.util.ArrayList;

/**
 * TransactionHistory represents a list data structure. This list should store
 * all executed Transactions in your system.
 * 
 * @author george
 *
 */
public class TransactionHistory {

	/* Fields */
	private ArrayList<Transaction> transactions = new ArrayList<>();

	/* Constructors */
	public TransactionHistory() {
		this.transactions = new ArrayList<>();
	}

	public TransactionHistory(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	/* Setters & Getters */
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}
	
	public void addTransactionToHistory(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	public void removeTransactionFromHistory(Transaction transaction) {
		this.transactions.remove(transaction);
	}
	
	/**
	 * Finds a transaction using a book title.
	 * 
	 * @param title
	 *            The title of book in the transaction
	 * @return An ArrayLlist with the transactions of the given book title
	 */
	public ArrayList<Transaction> findTransactionByBookTitle(String title) {
		ArrayList<Transaction> bookTransactions = new ArrayList<>();
		for (Transaction transaction : this.transactions) {
			if (transaction.getBook().getTitle().equals(title)) {
				bookTransactions.add(transaction);
			}
		}
		return bookTransactions;
	}

	/**
	 * Finds a transaction using a user ID.
	 * 
	 * @param userID
	 *            The ID of the user
	 * @return An ArrayLlist with the transactions of the user with this ID
	 */
	public ArrayList<Transaction> findTransactionByUserID(int userID) {
		ArrayList<Transaction> userTransactions = new ArrayList<>();
		for (Transaction transaction : this.transactions) {
			if (transaction.getUserID() == userID) {
				userTransactions.add(transaction);
			}
		}
		return userTransactions;
	}

	public void printSize() {
		if (!this.transactions.isEmpty()) {
			System.out.println("The number of transactions in history is: " + this.transactions.size());
		} else {
			System.out.println("No transactions history found");
		}
	}
	
	public boolean isEmpty() {
		return this.transactions.isEmpty();
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (!this.isEmpty()) {
			int transactionsInHistoryCounter = 1;
			for (Transaction transaction : this.transactions) {
				stringBuilder.append(transactionsInHistoryCounter)
							 .append(". ")
							 .append(transaction.toString())
							 .append("\n");
				transactionsInHistoryCounter++;
			}
		} else {
			stringBuilder.append("The Transaction History is empty.");	
		}
		return stringBuilder.toString();
	}

}
