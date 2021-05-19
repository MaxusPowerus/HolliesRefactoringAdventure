package items;

import utilities.OutfitEffect;

public class Outfit extends Item {

	private int armor;
	private OutfitEffect itemFx;

	public Outfit(String uniqueName, String name, int value, int armor, int spwanChance) {
		super(uniqueName, name, value, spwanChance);
		this.armor = armor;
		itemFx = new OutfitEffect(1, 0, 0, 0, 0, 0, 0);
	}

	public int getArmor() {
		return armor;
	}

}
