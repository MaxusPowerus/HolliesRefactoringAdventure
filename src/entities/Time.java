package entities;

public enum Time {

	DAY("Tag"),
	NIGHT("Nacht");
	
	String name;
	
	Time(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
