package items;

public class Outfit extends Item {

	private int armor;

	public Outfit(String uniqueName, String name, int value, int armor) {
		super(uniqueName, name, value);
		this.armor = armor;
	}

	public int getArmor() {
		return armor;
	}

}
