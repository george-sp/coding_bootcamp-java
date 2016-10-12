import java.util.Scanner;

/**
 * A program that asks the user for a 10-digit number
 * and will then print it in two lines.
 *
 * The first line will contain the numbers in the odd positions
 * and the second the numbers in the even positions.
 *
 * Each number must be in a column by itself.
 */
public class Exercise2_3 {
  public static void main(String[] argss) {
    // Get a 10 digit number from the user.
    String num = getTenDigitNumber();
    // Print number in odd positions.
    for (int odd = 0; odd <= 8; odd += 2) {
      System.out.print(Character.toString(num.charAt(odd)) + " ");
    }
    // Change line.
    System.out.println();
    // Print number in even positions.
    for (int odd = 1; odd <= 9; odd += 2) {
      System.out.print(" " + Character.toString(num.charAt(odd)));
    }
    System.out.println();
  }

  /**
   * Prompts user for a 10 digit number.
   */
  public static String getTenDigitNumber() {
      // Declare and initialize a simple text scanner.
      Scanner scanner = new Scanner(System.in);
      String tenDigitNumber;
      do {
          System.out.print("Enter 10 digit number: ");
          tenDigitNumber = scanner.nextLine();
      } while (! (tenDigitNumber.matches("[0-9]+") && tenDigitNumber.length() == 10));
      // Close the scanner.
      scanner.close();
      return tenDigitNumber;
  }
}
