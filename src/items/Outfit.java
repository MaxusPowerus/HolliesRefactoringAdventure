package items;

import utilities.OutfitEffect;
import utilities.Skill;

public class Outfit extends Item {

	private int armor;
	private OutfitEffect outfitFx;

	public Outfit(String uniqueName, String name, int value, int armor, int spawnChance, int stFx, int peFx, int enFx,
			int chFx, int inFx, int alFx, int lkFx) {
		super(uniqueName, name, value, spawnChance);
		this.armor = armor;
		this.outfitFx = new OutfitEffect(stFx, peFx, enFx, chFx, inFx, alFx, lkFx);
	}

	public Outfit(String uniqueName, String name, int value, int armor, int spawnChance, OutfitEffect outfitFx) {
		this(uniqueName, name, value, armor, spawnChance, outfitFx.getSkillBoost().getSkillValue(Skill.STRENGTH),
				outfitFx.getSkillBoost().getSkillValue(Skill.PERCEPTION),
				outfitFx.getSkillBoost().getSkillValue(Skill.ENDURANCE),
				outfitFx.getSkillBoost().getSkillValue(Skill.CHARISMA),
				outfitFx.getSkillBoost().getSkillValue(Skill.INTELLIGENCE),
				outfitFx.getSkillBoost().getSkillValue(Skill.AGILITY),
				outfitFx.getSkillBoost().getSkillValue(Skill.LUCK));
	}

	public int getArmor() {
		return armor;
	}

	public OutfitEffect getOutfitFx() {
		return outfitFx;
	}

}
