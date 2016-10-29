package exercise9_prime_factors;

import java.util.ArrayList;

public class PrimeFactors {

	public static void main(String[] args) {
		System.out.println(getPrimeFactors(13195).get(getPrimeFactors(13195).size() - 1));
	}

	public static ArrayList<Integer> getPrimeFactors(int numbers) {
		int n = numbers;
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				primeFactors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			primeFactors.add(n);
		}
		return primeFactors;
	}

}
