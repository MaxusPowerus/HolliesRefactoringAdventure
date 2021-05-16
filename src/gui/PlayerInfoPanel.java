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
		guiManager.getHealthLabel().setText("HP (" + player.getHealth() + ")");

		guiManager.getStrengthValue().setText((int) player.getSkillSet().getSkillValue(Skill.STRENGTH) + "");
		guiManager.getPerceptionValue().setText((int) player.getSkillSet().getSkillValue(Skill.PERCEPTION) + "");
		guiManager.getPerseveranceValue().setText((int) player.getSkillSet().getSkillValue(Skill.PERSEVERANCE) + "");
		guiManager.getCharismaValue().setText((int) player.getSkillSet().getSkillValue(Skill.CHARISMA) + "");
		guiManager.getIntelligenceValue().setText((int) player.getSkillSet().getSkillValue(Skill.INTELLIGENCE) + "");
		guiManager.getSkillValue().setText((int) player.getSkillSet().getSkillValue(Skill.SKILL) + "");
		guiManager.getLuckValue().setText((int) player.getSkillSet().getSkillValue(Skill.LUCK) + "");
	}

}
