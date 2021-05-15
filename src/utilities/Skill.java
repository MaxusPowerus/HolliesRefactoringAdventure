package utilities;

public enum Skill {

	STRENGTH("Stärke"), PERCEPTION("Wahrnehmung"), PERSEVERANCE("Ausdauer"), CHARISMA("Charisma"),
	INTELLIGENCE("Intelligenz"), SKILL("Geschicklichkeit"), LUCK("Glück");

	String name;

	Skill(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
