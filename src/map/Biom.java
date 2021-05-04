package map;

import java.util.Random;

public enum Biom {
	
	FOREST("Wald"),
	DESERT("Wüste"),
	SWAMP("Sumpf"),
	MOUNTAINS("Gebirge");

	private String name;
	
	Biom(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static Biom getRandomBiom() {
		Random Randy = new Random();
		
		int randInt = Randy.nextInt(Biom.values().length);
		
		return Biom.values()[randInt];
	}
}
