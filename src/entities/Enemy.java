package entities;

public class Enemy extends NPC {

	private double damage;

	public Enemy(String name, double damage) {
		super(name);
		this.damage = damage;
	}

	public double getDamage() {
		return damage;
	}

}
