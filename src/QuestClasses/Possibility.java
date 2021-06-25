package QuestClasses;

public class Possibility {
	private String line;
	private String buttonLabel;
	private int chance;

	public Possibility(String line, String buttonLabel, int chance) {
		this.line = line;
		this.buttonLabel = buttonLabel;
		this.chance = chance;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

}
