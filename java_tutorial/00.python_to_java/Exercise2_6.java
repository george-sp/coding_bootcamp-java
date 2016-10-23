import java.util.Scanner;
import java.util.InputMismatchException;
/**

 * Ask the user for 9 numbers:
 * - 1 with 1 digit, 1 with 2 digits, 1 with 3 digits
 * - 1 with 1 digit, 1 with 2 digits, 1 with 3 digits
 * - 1 with 1 digit, 1 with 2 digits, 1 with 3 digits.
 *
 * Then the program will print them in columns,
 * where each column will contain:
 * - 1 single digit number
 * - 1 double digit number
 * - 1 triple digit number.
 *
 * The columns will be 3 characters wide and
 * will be separated from each other with the character |.
 *
 * The numbers inside the columns will be right justified.
 */
public class Exercise2_6 {
    public static void main(String[] args) {
        System.out.println("Example: 1 10 100 2 20 200 3 30 300\n");
        System.out.println(formatString(getNineNumbers()));
    }

    /**
     * Prompts user for a 9 digit numbers:
     * 1 with 1 digit, 1 with 2 digits, 1 with 3 digits,
     * then again 1 with 1 digit, 1 with 2 digits, 1 with 3 digits,
     * and then again 1 with 1 digit, 1 with 2 digits, 1 with 3 digits.
     */
    public static String getNineNumbers() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        String nineNumbers;
        do {
            System.out.print("Enter numbers: ");
            nineNumbers = scanner.nextLine();
        } while (! (isNineNumbers(nineNumbers) && isFormatted(nineNumbers)));
        // Close the scanner.
        scanner.close();
        return nineNumbers;
    }

    /**
     * Checks if a String consists of nine numbers.
     */
    public static boolean isNineNumbers(String input) {
        if (input.matches("[0-9 ]+") && input.split(" ").length == 9) {
            return true;
        }
        return false;
    }

    /**
     * Checks if a String of numbers is of the appropriate "1-2-3 digits" format.
     */
    public static boolean isFormatted(String input) {
        String[] inputSplit = input.split(" ");
        for (int i = 0; i < 3; i++) {
            if (inputSplit[i].length() != i + 1 ||
                inputSplit[i + 3].length() != i + 1 ||
                inputSplit[i + 6].length() != i + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the given input formatted.
     */
    public static String formatString(String input) {
        String[] inputSplit = input.split(" ");
        String line1 = "";
        String line2 = "";
        String line3 = "";
        for (int i = 0; i < 9; i++) {
            if (inputSplit[i].length() == 1) {
                line1 += "  " + inputSplit[i] + "|";
            } else if (inputSplit[i].length() == 2) {
                line2 += " " + inputSplit[i] + "|";
            } else if (inputSplit[i].length() == 3) {
                line3 += inputSplit[i] + "|";
            }
        }
        return line1.substring(0, line1.length()-1) + "\n" +
               line2.substring(0, line2.length()-1) + "\n" +
               line3.substring(0, line3.length()-1) + "\n";
    }
}