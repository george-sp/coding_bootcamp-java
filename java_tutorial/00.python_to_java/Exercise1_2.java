import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a program that asks the user to provide different numbers of banknotes and coins, from €50 to €1.
 * Then output the total sum in euros.
 */
public class Exercise1_2 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Declare and initialize a sum.
        int sum = 0;
        // An array that contains different numbers of banknotes and coins.
        int[] euros = new int[]{50, 20, 10, 5, 2, 1};
        for (int euro : euros) {
            // Get a valid user input.
            while (true) {
                System.out.print(getPromptMessage(euro));
                try {
                    sum += euro * scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Give a valid input. Give a number.");
                    scanner.next();
                }
            }
        }
        // Print the sum of euros.
        System.out.printf("You have %d euros.", sum);
        scanner.close();
    }

    /**
     * Constructs the appropriate message according to the number of euros.
     */
    private static String getPromptMessage(int euro) {
        // Declare a string to prompt the user.
        String prompt_message;
        // Format the prompt_message.
        prompt_message = String.format("Enter number of %d euro ", euro);
        if (euro <= 2) {
            prompt_message += "coins: ";
        } else {
            prompt_message += "banknotes: ";
        }
        return prompt_message;
    }
}