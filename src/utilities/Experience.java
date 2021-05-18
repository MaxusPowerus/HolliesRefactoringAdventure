package utilities;

public class Experience {
	private int level;
	private int xp;
	private int requiredXp;

	public Experience() {
		this.level = 0;
		this.xp = 0;
		this.requiredXp = 100;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public void addXp(int xp) {
		this.xp = xp;
		update();
	}

	public int getRequiredXp() {
		return requiredXp;
	}

	public void update() {
		if (this.xp >= this.requiredXp) {
			xp -= requiredXp;
			requiredXp *= 2;
			level++;
			levelUp();
		}
	}

	public void levelUp() {

	}

}
