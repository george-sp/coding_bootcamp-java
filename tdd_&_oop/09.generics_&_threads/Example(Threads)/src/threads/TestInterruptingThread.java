package threads;

public class TestInterruptingThread extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("task");
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted..." + e);
		}
	}

}