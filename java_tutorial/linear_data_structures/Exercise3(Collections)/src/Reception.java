import java.util.Scanner;

public class Reception {
	
	static final String LIBRARY_SYSTEM_MENU = "\n=====> LIBRARY_MENU\n"
			+ "1. Print all Books\n"
			+ "2. Print all Available Books\n"
			+ "3. Search Book\n"
			+ "4. Users";
	static final String SEARCH_BOOK_MENU = "\n=====> LIBRARY_MENU / SEARCH_BOOK_MENU\n"
			+ "1. Search by book title\n"
			+ "2. Search by author name";
	static final String SEARCH_USER_MENU = "\n=====> LIBRARY_MENU / USER_MENU \n"
			+ "1. Search by name\n"
			+ "2. Search by ID\n"
			+ "3. Register User\n"
			+ "4. Unregister User";
	private static final String PROMPT_USER = "> ";
	private static final String PROMPT_USER_FOR_BOOK_TITLE = "Give a Book Title\n> ";
	private static final String PROMPT_USER_FOR_AUTHOR_NAME = "Give an Author Name\n> ";
	private static final String PROMPT_USER_FOR_USER_NAME = "Give a User Name\n> ";
	private static final String PROMPT_USER_FOR_USER_ID = "Give a User ID\n> ";
	private static final String PROMPT_USER_FOR_NEW_USER = "REGISTER\n> ";
	
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
     * Executes the selected option of Main Menu of Library.
     */
    private static void executeMainMenuOption(int option) {
        switch (option) {
        	// Print all Books.
            case 1:
            	admin.findMeAllBooks();
                break;
            // Print all Available Books.
            case 2:
                admin.findMeAvailableBooks();
                break;
            // Search Book.
            case 3:
            	do {
            		System.out.println(SEARCH_BOOK_MENU);
            		System.out.print(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isSearchBookOption(userInput));
            	executeSearchBookOption(Integer.parseInt(userInput));
            	break;
            // Operate on Users.
            case 4:
            	do {
            		System.out.println(SEARCH_USER_MENU);
            		System.out.print(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isSearchUserOption(userInput));
            	executeUserMenuOption(Integer.parseInt(userInput));
            	break;
        }
    }
	
    /**
     * Executes the selected option of Search Book Menu.
     */
    private static void executeSearchBookOption(int option) {
        switch (option) {
        	// Search by book title.
            case 1:
        		System.out.println(PROMPT_USER_FOR_BOOK_TITLE);
            	admin.findMeBook(scanner.nextLine());
                break;
            // Search by author name.
            case 2:
        		System.out.println(PROMPT_USER_FOR_AUTHOR_NAME);
                admin.findMeBooksFromAuthor(scanner.nextLine());
                break;
            // Go to previous menu.
            case 0:
            	userInput = "";
            	break;
        }
    }
    
    /**
     * Executes the selected option of User Menu.
     */
    private static void executeUserMenuOption(int option) {
    	String input;
        switch (option) {
        	// Search by name.																																																																																																																																																																																																											
            case 1:
        		System.out.println(PROMPT_USER_FOR_USER_NAME);
            	admin.findMeUsersByName(admin.getUsers(scanner.nextLine()));
                break;
            // Search by ID. 
            case 2:
            	do {
            		System.out.println(PROMPT_USER_FOR_USER_ID);
                    input = scanner.nextLine();
            	} while (!isNumeric(input));
            	admin.findMeUserByID(Integer.parseInt(input));        		
                break;
            // Add User.
            case 3:
            	do {
            		System.out.println(PROMPT_USER_FOR_NEW_USER);
            		input = scanner.nextLine();
            	} while (!isAlphabetical(input));
                admin.registerUser(input);
                break;
            // Remove User.
            case 4:
        		System.out.println(PROMPT_USER_FOR_AUTHOR_NAME);
                admin.findMeBooksFromAuthor(scanner.nextLine());
                break;
            // Go to previous menu.
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
        return input.matches("[0-4]+");
    }
    
    /**
     * Checks if string input is an option value [0,2] - Search Book Available Options.
     * Returns true if it is, otherwise false.
     */
    private static boolean isSearchBookOption(String input) {
        return input.matches("[0-2]+");
    }
    
    /**
     * Checks if string input is an option value [0,4] - Search User Available Options.
     * Returns true if it is, otherwise false.
     */
    private static boolean isSearchUserOption(String input) {
        return input.matches("[0-4]+");
    }
    
    /**
     * Checks if the user input is the exit character "0".
     * If it is return true, else false.
     */
    private static boolean isExitChar(String input) {
        return input.equals("0");
    }
    
    /**
     * Checks if string input is a numeric value.
     * Returns true if it is, else returns false.
     */
    private static boolean isNumeric(String input) {
    	return input.matches("[\d]+");
    }
    
    /**
     * Checks if string input is an alphabetical value.
     * Returns true if it is an alphabetical value, else returns false.
     */
    private static boolean isAlphabetical(String input) {
        return input.matches("[a-zA-z -]+");
    }
}
