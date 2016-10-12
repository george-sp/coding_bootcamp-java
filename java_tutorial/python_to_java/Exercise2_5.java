import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This program asks the user for a year and then displays
 * the month and the year of Orthodox Easter in the Gregorian calendar.
 *
 * The follow algorithm can be used to calculate the Orthodox Easter Sunday
 * for any year between 1900 and 2099.
 * (Suppose that y is the year)
 * 1. a = y mod 4
 * 2. b = y mod 7
 * 3. c = y mod 19
 * 4. d = (19c + 15) mod 30
 * 5. e = (2a + 4b - d + 34) mod 7
 * 6. month = |((d + e + 114) / 31)| , |x| means the integer part of x
                                       that is, x round down towards 0.
 * 7. day = ((d + e + 114) mod 31) + 1
 * 8. The result is the day and the month in the Julian Calendar.
 *    to convert it to the Gregorian calendar, add 13 days.
 *
 * Test with the values below:
 * 2011 (24,4), 2012 (15/4), 2013 (5/5), 2014 (20/4),
 * 2015 (12/4), 2016 (1/5), 2017 (16/4).
 */
public class Exercise2_5 {
    public static void main(String[] args) {
        int year = getYear();
        calculateOrthodoxEasterSunday(year);
    }

    /**
     * Calculates the Orthodox Easter Sunday
     * for any year between 1900 and 2099.
     */
    public static void calculateOrthodoxEasterSunday(int year) {
        int a, b, c, d, e, month, day;
        a = year % 4;
        b = year % 7;
        c = year % 19;
        d = (19 * c + 15) % 30;
        e = (2*a + 4*b - d + 34) % 7;
        month = (int) ((d + e + 114) / 31);
        day = ((d + e + 114) % 31) + 1;

        // Create a calendar.
        Calendar calendar = new GregorianCalendar();
        // Set the year, month and day in the Julian Calendar.
        calendar.set(year, month, day);
        // Add 13 days to convert it to the Gregorian Calendar.
        calendar.add(Calendar.DAY_OF_YEAR, 13);
        System.out.println(
            "Day: " + calendar.get(Calendar.DAY_OF_MONTH) +
            " Month: " + calendar.get(Calendar.MONTH));
    }

    /**
    * Prompts user for a year between 1900 and 2099.
    */
    public static int getYear() {
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        do {
            System.out.print("Enter year: ");
            try {
                year = scanner.nextInt();
                if ((year >= 1900 && year <= 2099)) {
                    break;
                } else {
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        } while (true);
        // Close the scanner.
        scanner.close();
        return year;
    }
}
