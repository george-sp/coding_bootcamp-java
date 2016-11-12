package prime_number;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Takes a number as a command-line argument and prints whether that number is prime or not.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int num;

        if (args.length > 0) {
            try {
                // Get an integer from user as a command-line argument
                num = Integer.parseInt(args[0]);
                // Print if it is prime or not
                if (isPrime(num))
                    System.out.println("The number " + num + " is prime.");
                else
                    System.out.println("The number " + num + " is not prime.");
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
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
}