
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
		Author[] authorsarray = { ruth, diane, jacqueline, rachel, joan, theresa, angela, helen, lisa };
		AuthorList authors = new AuthorList(authorsarray);
		
		// Add an author named George.
		authors.addAuthor(new Author("George"));
		// Remove Theresa from authors.
		authors.removeAuthor(authors.findAuthor("Theresa"));
		// Find Angela in authors.
		System.out.println(authors.findAuthor("Angela").toString());
		// Print the number of authors.
		authors.printAuthors();
		System.out.println(authors.toString());
	}
}
