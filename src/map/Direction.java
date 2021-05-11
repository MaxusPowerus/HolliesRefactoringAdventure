package map;

public enum Direction {

	NORTH("Norden"), EAST("Osten"), SOUTH("S�den"), WEST("Westen");

	String name;

	private Direction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
