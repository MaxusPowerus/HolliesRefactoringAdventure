package utilities;

public enum Skill {

	STRENGTH("St�rke"), PERCEPTION("Wahrnehmung"), ENDURANCE("Ausdauer"), CHARISMA("Charisma"),
	INTELLIGENCE("Intelligenz"), AGILITY("Beweglichkeit"), LUCK("Gl�ck");

	String name;

	Skill(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
