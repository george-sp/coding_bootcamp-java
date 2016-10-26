package threads;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		// 1st way
		FindCountOfEvenNumbers thread1 = new FindCountOfEvenNumbers(1200);
		thread1.start();
		// 2nd way
		FindCountOfOddNumbers thread2 = new FindCountOfOddNumbers(1200);
		new Thread(thread2).start();

		/**
		 * Thread vs Runnable
		 */
		// Multiple threads share the same object.
		ImplementsRunnable rc = new ImplementsRunnable();
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t2 = new Thread(rc);
		t2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		Thread t3 = new Thread(rc);
		t3.start();

		// Creating new instance for every thread access.
		ExtendsThread tc1 = new ExtendsThread();
		tc1.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThread tc2 = new ExtendsThread();
		tc2.start();
		Thread.sleep(1000); // Waiting for 1 second before starting next thread
		ExtendsThread tc3 = new ExtendsThread();
		tc3.start();
	}
}
