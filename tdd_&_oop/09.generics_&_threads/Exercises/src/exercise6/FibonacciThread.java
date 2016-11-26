package exercise6;

import java.math.BigInteger;

/**
 * Created by george on 27/11/2016.
 */
public class FibonacciThread extends Thread {

    public BigInteger fibonacciResult;

    @Override
    public void run() {
        fibonacciResult = fibonacciLoop(50);
    }

    /**
     * Finds the end result of the specified n-th number in the Fibonacci sequence
     *
     * @param n an index in the Fibonacci sequence
     * @return the value of the n-th element
     */
    public static BigInteger fibonacciLoop(int n) {
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        BigInteger fibo1 = BigInteger.ONE, fibo2 = BigInteger.ONE;
        BigInteger fibonacci = BigInteger.ONE;
        for (int i = 3; i <= n; i++) {
            fibonacci = fibo1.add(fibo2); // Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
        return fibonacci; // Fibonacci number
    }
}
