
/**
 * The transaction of renting a book.
 * 
 * @author george
 *
 */
public class BookRental extends Transaction {

	/* Constructor */
	BookRental() {
		super();
	}

	BookRental(Book book, String requestedDate, String servedDate, int userID) {
		super(book, requestedDate, servedDate, userID);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book rental ").append(super.toString());
		return stringBuilder.toString();
	}
}
