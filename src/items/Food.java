package items;

public class Food extends Item {

	private int energy;

	public Food(String uniqueName, String name, int value, int energy, int spwanChance) {
		super(uniqueName, name, value, spwanChance);
		this.energy = energy;
	}

	public int getEnergy() {
		return energy;
	}

}
