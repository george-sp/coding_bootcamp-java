package exercise5;

public class SumRunnable implements Runnable {

	private int counter;
	public int sumOfNumArray;
	private static int[] numArray;

	SumRunnable() {
		counter = 0;
		sumOfNumArray = 0;
		numArray = new int[1000];
		for (int i = 0; i < 1000; i++) {
			numArray[i] = i + 1;
		}
	}

	@Override
	public synchronized void run() {
		for (int i = 100 * counter++; i < counter * 100; i++) {
			sumOfNumArray += numArray[i];
		}
		System.out.println("counter: " + counter);
	}
}
