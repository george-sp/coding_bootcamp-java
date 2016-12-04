package com.data_structures.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.data_structures.exercises.exercise1.ListUtils;
import com.data_structures.exercises.exercise2.IntegerComparator;
import com.data_structures.exercises.exercise3.HashMapUtils;
import com.data_structures.exercises.exercise4.BracketFingerprint;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/* Exercise 1 - Lists intersection & union methods */
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
			if (queue.size() <= 50) {
				System.out.println(i + " added to PriorityQueue: " + queue.offer(i));
			}
		}
		System.out.println(queue);
		Iterator<Integer> integerIterator = queue.iterator();
		while (integerIterator.hasNext()) {
			System.out.println("remove from PriorityQueue: " + queue.remove());
		}

		/* Exercise 3 - HashMaps intersection */
		System.out.println("Exercise3 starts!");
		HashMap<String, Double> hashMapOne = new HashMap<String, Double>();
		hashMapOne.put("one", 1.0);
		hashMapOne.put("two", 2.0);
		// hashMapOne.put(null, 2.5);
		hashMapOne.put("three", 3.0);
		hashMapOne.put("six", null);
		hashMapOne.put("four", 4.0);
		hashMapOne.put("seven", null);
		System.out.println("hashMapOne: " + hashMapOne);
		HashMap<String, Double> hashMapTwo = new HashMap<String, Double>();
		hashMapTwo.put("two", 2.02);
		hashMapTwo.put(null, 2.5);
		hashMapTwo.put("three", 3.03);
		hashMapTwo.put("six", 6.0);
		hashMapTwo.put("four", 4.04);
		hashMapTwo.put("five", 5.05);
		hashMapTwo.put("seven", null);
		System.out.println("hashMapTwo: " + hashMapTwo);
		System.out.println("intersection: " + HashMapUtils.intersection(hashMapOne, hashMapTwo));

		/* Exercise 4 - "bracket" fingerprint */
		String snippet = "for (T t :list1){ if (list2.contains(t)){ list.add(t);}}";
		System.out.println("bracket fingerprint: " + BracketFingerprint.create(snippet));
	}
}
