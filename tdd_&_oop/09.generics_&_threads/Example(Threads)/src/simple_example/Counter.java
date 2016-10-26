package simple_example;

public class Counter implements Runnable {

	private int c = 0;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

	@Override
	public synchronized void run() {
		increment();
		System.out.println("I am thread" + Thread.currentThread().getName() + "and the c value is " + this.c);
		decrement();
	}

}
