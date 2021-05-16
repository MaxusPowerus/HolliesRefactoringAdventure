package map;

import java.util.Random;

public enum Biom {

	MEADOW(0, "Wiese", 60), FOREST(1, "Wald", 80), DESERT(2, "Wueste", 1), SWAMP(3, "Sumpf", 15),
	MOUNTAINS(4, "Gebirge", 10);

	private int id;
	private String name;
	private int chance;

	Biom(int id, String name, int chance) {
		this.id = id;
		this.name = name;
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

	public static Biom getRandomBiom() {
		Random Randy = new Random();

		int randInt = Randy.nextInt(Biom.values().length);

		return Biom.values()[randInt];
	}

}
