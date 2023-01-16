package utilities;

import basic.GameManager;

public class Experience {
	private int level;
	private int xp;
	private int requiredXp;

	public Experience() {
		this.level = 1;
		this.xp = 0;
		this.requiredXp = 10;
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

	public void addXp(int xp) {
		this.addXp(xp, true);
	}

	public void addXp(int xp, boolean showHint) {
		this.xp += xp;

		if (showHint)
			GameManager.getInstance().addHint("+ " + xp + " XP");

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
		// TODO
//		GameManager.getInstance().getGuiManager().setPane(new PlayerEditor(true));
	}

}
