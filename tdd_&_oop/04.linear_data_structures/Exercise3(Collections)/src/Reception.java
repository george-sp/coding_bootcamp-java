import java.util.Scanner;

public class Reception {
	
	static final String LIBRARY_SYSTEM_MENU = "\n=====> LIBRARY_MENU\n"
			+ "1. Print all Books\n"
			+ "2. Print all Available Books\n"
			+ "3. Books\n"
			+ "4. Users\n"
			+ "5. Authors\n"
			+ "6. Transactions";
	static final String BOOK_MENU = "\n=====> LIBRARY_MENU / BOOK_MENU\n"
			+ "1. Search by book title\n"
			+ "2. Search by author name\n"
			+ "3. Add a New Book";
	static final String USER_MENU = "\n=====> LIBRARY_MENU / USER_MENU \n"
			+ "1. Search by name\n"
			+ "2. Search by ID\n"
			+ "3. Register User\n"
			+ "4. Unregister User";
	static final String AUTHOR_MENU = "\n=====> LIBRARY_MENU / AUTHOR_MENU \n"
			+ "1. Search by name\n"
			+ "2. Add a New Author\n";
	static final String TRANSACTION_MENU = "\n=====> LIBRARY_MENU / TRANSACTION_MENU \n"
			+ "1. Rent a Book\n"
			+ "2. Return a Book\n"
			+ "3. Print Transactions Queue\n"
			+ "4. Print Transactions History\n"
			+ "5. Execute Pending Transactions";
	private static final String PROMPT_USER = "> ";
	private static final String PROMPT_USER_FOR_BOOK_TITLE = "Give a Book Title\n> ";
	private static final String PROMPT_USER_FOR_BOOK_ISBN = "Give Book ISBN\n> ";
	private static final String PROMPT_USER_FOR_PHYSICAL_COPIES = "Give number of Physical Copies\n> ";
	private static final String PROMPT_USER_FOR_AUTHOR_NAME = "Give an Author Name\n> ";
	private static final String PROMPT_USER_FOR_USER_NAME = "Give a User Name\n> ";
	private static final String PROMPT_USER_FOR_USER_ID = "Give a User ID\n> ";
	private static final String PROMPT_USER_FOR_NEW_USER = "REGISTER: Enter User Name:\n> ";
	
	private static final String OPERATION_EXECUTED = "Operation Executed";
	
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
            		System.out.println(BOOK_MENU);
            		System.out.print(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isBookMenuOption(userInput));
            	executeBookMenuOption(Integer.parseInt(userInput));
            	break;
            // Operate on Users.
            case 4:
            	do {
            		System.out.println(USER_MENU);
            		System.out.print(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isUserMenuOption(userInput));
            	executeUserMenuOption(Integer.parseInt(userInput));
            	break;
            // Operate on Authors.
            case 5:
            	do {
            		System.out.println(AUTHOR_MENU);
            		System.out.println(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isAuthorMenuOption(userInput));
            	executeAuthorMenuOption(Integer.parseInt(userInput));
            	break;
            // Operate on Transactions.
            case 6:
            	do {
            		System.out.println(TRANSACTION_MENU);
            		System.out.print(PROMPT_USER);
            		userInput = scanner.nextLine();
            	} while (!isTransactionMenuOption(userInput));
            	executeTransactionMenuOption(Integer.parseInt(userInput));
            	break;
        }
    }
	
