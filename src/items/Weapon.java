package items;

public class Weapon extends Item {
	private double damage;

	public Weapon(String name, int damage) {
		super(name);
		this.damage = damage;
	}

}
