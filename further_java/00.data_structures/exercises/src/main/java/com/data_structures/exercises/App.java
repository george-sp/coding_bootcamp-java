package com.data_structures.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.data_structures.exercises.exercise1.ListUtils;
import com.data_structures.exercises.exercise2.IntegerComparator;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/* Exercise 1 - intersection & union methods */
		System.out.println("Exercise1 starts!");
		List<Integer> listOne = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		List<Integer> listTwo = new LinkedList<Integer>(Arrays.asList(0, 2, 4, 6, 8, 10, 11, 12, 13, 14, 15));

		System.out.println("listOne: " + listOne + "\nlistTwo: " + listTwo + "\nintersectionList: "
				+ ListUtils.intersection(listOne, listTwo) + "\nunionList: " + ListUtils.union(listOne, listTwo));

		/* Exercise 2 - PriorityQueue */
		System.out.println("Exercise2 starts!");
		// Define an IntegerComparator and a Priority Queue
		final Comparator<Integer> integerComparator = new IntegerComparator();
		Queue<Integer> queue = new PriorityQueue<Integer>(50, integerComparator);
		//
		for (int i = 60; i >= 1; i--) {
			System.out.println(i + " added to PriorityQueue: " + queue.offer(new Integer(i)));
		}
		System.out.println(queue);
		Iterator<Integer> integerIterator = queue.iterator();
		while (integerIterator.hasNext()) {
			System.out.println("remove from PriorityQueue: " + queue.remove());
		}
	}
}
