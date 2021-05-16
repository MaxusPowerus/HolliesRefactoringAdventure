package utilities;

import java.util.HashMap;

public class SkillSet {

	private HashMap<Skill, Integer> skills;

	public SkillSet() {
		this.skills = new HashMap<Skill, Integer>();

		for (Skill skill : Skill.values()) {
			this.skills.put(skill, 5);
		}
	}

	public SkillSet(int st, int pe, int en, int ch, int in, int ag, int lk) {
		this.skills = new HashMap<Skill, Integer>();

		this.skills.put(Skill.STRENGTH, st);
		this.skills.put(Skill.PERCEPTION, pe);
		this.skills.put(Skill.ENDURANCE, en);
		this.skills.put(Skill.CHARISMA, ch);
		this.skills.put(Skill.INTELLIGENCE, in);
		this.skills.put(Skill.AGILITY, ag);
		this.skills.put(Skill.LUCK, lk);
	}

	public int getSkillValue(Skill skill) {
		return this.skills.get(skill);
	}

	public void setSkillValue(Skill skill, int value) {
		this.skills.put(skill, value);
	}

}
