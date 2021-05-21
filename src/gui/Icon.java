package gui;

public enum Icon {

	BACKPACK("backpack.png"), APPLE("apple.png"), SWORD("sword.png"), BREAD("bread.png"), MEAT("meat.png"),
	BEER("beer.png");

	private String path;

	Icon(String path) {
		this.path = path;
	}

	public String getPath() {
		return "resources\\images\\items\\" + path;
	}

	public static Icon getByName(String name) {
		for (Icon icon : Icon.values()) {
			if (icon.toString().equalsIgnoreCase(name))
				return icon;
		}
		return null;
	}

}
