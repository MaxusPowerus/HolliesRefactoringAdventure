package map;

public enum Direction {

	NORTH("Norden"), EAST("Osten"), SOUTH("Süden"), WEST("Westen");

	String name;

	private Direction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
