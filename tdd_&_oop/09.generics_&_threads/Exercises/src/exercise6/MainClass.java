package exercise6;

import java.math.BigInteger;

public class MainClass {

   public static void main(String[] args) {
      
	   //Here add your thread
	   FibonacciThread fibonacciThread = new FibonacciThread();
	   
	   //Do not remove this part of code 
	   System.out.println("The result of the Fibonacci 50 is ");
       fibonacciThread.run();
       try {
           fibonacciThread.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println(fibonacciThread.fibonacciResult);
       System.exit(1);
   }

    public static BigInteger fibonacciRecursion(int number) {
        if (number == 0 || number == 1) {
            return BigInteger.ONE;
        }

        return fibonacciRecursion(number - 1).add(fibonacciRecursion(number - 2)); // tail recursion
    }
}