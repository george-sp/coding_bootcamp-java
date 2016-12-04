package com.data_structures.exercises.exercise3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * A utility class that creates insertion for two HashMaps
 * 
 * @author george
 */
public class HashMapUtils {

	/**
	 * Creates the intersection of two HashMaps
	 * 
	 * @param hashMap1
	 * @param hashMap2
	 * @return the intersection HashMap
	 */
	public static <E1, E2> Map<E1, E2> intersection(HashMap<E1, E2> hashMap1, HashMap<E1, E2> hashMap2) {
		Map<E1, E2> intersectionHashtable = new Hashtable<E1, E2>();
		Iterator<E1> hashMapIterator = hashMap1.keySet().iterator();
		while (hashMapIterator.hasNext()) {
			E1 hashMapOneKey = hashMapIterator.next();
			if (hashMap2.containsKey(hashMapOneKey)) {
				try {
					intersectionHashtable.put(hashMapOneKey, hashMap2.get(hashMapOneKey));
				} catch (NullPointerException e) {
					System.out.println("(" + hashMapOneKey + ", " + hashMap2.get(hashMapOneKey) + ")" + " are not put");
				}
			}
		}
		return intersectionHashtable;
	}

}
