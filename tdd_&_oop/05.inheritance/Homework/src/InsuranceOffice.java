import java.util.Scanner;
import java.util.ArrayList;
/**
 * An Information System for an insurance company with the following functionality:
 * 1. Prints all stored insurances (life and health).
 * 2. Prints all stored insurances (life and health) for a given customer.
 * 3. Prints details and type of for a given insurance.
 */
public class InsuranceOffice {

    private static final String SET_PLAIN_TEXT = "\033[0;0m";
    private static final String SET_BOLD_TEXT = "\033[0;1m";
    private static final String MENU = "\n" + SET_BOLD_TEXT + "\t***** Menu *****" + SET_PLAIN_TEXT +
                                       "\n1. Print all Insurances" +
                                       "\n2. Search insurances by customer code" +
                                       "\n3. Search insurances by insurance code";
    private static final String PROMPT_USER = SET_BOLD_TEXT + "> " + SET_PLAIN_TEXT;
    // Arrays to store Customers, Insurances, Lifes, Healths
    protected static ArrayList<Customer> customers = new ArrayList<>();
    protected static ArrayList<Insurance> insurances = new ArrayList<>();

    public static void main(String[] args) {
        // A simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // user input
        String userInput;
        int userOption;
        // Generate some dummy values.
        generateDummyValues(customers, insurances);

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
            // Execute the selected option.
            executeOption(userOption, scanner);

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

    /**
     * Checks if string input is a numeric value.
     * Returns true if it is, else returns false.
     */
    private static boolean isNumeric(String input) {
        if (! input.matches("[0-9]+")) return false;
        return true;
    }

    /**
     * Uses a scanner object to get an Insurance Code from the user.
     */
    public static int getInsuranceCodeFromUser(Scanner scanner) {
        String input;
        do {
            System.out.print("Give an Insurance Code\n" + PROMPT_USER);
            input = scanner.nextLine();
        } while (!isNumeric(input));
        return Integer.parseInt(input);
    }

    /**
     * Uses a scanner object to get an Customer Code from the user.
     */
    public static int getCustomerCodeFromUser(Scanner scanner) {
        String input;
        do {
            System.out.print("Give a Customer Code\n" + PROMPT_USER);
            input = scanner.nextLine();
        } while (!isNumeric(input));
        return Integer.parseInt(input);
    }

    /**
     * Executes the selected option.
     */
    private static void executeOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                Insurance.printAllInsurances(insurances);
                break;
            case 2:
                int customerCode = getCustomerCodeFromUser(scanner);
                Insurance.printInsuranceByCustomerCode(insurances, customerCode);
                break;
            case 3:
                int insuranceCode = getInsuranceCodeFromUser(scanner);
                Insurance.printInsuranceByInsuranceCode(insurances, insuranceCode);
                break;
        }
    }

    private static void generateDummyValues(ArrayList<Customer> customers,
                                            ArrayList<Insurance> insurances) {
        // Dummy Customers
        Customer c1 = new Customer("George", 1991, true);
        customers.add(c1);
        Customer c2 = new Customer("Spyridakis", 1990, true);
        customers.add(c2);
        Customer c3 = new Customer("Panagiotis", 1989, true);
        customers.add(c3);
        Customer c4 = new Customer("Dimitris", 1988, true);
        customers.add(c4);
        Customer c5 = new Customer("Panos", 1987, true);
        customers.add(c5);
        Customer c6 = new Customer("Sofia", 1986, false);
        customers.add(c6);
        Customer c7 = new Customer("Maria", 1985, false);
        customers.add(c7);
        Customer c8 = new Customer("Konstantina", 1984, false);
        customers.add(c8);
        Customer c9 = new Customer("Angela", 1983, false);
        customers.add(c9);
        Customer c10 = new Customer("Kostantinos", 1982, true);
        customers.add(c10);
        // Dummy Insurances
        Insurance i1 = new Insurance(c1.getCustomerCode(), 7);
        insurances.add(i1);
        Insurance i2 = new Insurance(c2.getCustomerCode(), 6);
        insurances.add(i2);
        Insurance i3 = new Insurance(c3.getCustomerCode(), 5);
        insurances.add(i3);
        Insurance i4 = new Insurance(c4.getCustomerCode(), 4);
        insurances.add(i4);
        Insurance i5 = new Insurance(c5.getCustomerCode(), 3);
        insurances.add(i5);
        Insurance i6 = new Insurance(c6.getCustomerCode(), 2);
        insurances.add(i6);
        Insurance i7 = new Insurance(c7.getCustomerCode(), 1);
        insurances.add(i7);
        // Dummy Lifes
        Life l1 = new Life(c1.getCustomerCode(), 1, 20000);
        insurances.add(l1);
        Life l2 = new Life(c2.getCustomerCode(), 2, 3000);
        insurances.add(l2);
        Life l3 = new Life(c3.getCustomerCode(), 3, 420000);
        insurances.add(l3);
        Life l4 = new Life(c4.getCustomerCode(), 4, 200400);
        insurances.add(l4);
        Life l5 = new Life(c5.getCustomerCode(), 5, 2004);
        insurances.add(l5);
        Life l6 = new Life(c6.getCustomerCode(), 10, 50000);
        insurances.add(l6);
        Life l7 = new Life(c7.getCustomerCode(), 9, 670000);
        insurances.add(l7);
        Life l8 = new Life(c8.getCustomerCode(), 8, 120);
        insurances.add(l8);
        Life l9 = new Life(c9.getCustomerCode(), 7, 34200);
        insurances.add(l9);
        Life l10 = new Life(c10.getCustomerCode(), 6, 22002);
        insurances.add(l10);
        // Dummy Healths
        Health h1 = new Health(c6.getCustomerCode(), 5, 193000);
        insurances.add(h1);
        Health h2 = new Health(c1.getCustomerCode(), 4, 900);
        insurances.add(h2);
        Health h3 = new Health(c2.getCustomerCode(), 14, 500);
        insurances.add(h3);
        Health h4 = new Health(c1.getCustomerCode(), 21, 3000);
        insurances.add(h4);
        Health h5 = new Health(c3.getCustomerCode(), 11, 5000);
        insurances.add(h5);
        Health h6 = new Health(c9.getCustomerCode(), 1, 53000);
        insurances.add(h6);
        Health h7 = new Health(c10.getCustomerCode(), 7, 30005);
        insurances.add(h7);
        Health h8 = new Health(c7.getCustomerCode(), 9, 30400);
        insurances.add(h8);
    }
}