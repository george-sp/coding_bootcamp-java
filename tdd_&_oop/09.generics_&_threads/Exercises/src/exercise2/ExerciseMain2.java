package exercise2;

import java.util.Arrays;

/**
 * @author george
 *
 */
public class ExerciseMain2 {

	private static Integer[] intArray;
	private static Double[] doubleArray;

	public static void main(String[] args) {
		intArray = new Integer[10];
		doubleArray = new Double[10];
		populateArrays(10);
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(doubleArray));
		swap(intArray);
		swap(doubleArray);
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(doubleArray));
	}

	/**
	 * Swaps the first element of an array with the last, the second with the
	 * semi-last and keeps going.
	 */
	public static <T> void swap(T[] genericArray) {
		for (int i = 0; i < 5; i++) {
			T temp = genericArray[i];	
			genericArray[i] = genericArray[9 - i];
			genericArray[9 - i] = temp;
		}
	}

	/**
	 * Populates the intArray and doubleArray
	 * 
	 * @param size
	 *            the size of numbers to be added in arrays
	 */
	public static void populateArrays(int size) {
		for (int i = 1; i <= size; i++) {
			intArray[i - 1] = i;
			doubleArray[i - 1] = (double) i;
		}
	}
}
