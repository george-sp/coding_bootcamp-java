import java.util.Scanner;

/**
 * A program that will ask the user for TIN
 * and will respond whether it is correct or not.
 */
public class Exercise2_1 {

  public static void main(String[] args){

    // Take input from the user.
    String input = getTIN();
    // Get the check digit. The last digit of the input.
    int checkDigit = Character.getNumericValue(input.charAt(input.length()-1));
    // Remove the check digit from the input.
    input = input.substring(0, input.length() - 1);
    // Reverse the user input.
    input = new StringBuilder(input).reverse().toString();

    // Initialize a sum.
    int sumPowers = 0;
    for (int i = 0; i < input.length(); i++) {
      sumPowers += Character.getNumericValue(input.charAt(i)) * Math.pow(2, i+1);
    }

    // Calculate the remainder of the sum by 11.
    int remainder1 = sumPowers % 11;
    // Calculate the remainder of the above remainder by 10.
    int remainder2 = remainder1 % 10;

    // Check if the result is equal to the check digit, and notify the user.
    if (remainder2 == checkDigit)
      System.out.println("Tax Identification Number valid.");
    else
      System.out.println("Tax Identification Number not valid.");
  }

  /**
   * Prompts user for a number.
   */
  public static String getTIN() {
      // Declare and initialize a simple text scanner.
      Scanner scanner = new Scanner(System.in);
      String number;
      do {
          System.out.print("Enter Tax Identification Number: ");
          number = scanner.nextLine();
      } while (! (number.matches("[0-9]+") && number.length() == 9));
      // Close the scanner.
      scanner.close();
      return number;
  }
}