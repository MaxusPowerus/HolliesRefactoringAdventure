package utilities;

import entities.Player;

public class OutfitEffect {
	private SkillSet skillBoost;

	public OutfitEffect(int st, int pe, int en, int ch, int in, int ag, int lk) {
		skillBoost = new SkillSet();
		skillBoost.setSkillValue(Skill.STRENGTH, st);
		skillBoost.setSkillValue(Skill.PERCEPTION, pe);
		skillBoost.setSkillValue(Skill.ENDURANCE, en);
		skillBoost.setSkillValue(Skill.CHARISMA, ch);
		skillBoost.setSkillValue(Skill.INTELLIGENCE, in);
		skillBoost.setSkillValue(Skill.AGILITY, ag);
		skillBoost.setSkillValue(Skill.LUCK, lk);
	}

	public SkillSet getSkillBoost() {
		return skillBoost;
	}

	public void onEquipping(Player player) {

		if (skillBoost.getSkillValue(Skill.STRENGTH) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.STRENGTH,
					player.getEffectedSkills().getSkillValue(Skill.STRENGTH) + skillBoost.getSkillValue(Skill.STRENGTH));
		}

		if (skillBoost.getSkillValue(Skill.PERCEPTION) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.PERCEPTION,
					player.getEffectedSkills().getSkillValue(Skill.PERCEPTION) + skillBoost.getSkillValue(Skill.PERCEPTION));
		}

		if (skillBoost.getSkillValue(Skill.ENDURANCE) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.ENDURANCE,
					player.getEffectedSkills().getSkillValue(Skill.ENDURANCE) + skillBoost.getSkillValue(Skill.ENDURANCE));
		}

		if (skillBoost.getSkillValue(Skill.CHARISMA) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.CHARISMA,
					player.getEffectedSkills().getSkillValue(Skill.CHARISMA) + skillBoost.getSkillValue(Skill.CHARISMA));
		}

		if (skillBoost.getSkillValue(Skill.INTELLIGENCE) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.INTELLIGENCE,
					player.getEffectedSkills().getSkillValue(Skill.INTELLIGENCE)
							+ skillBoost.getSkillValue(Skill.INTELLIGENCE));
		}

		if (skillBoost.getSkillValue(Skill.AGILITY) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.AGILITY,
					player.getEffectedSkills().getSkillValue(Skill.AGILITY) + skillBoost.getSkillValue(Skill.AGILITY));
		}

		if (skillBoost.getSkillValue(Skill.LUCK) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.LUCK,
					player.getEffectedSkills().getSkillValue(Skill.LUCK) + skillBoost.getSkillValue(Skill.LUCK));
		}
	}

	public void onDequipping(Player player) {
		if (skillBoost.getSkillValue(Skill.STRENGTH) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.STRENGTH,
					player.getEffectedSkills().getSkillValue(Skill.STRENGTH) - skillBoost.getSkillValue(Skill.STRENGTH));
		}

		if (skillBoost.getSkillValue(Skill.PERCEPTION) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.PERCEPTION,
					player.getEffectedSkills().getSkillValue(Skill.PERCEPTION) - skillBoost.getSkillValue(Skill.PERCEPTION));
		}

		if (skillBoost.getSkillValue(Skill.ENDURANCE) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.ENDURANCE,
					player.getEffectedSkills().getSkillValue(Skill.ENDURANCE) - skillBoost.getSkillValue(Skill.ENDURANCE));
		}

		if (skillBoost.getSkillValue(Skill.CHARISMA) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.CHARISMA,
					player.getEffectedSkills().getSkillValue(Skill.CHARISMA) - skillBoost.getSkillValue(Skill.CHARISMA));
		}

		if (skillBoost.getSkillValue(Skill.INTELLIGENCE) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.INTELLIGENCE,
					player.getEffectedSkills().getSkillValue(Skill.INTELLIGENCE)
							- skillBoost.getSkillValue(Skill.INTELLIGENCE));
		}

		if (skillBoost.getSkillValue(Skill.AGILITY) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.AGILITY,
					player.getEffectedSkills().getSkillValue(Skill.AGILITY) - skillBoost.getSkillValue(Skill.AGILITY));
		}

		if (skillBoost.getSkillValue(Skill.LUCK) != 0) {
			player.getEffectedSkills().setSkillValue(Skill.LUCK,
					player.getEffectedSkills().getSkillValue(Skill.LUCK) - skillBoost.getSkillValue(Skill.LUCK));
		}
	}
}
