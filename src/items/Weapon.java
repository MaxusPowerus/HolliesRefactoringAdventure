package items;

public class Weapon extends Item {
	private double damage;

	public Weapon(String uniqueName, String name, int value, int damage) {
		super(uniqueName, name, value);
		this.damage = damage;
	}

	public double getDamage() {
		return damage;
	}

}
