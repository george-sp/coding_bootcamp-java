package exercise5_time_comparison;

public class TesterComparator {

	public static void main(String[] args) {
		TimeComparator tc = new TimeComparator();
		System.out.println(tc.compare(new TimeCom(5, 30, 44), new TimeCom(4, 30, 44)));
		System.out.println(tc.compare(new TimeCom(5, 30, 44), new TimeCom(5, 35, 44)));
		System.out.println(tc.compare(new TimeCom(4, 30, 44), new TimeCom(4, 30, 59)));
		System.out.println(tc.compare(new TimeCom(5, 30, 44), new TimeCom(5, 30, 44)));
	}
}
