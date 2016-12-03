package com.data_structures.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.data_structures.exercises.exercise1.ListUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Exercise1 starts!");
		List<Integer> listOne = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		List<Integer> listTwo = new LinkedList<Integer>(Arrays.asList(0, 2, 4, 6, 8, 10, 11, 12, 13, 14, 15));

		System.out.println("listOne: " + listOne + "\nlistTwo: " + listTwo + "\nintersectionList: "
				+ ListUtils.intersection(listOne, listTwo) + "\nunionList: " + ListUtils.union(listOne, listTwo));
	}
}
