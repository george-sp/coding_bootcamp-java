package exercise8_existing_anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class JavaAnagrams {

	// Stores all the permutations (anagrams) of the given word.
	static ArrayList<String> permutationsArrayList = new ArrayList<>();
	// Stores each valid(in dictionary) anagram only once.
	static HashSet<String> anagramsInDictionary = new HashSet<>();
	// Stores the words in the dictionary.txt file.
	static ArrayList<String> dictionaryArrayList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Reading the dictionary file.
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("./src/exercise8_existing_anagrams/dictionary.txt"), charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	dictionaryArrayList.add(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		// Prompt user to give a word.
		System.out.println("Enter a word: ");
		String input = scanner.nextLine();
		
		// Get all permutations of the given word.
		permutation("", input);
		
		// Get the each valid anagram only once.
		for (String permutation : permutationsArrayList) {
			if (dictionaryArrayList.contains(permutation)){
				anagramsInDictionary.add(permutation);				
			}
		}
		
		// Print them.
		for (String anagramInDic : anagramsInDictionary) {
			System.out.println(anagramInDic);
		}
		
		try {
			scanner.close();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

	private static void permutation(String temp, String word) {
	    int n = word.length();
	    if (n == 0) {
	    	permutationsArrayList.add(temp);
	    }
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
