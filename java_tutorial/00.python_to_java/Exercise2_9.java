import java.util.Scanner;

/**
 * This is a program that asks for the number of positions to shift each character
 * and a phrase.
 * Then it will output the phrase encrypted with the Caesar cipher.
 * The Caesar cipher works by substituting each character in a message with a
 * character that occurs x places later on the alphabet,
 * wrapping around from the beginning, if needed.
 *
 * -> Assume that the phrase consists only of uppercase English letters
 *   (without punctuation or spaces).
 */
public class Exercise2_9 {
    public static void main(String[] args) {
        // The size of the alphabet.
        final int ALPHABET_SIZE = 26;
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);
        // Ask for the number of positions to shift and the phrase to be encrypted.
        System.out.println(cipherMessage(Integer.parseInt(getShiftPositions(scanner)), getPhrase(scanner)));
        // Close the scanner.
        scanner.close();
    }

    /**
     * Returns a cipher text that substitutes each character in the message with a
     * character that occurs shift places later on the alphabet
     */
    private static String cipherMessage(int shift, String message) {
        // Initialize an empty cipher message.
        String cipher = "";
        // Get the length of the message.
        int messageLength = message.length();
        // Iterate through the given phrase.
        for (int i = 0; i < messageLength; i++) {
            // Find the new character.
            char newChar = (char)(message.charAt(i) + shift);
            // Check if the numerical representation of the new character in ASCII
            // is bigger than the last character of the alphabet.
            if (newChar > 'Z') {
                cipher += (char)(message.charAt(i) - (26 - shift));
            } else {
                cipher += newChar;
            }
        }
        return cipher;
    }

    /**
     * Prompts user for the number of positions to shift.
     */
    private static String getShiftPositions(Scanner scanner) {
        String number;
        do {
            System.out.print("Enter shift: ");
            number = scanner.nextLine();
        } while (! (number.matches("[0-9]+")));
        return number;
    }

    /**
     * Prompts user for a plain text (phrase) to be encoded.
     */
    private static String getPhrase(Scanner scanner) {
        String phrase;
        do {
            System.out.print("Enter phrase: ");
            phrase = scanner.nextLine();
        } while (phrase == null || phrase.isEmpty());
        // Return the upper case phrase.
        return phrase.toUpperCase();
    }
}