package com.example.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitorThreadPoolTester {

	public static void main(String[] args) {
		RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectedExecutionHandler);
		MonitorWorker monitorWorker = new MonitorWorker(threadPoolExecutor, 3);
		Thread monitorThread = new Thread(monitorWorker);
		monitorThread.start();
		for (int i = 0; i < 10; i++) {
			threadPoolExecutor.execute(new Worker(i));
		}

		try {
			Thread.sleep(30000);
			threadPoolExecutor.shutdown();
			Thread.sleep(5000);
			monitorWorker.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
