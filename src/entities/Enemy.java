package entities;

public class Enemy extends NPC {

	private double damage;
	private double health;

	public Enemy(String name, String prefix, double damage, double health) {
		super(name, prefix);
		this.damage = damage;
		this.health = health;
	}

	public double getDamage() {
		return damage;
	}

	public double getHealth() {
		return health;
	}

}
