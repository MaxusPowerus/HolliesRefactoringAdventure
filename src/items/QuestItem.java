package items;

public class QuestItem extends Item {
	private String info;

	public QuestItem(String uniqueName, String name, String info, int value, int spwanChance) {
		super(uniqueName, name, value, spwanChance);
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

}
