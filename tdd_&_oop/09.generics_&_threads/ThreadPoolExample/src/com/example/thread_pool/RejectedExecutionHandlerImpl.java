package com.example.thread_pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * A custom implementation of RejectedExecutionHandler interface.
 * 
 * @author george
 */
public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
		System.out.println(runnable.toString() + " is rejected");
	}

}
