package exercise5_time_comparison;

import java.util.Comparator;

public class TimeComparator implements Comparator<TimeCom>{
	
	/**
	 * If the value of the difference is positive, 
	 * the first time is greater than the second time.
	 * Else if the value is negative,
	 * the second time is greater than the first time.
	 * Else if the value is zero, it checks the minutes and probably the seconds.
	 * Returns the difference of two times.
	 */
	@Override
	public int compare(TimeCom time1, TimeCom time2) {
		int timeDifference = time1.getHour() - time2.getHour();
		if (timeDifference == 0) {
			int minuteDifference = time1.getMinute() - time2.getMinute();
			if (minuteDifference == 0) {
				int secondDifference = time1.getSecond() - time2.getSecond();
				if (secondDifference == 0) {
					return 0;
				} else {
					return secondDifference;
				}
			} else {
				return minuteDifference;
			}
		} else {
			return timeDifference;
		}
	}

}
