package exercise9_prime_factors;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static void main(String[] args) {
//		System.out.println(getPrimeFactors(13195).get(getPrimeFactors(13195).size() - 1));
		BigInteger b1 = new BigInteger("600851475143");
		List<BigInteger> primeFactors = getPrimeFactors(b1);
		System.out.println("The largest prime factor of " + b1.toString() + " is: " + primeFactors.get(primeFactors.size() - 1));
	}

	public static List<BigInteger> getPrimeFactors(BigInteger number) {
		List<BigInteger> primeFactors = new ArrayList<BigInteger>();
		for (BigInteger i = new BigInteger("2"); i.compareTo(number.divide(i)) <= 0 ; i = i.add(BigInteger.ONE)) {
			while (number.mod(i) == BigInteger.ZERO) {
				primeFactors.add(i);
				number = number.divide(i);
			}
		}
		if (number.compareTo(BigInteger.ONE) == 1) {
			primeFactors.add(number);
		}
		return primeFactors;
	}

}
