package utilities;

public enum Skill {

	STRENGTH("St�rke"), PERCEPTION("Wahrnehmung"), PERSEVERANCE("Ausdauer"), CHARISMA("Charisma"),
	INTELLIGENCE("Intelligenz"), SKILL("Geschicklichkeit"), LUCK("Gl�ck");

	String name;

	Skill(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
