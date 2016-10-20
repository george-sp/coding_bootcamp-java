import java.util.Scanner;

public class Reception {
	
	static final String LIBRARY_SYSTEM_MENU = "=====> LIBRARY_MENU <=====\n"
			+ "1. Print all Books\n"
			+ "2. Print all Available Books";
	private static final String PROMPT_USER = "> ";
	private static Scanner scanner;
	
	private static Librarian admin;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		admin = new Librarian(Tester.initLibrary());
		
		String userInput;
		do {
			do {
			// Print the menu and prompt the user.
            System.out.println(LIBRARY_SYSTEM_MENU);
            System.out.print(PROMPT_USER);
            // Get input from user.
            userInput = scanner.nextLine();
			} while (!isAnOption(userInput));
			// Execute the selected option.
            executeOption(Integer.parseInt(userInput));
		}while (!isExitChar(userInput));
		
		if (scanner != null) {
			scanner.close();
		}
	}
	
	/**
     * Executes the selected option.
     */
    private static void executeOption(int option) {
        switch (option) {
            case 1:
            	admin.findMeAllBooks();;
                break;
            case 2:
                admin.findMeAvailableBooks();
                break;
        }
    }
	
	/**
     * Checks if string input is an option value [0,3].
     * Returns true if it is, otherwise false.
     */
    private static boolean isAnOption(String input) {
        return true ? input.matches("[0-3]+") : false;
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
}
