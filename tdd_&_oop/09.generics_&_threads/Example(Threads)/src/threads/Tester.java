package threads;

public class Tester {

	public static void main(String[] args) {
		// 1st way
		FindCountOfEvenNumbers thread1 = new FindCountOfEvenNumbers(1200);
		thread1.start();
		// 2nd way
		FindCountOfOddNumbers thread2 = new FindCountOfOddNumbers(1200);
		new Thread(thread2).start();
	}
}
