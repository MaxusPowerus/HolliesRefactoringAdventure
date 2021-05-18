package items;

public class QuestItem extends Item {
	private String info;

	public QuestItem(String uniqueName, String name, String info, int value) {
		super(uniqueName, name, value);
		this.info = info;
	}

}
