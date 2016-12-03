package com.example.thread_pool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * A monitor thread that will print the ThreadPoolExecutor information at
 * certain time interval.
 * 
 * @author george
 */
public class MonitorWorker implements Runnable {

	private ThreadPoolExecutor threadPoolExecutor;
	private int seconds;
	private boolean run = true;

	public MonitorWorker(ThreadPoolExecutor threadPoolExecutor, int delaySeconds) {
		this.threadPoolExecutor = threadPoolExecutor;
		this.seconds = delaySeconds;
	}

	public void shutdown() {
		this.run = false;
	}

	@Override
	public void run() {
		while (run) {
			System.out.println(String.format(
					"[WorkerMonitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
					this.threadPoolExecutor.getPoolSize(), this.threadPoolExecutor.getCorePoolSize(),
					this.threadPoolExecutor.getActiveCount(), this.threadPoolExecutor.getCompletedTaskCount(),
					this.threadPoolExecutor.getTaskCount(), this.threadPoolExecutor.isShutdown(),
					this.threadPoolExecutor.isTerminated()));
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
