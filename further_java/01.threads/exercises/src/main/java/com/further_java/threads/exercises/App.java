package com.further_java.threads.exercises;

import com.further_java.threads.exercises.exercise1.CounterLoop;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int patience = Integer.parseInt(args[0]);

		Thread counterLoop = new CounterLoop(Integer.parseInt(args[1]));
		counterLoop.start();

		long startTime = System.currentTimeMillis();

		try {
			while (counterLoop.isAlive()) {
				counterLoop.join(1000);
				long currentTime = System.currentTimeMillis() - startTime;
				System.out.println("currentTime: " + currentTime + ", patience: " + patience);

				if (currentTime > patience) {
					System.out.println(Thread.currentThread().getName() + ": interrupts the CounterLoop");
					counterLoop.interrupt();
					counterLoop.join();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
