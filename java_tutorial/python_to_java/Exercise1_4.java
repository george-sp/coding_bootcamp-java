import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a program that asks the user to enter values for a, b, c,
 * then prints the solutions of the quadratic equation they define, if they exist.
 * If they do not exist, it should output an appropriate message.
 */
public class Exercise1_4 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Names and values of the triangle's sides.
        String valueNames = "abc";
        double[] values = new double[3];
        // Get values for the three sides.
        for (int i = 0; i < valueNames.length(); i++) {
            values[i] = getValue(valueNames.substring(i, i + 1), scanner);
        }
        // Close the scanner.
        scanner.close();
        // Calculate the discriminant.
        double discriminant = (Math.pow(values[1], 2) - 4 * values[0] * values[2]);
        // Check for no real-valued solutions.
        if (discriminant < 0) {
            System.out.println("No real-valued solutions exist");
        } else {
            double root1 = (-values[1] + Math.sqrt(discriminant)) / (2 * values[0]);
            double root2 = (-values[1] - Math.sqrt(discriminant)) / (2 * values[0]);
            System.out.println("The solutions are: root1 = " + root1 + " and root2 = " + root2);
        }
    }

    /**
     * Get a valid user input.
     */
    public static double getValue(String valueName, Scanner scanner) {
        double value;
        // Get a valid user input.
        while (true) {
            System.out.print("Give a value to " + valueName + " : ");
            try {
                value = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Give a valid input. Give a number.");
                scanner.next();
            }
        }
        return value;
    }
}