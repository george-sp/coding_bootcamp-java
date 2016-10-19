
/**
 * The transaction of returning a book.
 * 
 * @author george
 *
 */
public class BookReturn extends Transaction {

	/* Constructor */
	BookReturn() {
		super();
	}

	BookReturn(Book book, String requestedDate, String servedDate, int userID) {
		super(book, requestedDate, servedDate, userID);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book return ").append(super.toString());
		return stringBuilder.toString();
	}
}
