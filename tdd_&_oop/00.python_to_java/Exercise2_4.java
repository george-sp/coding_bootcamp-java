import java.util.Scanner;

/**
 * A program that asks the user for a 9-digit number
 * and then prints it in three lines.
 *
 * Each line must contain three digits.
 * Each number must be in a column by itself.
 */
public class Exercise2_4 {
  public static void main(String[] args) {
    String numberInput = getNineDigitNumber();
    String line1 = "";
    String line2 = " ";
    String line3 = "  ";

    // Set up a line counter so that can move between lines.
    int lineCounter = 1;
    for (int i = 0; i <= 8; i++) {
      switch (lineCounter) {
        case 1:
          line1 += numberInput.charAt(i) + "  ";
          break;
        case 2:
          line2 += numberInput.charAt(i) + "  ";
          break;
        case 3:
          line3 += numberInput.charAt(i) + "  ";
          break;
      }
      // Increase the counter by 1.
      lineCounter++;
      // There is not a line4 so reset the line counter to 1.
      if (lineCounter == 4) {
        lineCounter = 1;
      }
    }
    // Display the formatted three lines.
    System.out.println(line1 + "\n" + line2 + "\n" + line3 + "\n");
  }

  /**
   * Prompts user for a 9 digit number.
   */
  public static String getNineDigitNumber() {
      // Declare and initialize a simple text scanner.
      Scanner scanner = new Scanner(System.in);
      String nineDigitNumber;
      do {
          System.out.print("Enter 9 digit number: ");
          nineDigitNumber = scanner.nextLine();
      } while (! (nineDigitNumber.matches("[0-9]+") && nineDigitNumber.length() == 9));
      // Close the scanner.
      scanner.close();
      return nineDigitNumber;
  }
}
