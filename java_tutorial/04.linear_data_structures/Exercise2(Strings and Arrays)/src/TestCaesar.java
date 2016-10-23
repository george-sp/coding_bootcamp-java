import java.util.Scanner;

public class TestCaesar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter shift: ");
		CaesarsCipher cc = new CaesarsCipher(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter text: ");
		String message = scanner.nextLine();
		String cipherMessage = cc.cipher(message);
		System.out.println(cipherMessage);
		System.out.println(cc.decipher(cipherMessage));
		
		if (scanner != null) {
			try {				
				scanner.close();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}
	}
	
}
