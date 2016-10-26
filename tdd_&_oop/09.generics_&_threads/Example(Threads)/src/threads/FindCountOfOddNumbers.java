package threads;

/**
 * 2nd way of executing Threads in java. 
 * - Declare a class that implements the Runnable interface. 
 * - Override the run method of the Runnable interface.
 */
public class FindCountOfOddNumbers implements Runnable {
	private int maxNumber;
	private int count;

	FindCountOfOddNumbers(int maxNumber) {
        this.maxNumber = maxNumber;
        this.count = 0;     
    }

	@Override
	public void run() {
		for (int i = 0; i < this.maxNumber; ++i) {
			if (i % 2 != 0)
				System.out.println(++count);
		}
	}

}
