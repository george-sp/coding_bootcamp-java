package threads;

/**
 * 1st way of executing Threads in java. 
 * - Declare a class to extend from Thread class. 
 * - Override the run method of the Thread class.
 */
public class FindCountOfEvenNumbers extends Thread {
	private int maxNumber;
	private int count;

	FindCountOfEvenNumbers(int maxNumber) {
		this.maxNumber = maxNumber;
		this.count = 0;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.maxNumber; ++i) {
			if (i % 2 == 0)
				++count;
		}
		System.out.println("even: " + count);
	}

}
