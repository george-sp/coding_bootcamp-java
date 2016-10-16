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
        // Arrays to store Customers, Insurances, Lifes, Healths
        Customer[] customersArray = new Customer[10];
        Insurance[] insurancesArray = new Insurance[10];
        Life[] lifesArray = new Life[10];
        Health[] healthsArray = new Health[10];

        generateDummyValues(customersArray, insurancesArray, lifesArray, healthsArray);

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

    private static void generateDummyValues(Customer[] customersArray,
                                            Insurance[] insurancesArray,
                                            Life[] lifesArray,
                                            Health[] healthsArray) {
        // Dummy Customers
        Customer c1 = new Customer("George", 1991, true);
        Customer c2 = new Customer("Spyridakis", 1990, true);
        Customer c3 = new Customer("Panagiotis", 1989, true);
        Customer c4 = new Customer("Dimitris", 1988, true);
        Customer c5 = new Customer("Panos", 1987, true);
        Customer c6 = new Customer("Sofia", 1986, false);
        Customer c7 = new Customer("Maria", 1985, false);
        Customer c8 = new Customer("Konstantina", 1984, false);
        Customer c9 = new Customer("Angela", 1983, false);
        Customer c10 = new Customer("Kostantinos", 1982, true);
        // Dummy Insurances
        Insurance i1 = new Insurance(c1.getCustomerCode(), 7);
        Insurance i2 = new Insurance(c2.getCustomerCode(), 6);
        Insurance i3 = new Insurance(c3.getCustomerCode(), 5);
        Insurance i4 = new Insurance(c4.getCustomerCode(), 4);
        Insurance i5 = new Insurance(c5.getCustomerCode(), 3);
        Insurance i6 = new Insurance(c6.getCustomerCode(), 2);
        Insurance i7 = new Insurance(c7.getCustomerCode(), 1);
        // Dummy Lifes
        Life l1 = new Life(c1.getCustomerCode(), 1, 20000);
        Life l2 = new Life(c2.getCustomerCode(), 2, 3000);
        Life l3 = new Life(c3.getCustomerCode(), 3, 420000);
        Life l4 = new Life(c4.getCustomerCode(), 4, 200400);
        Life l5 = new Life(c5.getCustomerCode(), 5, 2004);
        Life l6 = new Life(c6.getCustomerCode(), 10, 50000);
        Life l7 = new Life(c7.getCustomerCode(), 9, 670000);
        Life l8 = new Life(c8.getCustomerCode(), 8, 120);
        Life l9 = new Life(c9.getCustomerCode(), 7, 34200);
        Life l10 = new Life(c10.getCustomerCode(), 6, 22002);
        // Dummy Healths
        Health h1 = new Health(c6.getCustomerCode(), 5, 193000);
        Health h2 = new Health(c1.getCustomerCode(), 4, 900);
        Health h3 = new Health(c2.getCustomerCode(), 14, 500);
        Health h4 = new Health(c1.getCustomerCode(), 21, 3000);
        Health h5 = new Health(c3.getCustomerCode(), 11, 5000);
        Health h6 = new Health(c9.getCustomerCode(), 1, 53000);
        Health h7 = new Health(c10.getCustomerCode(), 7, 30005);
        Health h8 = new Health(c7.getCustomerCode(), 9, 30400);
    }
}