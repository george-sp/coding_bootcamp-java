import java.util.ArrayList;

public class Exercise1 {

	public static void main(String[] args) {
		int[] array = {1, 3, 1, 2, 5, 6, 1, 8, 9, 12, 1, 13, 3, 1};
		ArrayList<Integer> minPositions = new ArrayList<>();

		// Assume the first is the min.
		int min = array[0];
		minPositions.add(0);
		for (int i = 1; i < array.length; i++) {
			// If there is a new min, clear the stored positions.
			if (array[i] < min) {
				min = array[i];
				minPositions.clear();
				minPositions.add(i);
			// Else store this position
			} else if (array[i] == min){
				minPositions.add(i);
			}
		}
		
		System.out.println("Min is " + min + " in positions: " + minPositions);
	}
		
}
