package com.data_structures.exercises.exercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A utility class that creates insertion and union for Lists
 * 
 * @author george
 */
public class ListUtils {

	/**
	 * Creates the intersection of two Lists.
	 * 
	 * @param list1
	 * @param list2
	 * @return A List that represents the intersection of the given lists
	 */
	public static <T> List<T> intersection(List<T> list1, List<T> list2) {
		List<T> intersectionList = new ArrayList<T>();
		for (T t : list1) {
			if (list2.contains(t)) {
				intersectionList.add(t);
			}
		}
		return intersectionList;
	}

	/**
	 * Creates the union of two Lists.
	 * 
	 * @param list1
	 * @param list2
	 * @return A List that represents the union of the given lists
	 */
	public static <T> List<T> union(List<T> list1, List<T> list2) {
		Set<T> unionSet = new HashSet<T>();
		unionSet.addAll(list1);
		unionSet.addAll(list2);
		return new ArrayList<T>(unionSet);
	}
}
