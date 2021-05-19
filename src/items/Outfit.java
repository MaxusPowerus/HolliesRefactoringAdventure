package items;

import utilities.OutfitEffect;

public class Outfit extends Item {

	private int armor;
	private OutfitEffect outfitFx;

	public Outfit(String uniqueName, String name, int value, int armor, int spwanChance, int stFx, int peFx, int enFx,
			int chFx, int inFx, int alFx, int lkFx) {
		super(uniqueName, name, value, spwanChance);
		this.armor = armor;
		outfitFx = new OutfitEffect(stFx, peFx, enFx, chFx, inFx, alFx, lkFx);
	}

	public int getArmor() {
		return armor;
	}

	public OutfitEffect getOutfitFx() {
		return outfitFx;
	}

}
