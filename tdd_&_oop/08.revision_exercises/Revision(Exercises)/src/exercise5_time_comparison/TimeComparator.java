package exercise5_time_comparison;

import java.util.Comparator;

public class TimeComparator implements Comparator<TimeCom>{
	
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
