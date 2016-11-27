package exercise6;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 27/11/2016.
 */
public class FibonacciThread extends Thread {

	public BigInteger fibonacciResult;
	private static Map<Integer, BigInteger> fiboMap = new HashMap<Integer, BigInteger>();

	public FibonacciThread() {
		fiboMap.put(0, BigInteger.ZERO);
		fiboMap.put(1, BigInteger.ONE);
	}

	@Override
	public void run() {
		fibonacciResult = fibonacciRecursion(50);
	}

	/**
	 * Finds the end result of the specified n-th number in the Fibonacci
	 * sequence
	 *
	 * @param n
	 *            an index in the Fibonacci sequence
	 * @return the value of the n-th element
	 */
	public static BigInteger fibonacciLoop(int n) {
		if (n == 1 || n == 2) {
			return BigInteger.ONE;
		}
		BigInteger fibo1 = BigInteger.ONE, fibo2 = BigInteger.ONE;
		BigInteger fibonacci = BigInteger.ONE;
		for (int i = 3; i <= n; i++) {
			fibonacci = fibo1.add(fibo2); // Fibonacci number is sum of previous
											// two Fibonacci number
			fibo1 = fibo2;
			fibo2 = fibonacci;
		}
		return fibonacci; // Fibonacci number
	}

	/**
	 * Finds the end result of the specified n-th number in the Fibonacci
	 * sequence using Recursion
	 *
	 * @param n
	 *            an index in the Fibonacci sequence
	 * @return the value of the n-th element
	 */
	public static BigInteger fibonacciRecursion(int number) {
		if (!fiboMap.containsKey(number))
			fiboMap.put(number, fibonacciRecursion(number - 1).add(fibonacciRecursion(number - 2)));

		return fiboMap.get(number);
	}
}
