package items;

public class Weapon extends Item {
	private double damage;

	public Weapon(String uniqueName, String name, int value, double damage, int spwanChance) {
		super(uniqueName, name, value, spwanChance);
		this.damage = damage;
	}

	public double getDamage() {
		return damage;
	}

}
