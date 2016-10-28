package exercise4_safe_division;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quotient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numerator, denominator, result;
		boolean success = false;

		do {
			try {
				System.out.print("Give numerator: ");
				numerator = scanner.nextInt();
				System.out.print("Give denominator: ");
				denominator = scanner.nextInt();
				result = calcQuotient(numerator, denominator);
				System.out.println("Result: " + result);
				success = true;
			} catch (InputMismatchException e) {
				System.out.println("input miss match exception\n");
			} catch (ArithmeticException e) {
				System.out.println("arithmetic exception\n");
			}
			scanner.nextLine();
		} while (!success);
		scanner.close();
	}

	public static int calcQuotient(int numerator, int denominator) throws ArithmeticException {
		if (denominator != 0) {
			return numerator / denominator;
		} else {
			throw new ArithmeticException();
		}
	}
}
