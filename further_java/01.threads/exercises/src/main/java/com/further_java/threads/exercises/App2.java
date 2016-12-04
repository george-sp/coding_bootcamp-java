package com.further_java.threads.exercises;

import java.util.Iterator;
import java.util.Vector;

import com.further_java.threads.exercises.exercise2.ThreadEx;

public class App2 {
	public static void main(String[] args) {
		/*
		 * Exercise 2
		 */
		System.out.println("Exercise 2");
		Vector<Long> vector = new Vector<Long>(0, 1);
		System.out.println("The initial size of the collection: " + vector.size());

		Thread thread1 = new ThreadEx(vector);
		Thread thread2 = new ThreadEx(vector);
		Thread thread3 = new ThreadEx(vector);

		thread1.start();
		thread2.start();
		thread3.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("a. The size of the collection: " + vector.size() + "\nb. The collection's contents:");
		for (Iterator<Long> vectorIterate = vector.iterator(); vectorIterate.hasNext();) {
			System.out.println(vectorIterate.next());
		}

	}
}
