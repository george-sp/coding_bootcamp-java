package exercise6_anagrams;

import java.util.Arrays;

public class JavaAnagrams {

	public static void main(String[] args) {

		// This part of code will test your execution (Don't touch this part of
		// code)
		// Test Case 1
		System.out.println("Input Testing: anargram and margana");
		System.out.println("Expercted output: Anagrams");
		if (isAnagram("anagram", "margana"))
			System.out.println("Your output: Anagrams");
		else
			System.out.println("Your output: Not Anagrams");

		// Test Case 2
		System.out.println("\nInput Testing: anagramm and marganaa");
		System.out.println("Expercted output: Not Anagrams");
		if (isAnagram("anagramm", "marganaa"))
			System.out.println("Your output: Anagrams");
		else
			System.out.println("Your output: Not Anagrams");

		// Test Case 3
		System.out.println("\nInput Testing: Hello and hello");
		System.out.println("Expercted output: Anagrams");
		if (isAnagram("Hello", "hello"))
			System.out.println("Your output: Anagrams");
		else
			System.out.println("Your output: Not Anagrams");
	}

	public static boolean isAnagram(String a, String b) {
		char[] charArrayA = a.toLowerCase().toCharArray();
		char[] charArrayB = b.toLowerCase().toCharArray();
		Arrays.sort(charArrayA);
		Arrays.sort(charArrayB);
		return Arrays.equals(charArrayA, charArrayB);
	}
}
