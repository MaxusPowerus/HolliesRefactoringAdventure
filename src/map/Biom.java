package map;

import java.util.Random;

public enum Biom {
	
	MEADOW(0, "WI", 60),
	FOREST(1, "WA", 80),
	DESERT(2, "Wü", 1),
	SWAMP(3, "SU", 25),
	MOUNTAINS(4, "GE", 10);

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
