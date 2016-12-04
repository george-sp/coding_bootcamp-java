package com.further_java.threads.exercises.exercise2;

import java.util.Vector;

public class ThreadEx extends Thread {

	private Vector<Long> vector;

	public ThreadEx(Vector<Long> vector) {
		this.vector = vector;
	}

	@Override
	public void run() {
		try {
			this.vector.add(Thread.currentThread().getId());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getId() + " interrupted");
			e.printStackTrace();
		}
	}
}
