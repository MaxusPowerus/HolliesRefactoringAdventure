package gui;

import basic.GameManager;
import entities.Player;
import utilities.Skill;

public class PlayerInfoPanel {

	public static void update() {
		GameManager gameManager = GameManager.getInstance();
		GUIManager guiManager = gameManager.getGuiManager();
		Player player = gameManager.getPlayer();

		guiManager.getHealthBar().setValue((int) player.getHealth());
		guiManager.getHealthLabel().setText("HP");
		guiManager.getHealthBar().setToolTipText(player.getHealth() + "");

		double levelProgress = (100 / player.getExperience().getRequiredXp()) * player.getExperience().getXp();
		System.out.println(player.getExperience().getXp() + ":" + levelProgress);
		int level = player.getExperience().getLevel();
		guiManager.getLevelBar().setValue((int) levelProgress);
		guiManager.getLevelLabel().setText("Level " + level);
		guiManager.getLevelBar()
				.setToolTipText(player.getExperience().getXp() + "/" + player.getExperience().getRequiredXp());

		guiManager.getStrengthValue().setText((int) player.getSkillSet().getSkillValue(Skill.STRENGTH) + "");
		guiManager.getPerceptionValue().setText((int) player.getSkillSet().getSkillValue(Skill.PERCEPTION) + "");
		guiManager.getEnduranceValue().setText((int) player.getSkillSet().getSkillValue(Skill.ENDURANCE) + "");
		guiManager.getCharismaValue().setText((int) player.getSkillSet().getSkillValue(Skill.CHARISMA) + "");
		guiManager.getIntelligenceValue().setText((int) player.getSkillSet().getSkillValue(Skill.INTELLIGENCE) + "");
		guiManager.getAgilityValue().setText((int) player.getSkillSet().getSkillValue(Skill.AGILITY) + "");
		guiManager.getLuckValue().setText((int) player.getSkillSet().getSkillValue(Skill.LUCK) + "");
	}

}
