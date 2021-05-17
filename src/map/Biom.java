package map;

import java.util.Random;

public enum Biom {

	MEADOW(0, "Wiese", "auf einer", 60), FOREST(1, "Wald", "in einem", 80), DESERT(2, "Wueste", "in einer", 1),
	SWAMP(3, "Sumpf", "in einem", 15), MOUNTAINS(4, "Gebirge", "in einem", 10);

	private int id;
	private String name;
	private String prefix;
	private int chance;

	Biom(int id, String name, String prefix, int chance) {
		this.id = id;
		this.name = name;
		this.prefix = prefix;
		this.chance = chance;
	}

	public String getName() {
		return name;
	}

	public int getChance() {
		return chance;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return prefix + " " + name;
	}

	public static Biom getRandomBiom() {
		Random Randy = new Random();

		int randInt = Randy.nextInt(Biom.values().length);

		return Biom.values()[randInt];
	}

}
