package entities;

import utilities.SkillSet;

public class Victim extends NPC {

	private double damage;
	private double health;
	private int xp;

	private SkillSet skillSet;

	public Victim(String name, String prefix, double health, int st, int pe, int en, int ch, int in, int ag, int lk,
			String biom, int xp) {
		super(name, prefix, biom);
		this.health = health;
		this.xp = xp;

		skillSet = new SkillSet(st, pe, en, ch, in, ag, lk);

	}

	public SkillSet getSkillSet() {
		return skillSet;
	}

	public int getXp() {
		return xp;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

}
