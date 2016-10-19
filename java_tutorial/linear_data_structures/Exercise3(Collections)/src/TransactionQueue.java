import java.util.ArrayList;

/**
 * Serves as a data structure for storing Transactions that have been validated
 * but not yet executed.
 * 
 * @author george
 *
 */
public class TransactionQueue {

	/* Fields */
	private ArrayList<Transaction> transactions;

	/* Constructors */
	public TransactionQueue() {
		this.transactions = new ArrayList<>();
	}

	public TransactionQueue(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	/* Setters & Getters */
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

	public void insertTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	public void removeTransaction() {
		this.transactions.remove(0);
	}
	
	public boolean isEmpty() {
		return this.transactions.isEmpty();
	}
	
	public Transaction getFirstInQueue() {
		return this.transactions.get(0);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (!this.isEmpty()) {
			int transactionsCounter = 1;
			for (Transaction transaction : transactions) {
				stringBuilder.append(transactionsCounter)
							 .append(". ")
							 .append(transaction.toString())
							 .append("\n");
				transactionsCounter++;
			}
		} else {
			stringBuilder.append("The Transaction Queue is empty.");
		}
		return stringBuilder.toString();
	}
}
