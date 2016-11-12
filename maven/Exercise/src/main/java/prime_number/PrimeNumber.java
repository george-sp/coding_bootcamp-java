package prime_number;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Takes a number as a command-line argument and prints whether that number is prime or not.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int num;

        // Get an integer from user
        try(Scanner scanner = new Scanner(System.in)){
            num = getNumber(scanner);
        }

        if (isPrime(num))
            System.out.println("The number " + num + " is prime.");
        else
            System.out.println("The number " + num + " is not prime.");
    }

    /**
     * Checks if the given number is prime or not.
     *
     * @return True if it is a prime, otherwise false
     * @param The number to be checked
     */
    private static boolean isPrime(int number) {
        for(int i = 2; i < number; i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Gets a number from user.
     *
     * @return The (integer)number given by user
     * @param The scanner object to read the user input
     */
    public static int getNumber(Scanner scanner) {
        int number;
        while (true) {
            // Prompt user to give a number
            System.out.print("Give a number: \n> ");
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