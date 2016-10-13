import java.util.Scanner;

/**
 * A program that asks the user to enter a sequence of digits
 * and then calculates the value of the sequence, as defined below:
 *
 * - sequence: 1234567
 * - value: 1 * 2 + 3 * 4 + 5 * 6 + 7
 */
public class Exercise2_8 {
    public static void main(String[] args) {
        // Get user input.
        String numberSequence = getNumber();
        // Get user input length.
        int numberSequenceSize = numberSequence.length();
        // Initialize the sum.
        int sum = 0;
        for (int i = 0; i < numberSequenceSize; i += 2) {
            if (i + 1 < numberSequenceSize) {
                sum += (Integer.parseInt(Character.toString(numberSequence.charAt(i)))
                        * Integer.parseInt(Character.toString(numberSequence.charAt(i+1))));
            } else {
                sum += Integer.parseInt(Character.toString(numberSequence.charAt(i)));
            }
        }
        System.out.println(sum);
    }

    /**
     * Prompts user for a number.
     */
    public static String getNumber() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        String number;
        do {
            System.out.print("Enter number sequence: ");
            number = scanner.nextLine();
        } while (! (number.matches("[0-9]+")));
        // Close the scanner.
        scanner.close();
        return number;
    }
}