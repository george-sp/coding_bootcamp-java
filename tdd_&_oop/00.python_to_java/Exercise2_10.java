import java.util.Scanner;

/**
 * Ask the user to enter a sequence of 0s and 1s.
 * Identify the longest run of 0s or 1s of the sequence and print an appropriate message.
 */
public class Exercise2_10 {
    public static void main(String[] args){
        // Convert user input from String to char[].
        char[] binarySequence = getBinarySequence().toCharArray();
        // Initialize longest runs and runs of 0s and 1s.
        int longestRun0 = 0;
        int longestRun1 = 0;
        int run0 = 0;
        int run1 = 0;
        // Set previous number variable equal to the first digit.
        int previousDigit = Character.getNumericValue(binarySequence[0]);
        // Iterate the charArray.
        for (char digit : binarySequence) {
            int currentDigit = Character.getNumericValue(digit);
            switch(currentDigit) {
                case 0:
                    if (previousDigit == 1) {
                        // Get the maximum of the current run and the longest for the ones.
                        longestRun1 = Math.max(run1, longestRun1);
                        // Reset the run of 1s.
                        run1 = 0;
                    }
                    // Count +1 for the run of 0s.
                    run0++;
                    previousDigit = currentDigit;
                    break;
                case 1:
                    if (previousDigit == 0) {
                        // Get the maximum of the current run and the longest.
                        longestRun0 = Math.max(run0, longestRun0);
                        // Reset the run of 1s.
                        run0 = 0;
                    }
                    // Count +1 for the run of 1s.
                    run1++;
                    previousDigit = currentDigit;
                    break;
            }
        }
        // Check for the longest run once more.
        longestRun0 = Math.max(run0, longestRun0);
        longestRun1 = Math.max(run1, longestRun1);
        // Display the appropriate message.
        printLongestRun(longestRun0, longestRun1);
    }

    /**
     * Print which is the longest run.
     */
    private static void printLongestRun(int longRun0, int longRun1) {
        if (longRun1 > longRun0) {
            System.out.println("Longest run was ones with length: " + longRun1);
        } else if (longRun1 < longRun0) {
            System.out.println("Longest run was zeros with length: " + longRun0);
        } else {
            System.out.println("Equal longest runs of ones and zeros with length: " + longRun0);
        }
    }

    /**
     * Prompts user for a binary sequence.
     */
    private static String getBinarySequence() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        String binarySequence;
        do {
            System.out.print("Enter binary sequence: ");
            binarySequence = scanner.nextLine();
        } while (! (binarySequence.matches("[0-1]+")));
        // Close the scanner.
        scanner.close();
        return binarySequence;
    }
}