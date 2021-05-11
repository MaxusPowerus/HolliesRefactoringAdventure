package items;

public class Outfit extends Item {

	private int armor;

	public Outfit(String name, int value, int armor) {
		super(name, value);
		this.armor = armor;
	}

}
