import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * https://codeandwork.github.io/courses/java/objects.html
 * Exercise4:
 *
 * Convert exercise 3 array and it's elements, from int, to Double.
 * (P.S. not double but Double.)
 */
public class Exercise4 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Instantiate the array named elements.
        Double[] elements = new Double[10];
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
    private static void generateArray(Double[] array) {
        for (int i = 0; i < 10; i++) {
            array[i] = new Double(new Integer(i + 1).doubleValue());
        }
    }

    /**
     * Shifts the array elements right by n times
     */
    private static void shiftRightArray(Double[] array, int n, int counter) {
        Double[] temporaryArray = new Double[10];
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