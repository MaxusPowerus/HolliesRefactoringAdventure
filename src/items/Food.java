package items;

public class Food extends Item {

	private int energy;

	public Food(String name, int value, int energy) {
		super(name, value);
		this.energy = energy;
	}

}
