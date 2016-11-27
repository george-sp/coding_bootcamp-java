package exercise6;

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

}