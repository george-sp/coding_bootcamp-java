import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * https://codeandwork.github.io/courses/java/objects.html
 * Exercise1
 */
public class Exercise1 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        System.out.println(bootCamp(getNumber(scanner), getNumber(scanner)));
        // Close the scanner object.
        scanner.close();
    }

    /**
     * A method that receives as an input two int arguments, i.e., number1 and number2,
     * and returns an int result in the end.
     * =========================================
     * If "number1" is smaller that "number2" then returns the square root of the absolute value
     * of the difference among "number1" and "number2".
     * Else return the sum of the two numbers. 
     */
    public static int bootCamp(int number1, int number2) {
        if (number1 < number2) {
            return (int) Math.sqrt(Math.abs(number1 - number2));
        } else {
            return number1 + number2;
        }
    }

    /**
     * Prompts user for a number.
     */
    public static int getNumber(Scanner scanner) {
        int number;
        while (true) {
            System.out.print("Give an integer: ");
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