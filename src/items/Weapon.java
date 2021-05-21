package items;

public class Weapon extends Item {
	private int damage;

	public Weapon(String uniqueName, String name, int value, int damage, int spwanChance) {
		super(uniqueName, name, value, spwanChance);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

}
