package gui;

public enum Icon {

	BACKPACK("resources\\images\\backpack.png"), APPLE("resources\\images\\apple.png"),
	SWORD("resources\\images\\sword.png"), BREAD("resources\\images\\bread.png"), MEAT("resources\\images\\meat.png"),
	BEER("resources\\images\\beer.png");

	private String path;

	Icon(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public static Icon getByName(String name) {
		for (Icon icon : Icon.values()) {
			if (icon.toString().equalsIgnoreCase(name))
				return icon;
		}
		return null;
	}

}