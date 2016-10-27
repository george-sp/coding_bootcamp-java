package synchronization;

public class SynchronizationTester {

	public static void main(String[] args) {
//		System.out.println("SyncCounter");
		Counter variableA = new Counter();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		
//		System.out.println("\nAsyncCounter");
		AsyncCounter variableB = new AsyncCounter();
		new Thread(variableB).start();
		new Thread(variableB).start();
		new Thread(variableB).start();
		new Thread(variableB).start();
		new Thread(variableB).start();
		new Thread(variableB).start();
		new Thread(variableB).start();
	}

}
