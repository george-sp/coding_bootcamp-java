package com.further_java.threads.exercises.exercise1;

/**
 * This Thread prints all numbers up to a specified counter.
 * 
 * @author george
 */
public class CounterLoop extends Thread {

	private int counter;

	public CounterLoop(int counter) {
		this.counter = counter;
		this.setName("CounterLoop");
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i <= counter; i++) {
				System.out.println(i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + ": hasn't finished!");
		}
	}
}
