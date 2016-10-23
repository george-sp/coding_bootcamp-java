
public class CaesarsCipher {

	private static final int ALPHABET_SIZE = 26;
	private static final int LOWER_START = 97;
	private static final int LOWER_END = 122;
	private static final int UPPER_START = 65;
	private static final int UPPER_END = 90;
	private int numberOfShifts;

	public CaesarsCipher() {
	}

	public CaesarsCipher(int numberOfShifts) {
		this.setNumberOfShifts(numberOfShifts);
	}

	public void setNumberOfShifts(int numberOfShifts) {
		this.numberOfShifts = numberOfShifts;
	}

	public int getNumberOfShifts() {
		return this.numberOfShifts;
	}

	/**
	 * Returns a cipher text that substitutes each character in the message with
	 * a character that occurs shift places later on the alphabet
	 */
	public String cipher(String message) {
		StringBuilder cipherBuilder = new StringBuilder(message);
		for (int i = 0, n = message.length(); i < n; i++) {
			char currentChar = message.charAt(i);
			// Check if the character is an alphabetic.
			if (Character.isLetter(currentChar)) {
				// Check if character is an uppercase or lowercase letter.
				if (Character.isLowerCase(currentChar)) {
					cipherBuilder.setCharAt(i, (char) (LOWER_START + (currentChar + this.numberOfShifts - LOWER_START) % ALPHABET_SIZE));
				} else if (Character.isUpperCase(currentChar)) {
					cipherBuilder.setCharAt(i, (char) (UPPER_START + (currentChar + this.numberOfShifts - UPPER_START) % ALPHABET_SIZE));
				}
			}
		}
		return cipherBuilder.toString();
	}

	/**
	 * Returns a de-cipher text that substitutes each character in the encoded
	 * message with a character that occurs shift places earlier on the alphabet
	 */
	public String decipher(String cipher) {
		StringBuilder messageBuilder = new StringBuilder(cipher);
		for (int i = 0, n = cipher.length(); i < n; i++) {
			char currentChar = cipher.charAt(i);
			// Check if the character is an alphabetic.
			if (Character.isLetter(currentChar)) {
				// Check if character is an uppercase or lowercase letter.
				if (Character.isLowerCase(currentChar)) {
					messageBuilder.setCharAt(i, (char) (LOWER_END - (LOWER_END - currentChar + this.numberOfShifts) % ALPHABET_SIZE));
				} else if (Character.isUpperCase(currentChar)) {
					messageBuilder.setCharAt(i, (char) (UPPER_END - (UPPER_END - currentChar + this.numberOfShifts) % ALPHABET_SIZE));
				}
			}
		}
		return messageBuilder.toString();		
	}
}
