package synchronization;

public class AsyncCounter implements Runnable {

	private int c = 0;

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public int value() {
		return c;
	}

	@Override
	public void run() {
		increment();
		System.out.println("I am thread" + Thread.currentThread().getName() + "and the c value is " + this.c);
		decrement();
	}

}
