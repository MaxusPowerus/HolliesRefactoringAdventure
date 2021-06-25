package entities;

import basic.HelperFunctions;
import map.Biom;
import utilities.Inventory;

public class NPC {

	private String name;
	private String prefix;
	private Inventory inventory;
	private boolean discovered;
	private Biom biom;

	public NPC(String name, String prefix, String biom) {
		this.name = name;
		this.prefix = prefix;
		this.discovered = false;

		switch (biom) {
		case "all":
			this.biom = null;
			break;

		case "meadow":
			this.biom = Biom.MEADOW;
			break;

		case "forest":
			this.biom = Biom.FOREST;
			break;

		case "desert":
			this.biom = Biom.DESERT;
			break;

		case "swamp":
			this.biom = Biom.SWAMP;
			break;

		case "mountains":
			this.biom = Biom.MOUNTAINS;
			break;
		}
	}

	public String getName() {
		return name;
	}

	public String getPrefix() {
		return prefix;
	}

	public Biom getBiom() {
		return biom;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}

	@Override
	public String toString() {
		return HelperFunctions.firstLetter2Upper(prefix) + " " + name;
	}

	public String toString(boolean startWithLower) {
		return HelperFunctions.firstLetter2Lower(prefix) + " " + name;
	}

}
