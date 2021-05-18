package items;

public class Note extends Item {
	private String text;

	public Note(String uniqueName, String name, String text, int value) {
		super(uniqueName, name, value);
		// TODO Auto-generated constructor stub
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
