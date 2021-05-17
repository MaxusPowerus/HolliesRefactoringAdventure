package entities;

import utilities.SkillSet;

public class Enemy extends NPC {

	private double damage;
	private double health;

	private SkillSet skillSet;

	public Enemy(String name, String prefix, double damage, double health, int st, int pe, int en, int ch, int in,
			int ag, int lk, String biom) {
		super(name, prefix, biom);
		this.damage = damage;
		this.health = health;

		skillSet = new SkillSet(st, pe, en, ch, in, ag, lk);

	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public double getDamage() {
		return damage;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

}
