import java.util.Scanner;

/**
 * An Information System for an insurance company with the following functionality:
 * 1. Prints all stored insurances (life and health).
 * 2. Prints all stored insurances (life and health) for a given customer.
 * 3. Prints details and type of for a given insurance.
 */
public class InsuranceOffice {

    private static final String SET_PLAIN_TEXT = "\033[0;0m";
    private static final String SET_BOLD_TEXT = "\033[0;1m";
    private static final String MENU = SET_BOLD_TEXT + "\t***** Menu *****" + SET_PLAIN_TEXT +
                                       "\n1. Print all Insurances" +
                                       "\n2. Search insurances by customer code" +
                                       "\n3. Search insurances by insurance code";;
    private static final String PROMPT_USER = SET_BOLD_TEXT + "> " + SET_PLAIN_TEXT;

    public static void main(String[] args) {
        // A simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // user input
        String userInput;
        int userOption;

        do {
            do {
                // Print the menu and prompt the user.
                System.out.println(MENU);
                System.out.print(PROMPT_USER);
                // Get input from user.
                userInput = scanner.nextLine();
            } while (! (isSingleChar(userInput) && isAnOption(userInput)));
            // Convert user input to the appropriate int.
            userOption = Integer.parseInt(userInput);

            System.out.println("This is a valid option.");
        } while (!isExitChar(userInput));

        // Close the scanner
        scanner.close();
    }

    /**
     * Checks if string input is an option value [0,3].
     * Returns true if it is, otherwise false.
     */
    private static boolean isAnOption(String input) {
        return true ? input.matches("[0-3]+") : false;
    }

    /**
     * Checks if the given string is a single character.
     * Returns true if it is, otherwise false.
     */
    private static boolean isSingleChar(String input) {
        return true ? input.length()==1 : false;
    }

    /**
     * Checks if the user input is the exit character "0".
     * If it is return true, else false.
     */
    private static boolean isExitChar(String input) {
        return true ? input.equals("0") : false;
    }
}