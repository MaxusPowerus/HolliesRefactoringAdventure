package entities;

public class Time {

	int hours;

	Time(int hours) {
		this.hours = hours;
	}

	public int getHours() {
		return hours;
	}

	public void addHours(int hours) {
		this.hours += hours;
	}

	public String toTimeString() {
		return this.hours % 24 <= 12 ? "Nacht" : "Tag";
	}
}
