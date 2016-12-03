package com.example.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTester {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable workerRunnable = new Worker(i);
			executorService.execute(workerRunnable);
		}
		executorService.shutdown();
		System.out.println("Executor Service terminated!");
	}

}
