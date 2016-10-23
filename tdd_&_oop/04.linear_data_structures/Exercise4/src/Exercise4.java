import java.util.Scanner;

/**
 * A program that checks if a given word is a palindrome.
 * Palindrome words are the words that can be read backwards. (example: madam)
 * @author george
 *
 */
public class Exercise4 {
	
	public static void main(String[] args) {
		System.out.print("Give a word: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char[] charArray = input.toCharArray();
		int halfSize = charArray.length / 2;
		int size = charArray.length;
		for (int i = 0; i <= halfSize; i++) {
			if (charArray[i] != charArray[size-1-i]) {
				System.out.println("Not a palindrome");
				return;
			}
		}
		System.out.println("Yeah!! You gave a palindrome!");
	}
}
