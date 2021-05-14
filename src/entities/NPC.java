package entities;

import utilities.Inventory;

public class NPC {

	private String name;
	private String prefix;
	private Inventory inventory;
	private boolean discovered;

	public NPC(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
		this.discovered = false;
	}

	public String getName() {
		return name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

}
