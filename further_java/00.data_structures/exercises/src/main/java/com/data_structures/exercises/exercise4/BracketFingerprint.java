package com.data_structures.exercises.exercise4;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * A utility class that creates "bracket" fingerprint.
 * 
 * @author george
 */
public class BracketFingerprint {

	/**
	 * Creates a bracket fingerprint based on the snippet input.
	 * 
	 * @param snippet
	 * @return the bracket fingerprint
	 */
	public static String create(String snippet) {
		String bracketFingerprint = "";
		Queue<Character> bracketQueue = new ArrayDeque<Character>();
		for (int i = 0; i < snippet.length(); i++) {
			if (snippet.charAt(i) == '{' | snippet.charAt(i) == '}') {
				bracketQueue.offer(snippet.charAt(i));
			}
		}

		for (Iterator<Character> bracketQueueIterator = bracketQueue.iterator(); bracketQueueIterator.hasNext();) {
			bracketFingerprint += bracketQueueIterator.next();
		}
		return bracketFingerprint;
	}
}
