package map;

import java.util.Random;

public enum Biom {
	
	MEADOW("WI", 60),
	FOREST("WA", 60),
	DESERT("Wü", 20),
	SWAMP("SU", 40),
	MOUNTAINS("GE", 25);

	private String name;
	private int chance;
	
	Biom(String name, int chance) {
		this.name = name;
		this.chance = chance;
	}
	
	public String getName() {
		return name;
	}
	
	public int getChance() {
		return chance;
	}
	
	public static Biom getRandomBiom() {
		Random Randy = new Random();
		
		int randInt = Randy.nextInt(Biom.values().length);
		
		return Biom.values()[randInt];
	}
	
}
