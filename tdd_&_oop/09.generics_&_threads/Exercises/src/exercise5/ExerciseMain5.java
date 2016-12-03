package exercise5;

public class ExerciseMain5 {

	public static void main(String[] args) throws InterruptedException {
		SumRunnable rc = new SumRunnable();

		Thread[] threadArray = new Thread[10];
		
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new Thread(rc);
			threadArray[i].start();
		}
		
		Thread.sleep(1000);
		System.out.println(rc.sumOfNumArray);
	}
}