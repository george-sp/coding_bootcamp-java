package threads;

//Implementing Runnable Interface
class ImplementsRunnable implements Runnable {
	private int counter = 0;

	public void run() {
		counter++;
		System.out.println("ImplementsRunnable : Counter : " + counter);
	}
}