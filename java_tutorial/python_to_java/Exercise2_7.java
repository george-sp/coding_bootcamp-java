import java.util.Scanner;

/**
 * Asks the user to enter two dates in the form dd/mm/yyyy
 * and will then display the number of days that have elapsed between the two days.
 *
 * To calculate the number of days between two days we can use the following algorithm.
 * Let's say that the first date is given by y1, m1, d1 and the second date is given by y2, m2, d2.
 *
 * 1. c1 = 365y1 + ⌊y1/4⌋ − ⌊y1/100⌋ + ⌊y1/400⌋ + ⌊(306m1 + 5)/10⌋ + (d1−1)
 * 2. c2 = 365y2 + ⌊y2/4⌋ − ⌊y2/100⌋ + ⌊y2/400⌋ + ⌊(306m2 + 5)/10⌋ + (d2−1)
 * 3. c2-c1
 */
public class Exercise2_7 {
    public static void main(String[] args) {
        String[] userInput = getTwoDates().split(" ");
        // Use String Arrays to access the two dates.
        String[] date1 = userInput[0].split("/");
        String[] date2 = userInput[1].split("/");
        int day1 = Integer.parseInt(date1[0]);
        int day2 = Integer.parseInt(date2[0]);
        int month1 = Integer.parseInt(date1[1]);
        int month2 = Integer.parseInt(date2[1]);
        int year1 = Integer.parseInt(date1[2]);
        int year2 = Integer.parseInt(date2[2]);
        // Implement the given algorithm.
        // c1 = 365y1 + ⌊y1/4⌋ − ⌊y1/100⌋ + ⌊y1/400⌋ + ⌊(306m1+5)/10⌋ + (d1−1)
        int c1 = 365*year1 + (int) (year1/4) - (int) (year1/100) +
                 (int) (year1/400) + (int) ((306*month1)/10) + (day1 - 1);
        // c2 = 365y2 + ⌊y2/4⌋ − ⌊y2/100⌋ + ⌊y2/400⌋ + ⌊(306m2+5)/10⌋ + (d2−1)
        int c2 = 365*year2 + (int) (year2/4) - (int) (year2/100) +
                 (int) (year2/400) + (int) ((306*month2)/10) + (day2 - 1);
        // c2 - c1
        if (c2 > c1) {
            System.out.println(c2 - c1);
        } else {
            System.out.println(c1 - c2);
        }
    }

    /**
     * Prompts user for two dates.
     */
    public static String getTwoDates() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        String datesInput;
        do {
            System.out.print("Enter dates: ");
            datesInput = scanner.nextLine();
        } while (! isTwoDates(datesInput));
        // Close the scanner.
        scanner.close();
        return datesInput;
    }

    /**
     * Check if the given String has to dates,
     * of format dd/mm/yyyy.
     *----------------------------------------
     * Check if a string is a valid date:
     * http://stackoverflow.com/questions/11480542/fastest-way-to-tell-if-a-string-is-a-valid-date
     */
    private static boolean isTwoDates(String dates) {
        String[] datesSplit = dates.split(" ");
        // Check if the input can be split in half.
        if (datesSplit.length != 2)
            return false;
        // Seperate the two date strings.
        String date1 = datesSplit[0];
        String date2 = datesSplit[1];
        // Check if the input consists of numbers and slashes.
        if (! (date1.matches("[0-9/-]+")
            && date2.matches("[0-9/-]+")))
            return false;
        // Check if date1 and date2 start or end with a slash.
        if (String.valueOf(date1.charAt(0)).equals("/")
            || String.valueOf(date2.charAt(0)).equals("/")
            || String.valueOf(date1.charAt(date1.length()-1)).equals("/")
            || String.valueOf(date2.charAt(date2.length()-1)).equals("/"))
            return false;
        // Split the date1 and date2 strings in slashes.
        String[] date1Split = date1.split("/");
        String[] date2Split = date2.split("/");
        // Check if they hava a split format.
        if (date1Split.length != 3 || date2Split.length != 3)
            return false;
        // Check for valid day numbers.
        int day1 = Integer.parseInt(date1Split[0]);
        int day2 = Integer.parseInt(date2Split[0]);
        if (!(day1 <= 31 && day1 >= 1 && day2 <= 31 && day2 >= 1))
            return false;
        // Check for valid month numbers.
        int month1 = Integer.parseInt(date1Split[1]);
        int month2 = Integer.parseInt(date2Split[1]);
        if (!(month1 <= 12 && month1 >= 1 && month2 <= 12 && month2 >= 1))
            return false;
        // Check for valid year numbers.
        int year1 = Integer.parseInt(date1Split[2]);
        int year2 = Integer.parseInt(date2Split[2]);
        if (year1 == 0 || year2 == 0)
            return false;
        return true;
     }
}