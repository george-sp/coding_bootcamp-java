package com.data_structures.exercises.exercise2;

import java.util.Comparator;

/**
 * A custom Comparator for Integers
 * 
 * @author george
 */
public class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer int0, Integer int1) {
		return int0 - int1;
	}

}
