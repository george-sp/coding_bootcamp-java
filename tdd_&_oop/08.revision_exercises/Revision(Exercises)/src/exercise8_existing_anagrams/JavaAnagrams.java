package exercise8_existing_anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaAnagrams {

	public static void main(String[] args) {
		permutation("", "anagram");
		
		ArrayList<String> dictionaryArrayList = new ArrayList<>();
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("./src/exercise8_existing_anagrams/dictionary.txt"), charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
//		        System.out.println(line + " length: " + line.length());
		    	dictionaryArrayList.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

	private static void permutation(String temp, String word) {
	    int n = word.length();
	    if (n == 0) System.out.println(temp);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(temp + word.charAt(i), 
	            		word.substring(0, i) + word.substring(i+1, n));
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
