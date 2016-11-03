package org.afdemp.bootcamp.george;

public class Counter {

	private int mCnt = 0;
	
	public int increment() {
		return ++mCnt;
	}
	
	public int getCounter() {
		return mCnt;
	}
}
