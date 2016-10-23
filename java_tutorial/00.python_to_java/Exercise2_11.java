import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The program asks the user for an upper limit and then prints out the polite
 * numbers up to and including the limit.
 * The program should not use logarithms.
 * The numbers should be written in rows of 10 (except possibly for the last line).
 * - The positive integer numbers that can be written as the sum of two or more
 *   consecutive positive integers are called polite numbers.
 * - The rest are called impolite numbers.
 * - It can be proven that the impolite numbers are the powers of 2.
 * - The first polite numbers are:
 *   3, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21,
 *   22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 34, 35, 36, 37,
 *   38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, ...
 */
public class Exercise2_11 {
    public static void main(String[] args) {
        // Get upper limit as a user input.
        int upperLimit = getUpperLimit();
        // Calculate the powers of 2.
        ArrayList<Integer> powersOf2 = getPowersOf2(upperLimit);
        // A counter for the numbers should be printed in each row.
        int numsInRow = 0;
        // Start counting from 3 to the upper limit.
        for (int i = 3; i <= upperLimit; i++) {
            // If it is a polite number print it.
            if (!powersOf2.contains(i)) {
                System.out.print(i + " ");
                if (numsInRow < 9) {
                    numsInRow++;
                } else {
                    numsInRow = 0;
                }
            }
            // If the counter for the number in row is reseted, println.
            if (numsInRow == 0) {
                System.out.println();
            }
        }
        // Print a new line before exit.
        System.out.println();
    }

    /**
     * Returns an ArrayList of ints with the powers of 2,
     * and takes the upper limit as an argument.
     */
    private static ArrayList<Integer> getPowersOf2(int limit) {
        // An ArrayList to store the powers of 2.
        ArrayList<Integer> powersOf2 = new ArrayList<> ();
        // Declare the power of two and an exponent.
        int powerOf2, exponent;
        // Initialize the exponent.
        exponent = 1;
        // Calculate the first power of 2.
        powerOf2 = 1;
        while (true) {
            // Calculate the power of 2.
            powerOf2 = (int) Math.pow(2, exponent);
            // Check if it is smaller than or equal to the limit.
            if (powerOf2 <= limit) {
                // If it is, store its value.
                powersOf2.add(powerOf2);
                // Increase the exponent by one.
                exponent++;
            } else {
                break;
            }
        }
        // Return all powers of 2 until the given limit.
        return powersOf2;
    }

    /**
     * Prompts user for an upper number limit.
     */
    private static int getUpperLimit() {
        // Declare and initialize a scanner.
        Scanner scanner = new Scanner(System.in);
        // Number from user input.
        int number;
        do {
            System.out.print("Enter limit: ");
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.next();
            }
        } while (true);
        return number;
    }
}