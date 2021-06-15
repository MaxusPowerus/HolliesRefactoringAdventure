package gui;

public enum Icon {

	MAP_INV_TOGGLER("GUI\\Buttons\\MapInvButton.png"),
	MAP_INV_TOGGLER_DISABLED("GUI\\Buttons\\MapInvButton_Disabled.png"),
	MAP_INV_TOGGLER_HIGHLIGHTED("GUI\\Buttons\\MapInvButton_Highlighted.png"), APPLE("items\\apple.png"),
	SWORD("items\\sword.png"), BREAD("items\\bread.png"), MEAT("items\\meat.png"), BEER("items\\beer.png");

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
