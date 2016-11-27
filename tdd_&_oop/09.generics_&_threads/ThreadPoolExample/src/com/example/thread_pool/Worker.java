package com.example.thread_pool;

public class Worker implements Runnable {

	private int workerID;

	public Worker(int id) {
		this.workerID = id;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " workerID = " + workerID + " -- start!");
		System.out.println(Thread.currentThread().getName() + " workerID = " + workerID + " -- end.");
	}

	private void sleepWorker(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return String.valueOf(this.workerID);
	}
}
