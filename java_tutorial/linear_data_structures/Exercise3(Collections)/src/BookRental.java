import java.util.Date;

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

	BookRental(Book book, Date requestedDate, Date servedDate, int userID) {
		super(book, requestedDate, servedDate, userID);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Book Rental-").append(super.toString());
		return stringBuilder.toString();
	}
}
