package exercise1_poll_analysis;

import java.util.Arrays;

public class Poll {
	
	private static int[] rates = {1, 2, 6, 4, 8, 5, 9, 7, 8, 10, 
			1, 6, 3, 8, 6, 10, 3, 8, 2, 7, 6, 5, 7,
			6, 8, 6, 7, 5, 6, 6, 5, 6, 7, 5, 6, 8,  
			4, 6, 8, 10};
	private static int[] frequencies = new int[10];
	
	public static void main(String[] args) {
		Arrays.fill(frequencies, 0);
		
		for (int i = 0; i < rates.length; i++) {
			frequencies[rates[i]-1] ++;
		}
		
		StringBuilder str = new StringBuilder("Rating Frequency\n");
		for (int i = 0; i < frequencies.length; i++) {
			str.append(i + 1).append("\t").append(frequencies[i]).append("\n");
		}
		System.out.println(str.toString());
	}
}
