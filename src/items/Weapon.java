package items;

public class Weapon extends Item {
	private double damage;

	public Weapon(String name, int value, int damage) {
		super(name, value);
		this.damage = damage;
	}

}
