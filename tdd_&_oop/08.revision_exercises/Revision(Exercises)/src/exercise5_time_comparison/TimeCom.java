package exercise5_time_comparison;

public class TimeCom {

	private int hour;
	private int minute;
	private int second;
	
	public TimeCom(){}
	
	public TimeCom(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public void setHour(int hour) {
		this.hour = checksHour(hour) ? hour : 0;
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public void setMinute(int minute) {
		this.minute = checksMinute(minute) ? minute : 0;
	}
	
	public int getMinute() {
		return this.minute;
	}
	
	public void setSecond(int second) {
		this.second = checksSecond(second) ? second : 0;
	}
	
	public int getSecond() {
		return this.second;
	}
	
	public void setTime(int h, int m, int s) {
		this.hour = h;
		this.minute = m;
		this.second = s;
	}
	
	public boolean checksHour(int hour) {
		return hour > 0 && hour < 23;
	}
	
	public boolean checksMinute(int hour) {
		return hour > 0 && hour < 59;
	}
	
	public boolean checksSecond(int hour) {
		return hour > 0 && hour < 59;
	}
	
	public String toString() {
		return this.hour + ":" + this.minute + ":" + this.second;
	}
}
