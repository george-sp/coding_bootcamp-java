import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * https://codeandwork.github.io/courses/java/objects.html
 * Exercise3:
 *
 * Create an array that can receive 10 elements, as a size,
 * and add in each position an element starting from 1 to 10 statically and print the array.
 * Afterwards, create a method that can shift the array elements right by 10 times.
 * The 10 is given by the user as an input. At the end print the shifted array.
 */
public class Exercise3 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Instantiate the array named elements.
        int[] elements = new int[10];
        // Generate the Array.
        generateArray(elements);
        // Print the original array - (1 to 10).
        System.out.println(Arrays.toString(elements) + "\n" + "-------------------------------");
        // Shift the original array elements right by n times.
        shiftRightArray(elements, getNumber(scanner), 1);
    }

    /**
     * Adds in each position an element starting from 1 to 10.
     */
    private static void generateArray(int[] array) {
        for (int i = 0; i < 10; i++) {
            array[i] = i + 1;
        }
    }

    /**
     * Shifts the array elements right by n times
     */
    private static void shiftRightArray(int[] array, int n, int counter) {
        int[] temporaryArray = new int[10];
        temporaryArray[0] = array[9];
        for (int i = 1; i < 10; i++) {
            temporaryArray[i] = array[i - 1];
        }
        System.out.println(Arrays.toString(temporaryArray));
        counter ++;
        if (counter <= n) {
            shiftRightArray(temporaryArray, n, counter);
        } else {
            return;
        }
    }

    /**
     * Prompts user for a number.
     */
    public static int getNumber(Scanner scanner) {
        int number;
        do {
            System.out.print("Right shift times: ");
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