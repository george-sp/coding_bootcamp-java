import java.util.Scanner;

public class Reception {
	
	static final String LIBRARY_SYSTEM_MENU = "=====> LIBRARY_MENU <=====\n"
			+ "1. Print all Books\n"
			+ "2. Print all Available Books\n"
			+ "3. Search Book";
	static final String SEARCH_BOOK_MENU = "=====> SEARCH_BOOK_MENU <=====\n"
			+ "1. Search by book title\n"
			+ "2. Search by author name";
	private static final String PROMPT_USER = "> ";
	private static final String PROMPT_USER_FOR_BOOK_TITLE = "Give a Book Title\n> ";
	private static final String PROMPT_USER_FOR_AUTHOR_NAME = "Give an Author Name\n> ";
	
	private static Scanner scanner;
	private static String userInput;
	private static Librarian admin;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		admin = new Librarian(Tester.initLibrary());
		
		do {
			do {
			// Print the menu and prompt the user.
            System.out.println(LIBRARY_SYSTEM_MENU);
            System.out.print(PROMPT_USER);
            // Get input from user.
            userInput = scanner.nextLine();
			} while (!isMainMenuOption(userInput));
			// Execute the selected option.
			executeMainMenuOption(Integer.parseInt(userInput));
		}while (!isExitChar(userInput));
		
		System.out.println("----------------------------------------------");
		if (scanner != null) {
			scanner.close();
		}
	}
	
	/**
     * Executes the selected option.
     */
    private static void executeMainMenuOption(int option) {
        switch (option) {
            case 1:
            	admin.findMeAllBooks();
                break;
            case 2:
                admin.findMeAvailableBooks();
                break;
            case 3:
            	do {
            		System.out.println(SEARCH_BOOK_MENU);
            		System.out.print(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isSearchOption(userInput));
            	executeSearchBookOption(Integer.parseInt(userInput));
            	break;
        }
    }
	
    /**
     * Executes the selected option.
     */
    private static void executeSearchBookOption(int option) {
        switch (option) {
            case 1:
        		System.out.println(PROMPT_USER_FOR_BOOK_TITLE);
            	admin.findMeBook(scanner.nextLine());
                break;
            case 2:
        		System.out.println(PROMPT_USER_FOR_AUTHOR_NAME);
                admin.findMeBooksFromAuthor(scanner.nextLine());
                break;
            case 0:
            	userInput = "";
            	break;
        }
    }
    
	/**
     * Checks if string input is an option value [0,3].
     * Returns true if it is, otherwise false.
     */
    private static boolean isMainMenuOption(String input) {
        return true ? input.matches("[0-3]+") : false;
    }
    
    /**
     * Checks if string input is an option value [0,2] - Search Options.
     * Returns true if it is, otherwise false.
     */
    private static boolean isSearchOption(String input) {
        return true ? input.matches("[0-2]+") : false;
    }
    
    /**
     * Checks if the user input is the exit character "0".
     * If it is return true, else false.
     */
    private static boolean isExitChar(String input) {
        return true ? input.equals("0") : false;
    }
    
    /**
     * Checks if string input is a numeric value.
     * Returns true if it is, else returns false.
     */
    private static boolean isNumeric(String input) {
        if (! input.matches("[0-9]+")) return false;
        return true;
    }
    
    /**
     * Checks if string input is an alphabetical value.
     * Returns true if it is an alphabetical value, else returns false.
     */
    private static boolean isAlphabetical(String input) {
        if (input.matches("[0-9]+")) return false;
        return true;
    }
}
