package utilities;

public class ItemEffect {
	private SkillSet skillBoost;
	private boolean permanent;

	public ItemEffect(int st, int pe, int en, int ch, int in, int ag, int lk, boolean permanent) {
		skillBoost = new SkillSet();
		skillBoost.setSkillValue(Skill.STRENGTH, st);
		skillBoost.setSkillValue(Skill.PERCEPTION, pe);
		skillBoost.setSkillValue(Skill.ENDURANCE, en);
		skillBoost.setSkillValue(Skill.CHARISMA, ch);
		skillBoost.setSkillValue(Skill.INTELLIGENCE, in);
		skillBoost.setSkillValue(Skill.AGILITY, ag);
		skillBoost.setSkillValue(Skill.LUCK, lk);
		this.permanent = permanent;
	}

	public SkillSet getSkillBoost() {
		return skillBoost;
	}

	public boolean isPermanent() {
		return permanent;
	}

}
