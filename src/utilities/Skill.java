package utilities;

public enum Skill {

	STRENGTH("Stärke"), PERCEPTION("Wahrnehmung"), ENDURANCE("Ausdauer"), CHARISMA("Charisma"),
	INTELLIGENCE("Intelligenz"), AGILITY("Beweglichkeit"), LUCK("Glück");

	String name;

	Skill(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
