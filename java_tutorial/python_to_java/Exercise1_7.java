import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a program that asks the user the number of pronic numbers to output,
 * then goes on and prints them.
 */
public class Exercise1_7 {
    public static void main(String[] args) {
        // Prompt user for the number of pronic numbers and store the input as an int.
        int numberOfPronicNumbers = getNumber();
        // Print out the pronic numbers.
        for (int i = 1; i <= numberOfPronicNumbers; i++) {
            System.out.print(i * (i  + 1) + " ");
        }
    }

    /**
     * Prompts user for a number.
     */
    public static int getNumber() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter number of pronic numbers: ");
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.next();
            }
        } while (true);
        // Close the scanner.
        scanner.close();
        return number;
    }
}