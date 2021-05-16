package entities;

import map.Biom;
import utilities.SkillSet;

public class Enemy extends NPC {

	private double damage;
	private double health;
	private Biom biom;

	private SkillSet skillSet;

	public Enemy(String name, String prefix, double damage, double health, int st, int pe, int en, int ch, int in,
			int ag, int lk, String biom) {
		super(name, prefix);
		this.damage = damage;
		this.health = health;

		skillSet = new SkillSet(st, pe, en, ch, in, ag, lk);

		switch (biom) {
		case "all":
			this.biom = null;
			break;

		case "meadow":
			this.biom = Biom.MEADOW;
			break;

		case "forest":
			this.biom = Biom.FOREST;
			break;

		case "desert":
			this.biom = Biom.DESERT;
			break;

		case "swamp":
			this.biom = Biom.SWAMP;
			break;

		case "mountains":
			this.biom = Biom.MOUNTAINS;
			break;
		}

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
