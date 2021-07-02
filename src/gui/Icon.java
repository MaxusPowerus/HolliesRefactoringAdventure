package gui;

public enum Icon {

	MAP_TOGGLER("GUI\\Buttons\\ButtonMap.png"), MAP_TOGGLER_DISABLED("GUI\\Buttons\\ButtonMap_Disabled.png"),
	MAP_TOGGLER_HIGHLIGHTED("GUI\\Buttons\\ButtonMap_Highlighted.png"),

	INV_TOGGLER("GUI\\Buttons\\ButtonInventory.png"),
	INV_TOGGLER_DISABLED("GUI\\Buttons\\ButtonInventory_Disabled.png"),
	INV_TOGGLER_HIGHLIGHTED("GUI\\Buttons\\ButtonInventory_Highlighted.png"),

	LOG_TOGGLER("GUI\\Buttons\\ButtonLog.png"), LOG_TOGGLER_DISABLED("GUI\\Buttons\\ButtonLog_Disabled.png"),
	LOG_TOGGLER_HIGHLIGHTED("GUI\\Buttons\\ButtonLog_Highlighted.png"),

	PLUS("GUI\\Buttons\\ButtonPlus.png"), PLUS_HIGHLIGHTED("GUI\\Buttons\\ButtonPlus_Highlighted.png"),
	PLUS_DISABLED("GUI\\Buttons\\ButtonPlus_Disabled.png"), MINUS("GUI\\Buttons\\ButtonMinus.png"),
	MINUS_HIGHLIGHTED("GUI\\Buttons\\ButtonMinus_Highlighted.png"),
	MINUS_DISABLED("GUI\\Buttons\\ButtonMinus_Disabled.png"),

	INV_WEAPON("GUI\\InventoryTabs\\Weapons.png"), INV_FOOD("GUI\\InventoryTabs\\Food.png"),
	INV_CLOTHES("GUI\\InventoryTabs\\Clothes.png"), INV_QUEST_ITEMS("GUI\\InventoryTabs\\QuestItems.png"),
	INV_NOTES("GUI\\InventoryTabs\\Notes.png"), INV_MISC("GUI\\InventoryTabs\\Misc.png"),

	APPLE("items\\apple.png"), SWORD("items\\sword.png"), BREAD("items\\bread.png"), MEAT("items\\meat.png"),
	BEER("items\\beer.png");

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
