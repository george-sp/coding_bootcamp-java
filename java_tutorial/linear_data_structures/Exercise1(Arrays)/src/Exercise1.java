import java.util.ArrayList;

public class Exercise1 {

	public static void main(String[] args) {
		int[] array = {4, 3, 1, 2, 5, 6, 1, 8, 9, 12, 1, 13, 3, 1};
		ArrayList<Integer> minPositions = new ArrayList<>();

		// Assume the first is the min.
		int min = array[0];
		minPositions.add(0);
		
		// Using StringBuilder
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Min is ").append(min).append(" in positions: 0, ");
		for (int i = 1; i < array.length; i++) {
			// If there is a new min, clear the stored positions.
			if (array[i] < min) {
				min = array[i];
				minPositions.clear();
				minPositions.add(i);
				
				// Using StringBuilder
				stringBuilder.setLength(0);
				stringBuilder.append("Min is ")
							 .append(min)
							 .append(" in positions: ")
							 .append(i)
							 .append(", ");
			// Else store this position
			} else if (array[i] == min){
				minPositions.add(i);
				
				// Using StringBuilder
				stringBuilder.append(i).append(", ");
			}
		}
		
		System.out.println("Min is " + min + " in positions: " + minPositions);
		
		// Using StringBuilder
		System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 2));
	}
		
}
