import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Write a program that asks the user for the three sides of a triangle
 * and calculates its area.
 */
public class Exercise1_3 {
    public static void main(String[] args) {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Names and values of the triangle's sides.
        String sideNames = "abc";
        double[] sideValues = new double[3];
        // Get values for the three sides.
        for (int i = 0; i < sideNames.length(); i++) {
            sideValues[i] = getSide(sideNames.substring(i, i + 1), scanner);
        }
        // Close the scanner.
        scanner.close();
        /*
         * Use Heron's formula to calculate the area of the triangle.
         */
        double sideA = sideValues[0];
        double sideB = sideValues[1];
        double sideC = sideValues[2];
        double triangleArea = (double)1/4 * Math.sqrt((sideA + sideB + sideC)
        * (-sideA + sideB + sideC) * (sideA - sideB + sideC) * (sideA + sideB - sideC));
        System.out.println("The triangle's area is: " + triangleArea);
    }

    /**
     * Prompts user for a valid input.
     */
    public static double getSide(String sideName, Scanner scanner) {
        double side;
        while (true) {
            System.out.print("Enter side " + sideName + " : ");
            try {
                side = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Give a valid input. Give a number.");
                scanner.next();
            }
        }
        return side;
    }
}