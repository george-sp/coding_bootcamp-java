import java.util.Scanner;
import java.util.InputMismatchException;

/*
 * Write a program that asks the user the number of triangular numbers to produce,
 * and prints them out.
 */
public class Exercise1_6 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Get the number of triangular numbers to produce, from the user.
        int numberOfTriangleNumbers = getNumber(scanner);
        // Print out the produced triangular numbers.
        for (int i = 1; i <= numberOfTriangleNumbers; i++) {
            System.out.print((int) ((i * (i + 1)) / 2) + " ");
        }
        // Close the scanner object.
        scanner.close();
    }

    /**
     * Prompts user for a number.
     */
    public static int getNumber(Scanner scanner) {
        int number;
        while (true) {
            System.out.print("Enter number of triangle numbers: ");
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Give a number (integer).");
                scanner.next();
            }
        }
        return number;
    }
}