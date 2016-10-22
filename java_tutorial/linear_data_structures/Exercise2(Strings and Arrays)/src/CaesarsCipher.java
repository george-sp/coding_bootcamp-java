
public class CaesarsCipher {

	private static final int ALPHABET_SIZE = 26;
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
		// Initialize an empty cipher message.
		String cipher = "";
		// Get the length of the message.
		int messageLength = message.length();
		// Iterate through the given phrase.
		for (int i = 0; i < messageLength; i++) {
			if (Character.isUpperCase(message.charAt(i))) {
				// Find the new character.
				char newChar = (char) (message.charAt(i) + numberOfShifts);
				// Check if the numerical representation of the new character in
				// ASCII
				// is bigger than the last character of the alphabet.
				if (newChar > 'Z') {
					cipher += (char) (message.charAt(i) - (26 - numberOfShifts));
				} else {
					cipher += newChar;
				}
			} else {
				cipher += message.charAt(i);
			}
		}
		return cipher;
	}

	/**
	 * Returns a de-cipher text that substitutes each character in the encoded
	 * message with a character that occurs shift places earlier on the alphabet
	 */
	public String decipher(String cipher) {
		// Initialize an empty cipher message.
		String message = "";
		// Get the length of the message.
		int cipherLength = cipher.length();
		// Iterate through the given phrase.
		for (int i = 0; i < cipherLength; i++) {
			if (Character.isUpperCase(cipher.charAt(i))) {
				// Find the new character.
				char newChar = (char) (cipher.charAt(i) - numberOfShifts);
				// Check if the numerical representation of the new character in
				// ASCII
				// is bigger than the last character of the alphabet.
				if (newChar > 'Z') {
					message += (char) (cipher.charAt(i) - (numberOfShifts - 26));
				} else {
					message += newChar;
				}
			} else {
				message += cipher.charAt(i);
			}
		}
		return message;
	}
}
