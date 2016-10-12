import java.util.Scanner;

/**
 * This is program that asks the user for an 8-bit binary number
 * and replies whether the parity bit checks OK.
 *
 * Parity bits are used as the simplest form of error detecting code.
 */
public class Exercise2_2 {
    public static void main(String[] args) {
        String binaryNumber = getBinaryNumber();
        // Get the last bit.
        int lastBit = Character.getNumericValue(binaryNumber.charAt(7));
        // The sum of 1 bits.
        int sumOfOnes = 0;
        for (int i = 0; i < 7; i++) {
            sumOfOnes += Character.getNumericValue(binaryNumber.charAt(i));
        }
        // Check for parity.
        if (sumOfOnes % 2 != 0 && lastBit == 1) {
            System.out.println("Parity check OK.");
        } else {
            System.out.println("Parity check not OK.");
        }
    }

    /**
     * Prompts user for a byte.
     */
    public static String getBinaryNumber() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        String byteString;
        do {
            System.out.print("Enter binary number: ");
            byteString = scanner.nextLine();
        } while (! (byteString.matches("[0-1]+") && byteString.length() == 8));
        // Close the scanner.
        scanner.close();
        return byteString;
    }
}