package items;

public class Food extends Item {

	private int energy;

	public Food(String uniqueName, String name, int value, int energy) {
		super(uniqueName, name, value);
		this.energy = energy;
	}

}
