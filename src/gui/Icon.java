package gui;

public enum Icon {

	BACKPACK("GUI\\InventoryIcon.png"), MAP("GUI\\MapIcon.png"), APPLE("items\\apple.png"), SWORD("items\\sword.png"),
	BREAD("items\\bread.png"), MEAT("items\\meat.png"), BEER("items\\beer.png");

	private String path;

	Icon(String path) {
		this.path = path;
	}

	public String getPath() {
		return "resources\\images\\" + path;
	}

	public static Icon getByName(String name) {
		for (Icon icon : Icon.values()) {
			if (icon.toString().equalsIgnoreCase(name))
				return icon;
		}
		return null;
	}

}
