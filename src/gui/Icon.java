package gui;

public enum Icon {

	BACKPACK("resources\\images\\rucksack.png");

	private String path;

	Icon(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
