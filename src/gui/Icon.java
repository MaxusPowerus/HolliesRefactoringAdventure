package gui;

public enum Icon {

	BACKPACK("resources\\images\\backpack.png"), APPLE("resources\\images\\apple.png"),
	SWORD("resources\\images\\sword.png");

	private String path;

	Icon(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
