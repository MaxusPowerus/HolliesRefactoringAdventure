package utilities;

import java.util.HashMap;

public class SkillSet {

	private HashMap<Skill, Double> skills;

	public SkillSet() {
		this.skills = new HashMap<Skill, Double>();

		for (Skill skill : Skill.values()) {
			this.skills.put(skill, 5D);
		}
	}

	public double getSkillValue(Skill skill) {
		return this.skills.get(skill);
	}

	public void setSkillValue(Skill skill, double value) {
		this.skills.put(skill, value);
	}

}
