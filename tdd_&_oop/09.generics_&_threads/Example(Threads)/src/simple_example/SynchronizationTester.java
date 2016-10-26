package simple_example;

public class SynchronizationTester {

	public static void main(String[] args) {
		Counter variableA;
		variableA = new Counter();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
		new Thread(variableA).start();
	}

}
