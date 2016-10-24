package exercise8_existing_anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class JavaAnagrams {

	public static void main(String[] args) {
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("./src/exercise8_existing_anagrams/dictionary.txt"), charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

	public static boolean isAnagram(String a, String b) {
		char[] charArrayA = a.toLowerCase().toCharArray();
		char[] charArrayB = b.toLowerCase().toCharArray();
		Arrays.sort(charArrayA);
		Arrays.sort(charArrayB);
		return Arrays.equals(charArrayA, charArrayB);
	}
}