    /**
     * Executes the selected option of Search Book Menu.
     */
    private static void executeBookMenuOption(int option) {
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
            // Add a new Book.
            case 3:
            	String bookTitle, authorName, isbn, physicalCopies;
            	do {
            		System.out.println(PROMPT_USER_FOR_BOOK_TITLE);
            		bookTitle = scanner.nextLine();
            		System.out.println(PROMPT_USER_FOR_AUTHOR_NAME);
            		authorName = scanner.nextLine();
            		System.out.println(PROMPT_USER_FOR_BOOK_ISBN);
            		isbn = scanner.nextLine();
            		System.out.println(PROMPT_USER_FOR_PHYSICAL_COPIES);
            		physicalCopies = scanner.nextLine();
            	} while (! (isAlphabetical(authorName) && isAlphabetical(authorName) && isISBN(isbn) && isNumeric(physicalCopies)));
            	admin.addNewBookToLibrary(bookTitle, 
            							  admin.getAuthor(authorName),
            							  isbn, 
            							  Integer.parseInt(physicalCopies),
            							  Integer.parseInt(physicalCopies),
            							  0);
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
            // Register User.
            case 3:
            	do {
            		System.out.println(PROMPT_USER_FOR_NEW_USER);
            		input = scanner.nextLine();
            	} while (!isAlphabetical(input));
                admin.registerUser(input);
                System.out.println(OPERATION_EXECUTED);
                break;
            // Unregister User.
            case 4:
            	do {
            		System.out.println(PROMPT_USER_FOR_USER_ID);
            		input = scanner.nextLine();
            	} while (!isNumeric(input));
                admin.unregisterUser(Integer.parseInt(input));
                System.out.println(OPERATION_EXECUTED);
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
    private static void executeAuthorMenuOption(int option) {
    	String input;
        switch (option) {
        	// Search by name.																																																																																																																																																																																																											
            case 1:
        		System.out.println(PROMPT_USER_FOR_AUTHOR_NAME);
            	admin.findMeAuthor(admin.getAuthor(scanner.nextLine()));
                break;
            // Add an Author. 
            case 2:
            	do {
            		System.out.println(PROMPT_USER_FOR_AUTHOR_NAME);
                    input = scanner.nextLine();
            	} while (!isAlphabetical(input));
            	admin.addNewAuthor(input);
                break;
            case 0:
            	userInput = "";
            	break;
        }
    }
    
    /**
     * Executes the selected option of Transaction Menu.
     */
    private static void executeTransactionMenuOption(int option) {
    	String bookTitle, userID;
        switch (option) {
        	// Rent a Book.																																																																																																																																																																																																											
            case 1:
            	do {
            		System.out.println(PROMPT_USER_FOR_BOOK_TITLE);
                	bookTitle = scanner.nextLine();
                	System.out.println(PROMPT_USER_FOR_USER_ID);
                	userID = scanner.nextLine();
            	} while (!isNumeric(userID));
            	admin.rentBook(bookTitle, Integer.parseInt(userID));
            	break;
             // Return a Book. 
            case 2:
            	do {
            		System.out.println(PROMPT_USER_FOR_BOOK_TITLE);
                	bookTitle = scanner.nextLine();
                	System.out.println(PROMPT_USER_FOR_USER_ID);
                	userID = scanner.nextLine();
            	} while (!isNumeric(userID));
            	admin.returnBook(bookTitle, Integer.parseInt(userID));
            	break;
            // Print the Transactions Queue.
            case 3:
            	admin.printPendingTransactions();
                break;
            // Print the Transactions History.
            case 4:
            	admin.printTransactionsHistory();
            	break;
            // Execute the next Transaction.
            case 5:
            	admin.executePendingTransactions();
            	break;
            // Go to previous menu.
            case 0:
            	userInput = "";
            	break;
        }
    }
    
    private static boolean isMainMenuOption(String input) {
        return input.matches("[0-6]+");
    }
    
    private static boolean isBookMenuOption(String input) {
        return input.matches("[0-3]+");
    }
    
    private static boolean isUserMenuOption(String input) {
        return input.matches("[0-4]+");
    }
    
    private static boolean isAuthorMenuOption(String input) {
        return input.matches("[0-2]+");
    }
    
    private static boolean isTransactionMenuOption(String input) {
        return input.matches("[0-5]+");
    }
    
    private static boolean isExitChar(String input) {
        return input.equals("0");
    }
    
    private static boolean isNumeric(String input) {
    	return input.matches("\\d+");
    }
    
    private static boolean isAlphabetical(String input) {
        return input.matches("[a-zA-z -]+");
    }
    
    private static boolean isISBN(String input) {
    	return input.matches("[0-9,-]+");
    }
}
