package gui;

import java.awt.Color;

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
		guiManager.getHealthBar().setToolTipText((int) player.getHealth() + " Lebenspunkte");

		double levelProgress = (100 / player.getExperience().getRequiredXp()) * player.getExperience().getXp();
		System.out.println(player.getExperience().getXp() + ":" + levelProgress);
		int level = player.getExperience().getLevel();
		guiManager.getLevelBar().setValue((int) levelProgress);
		guiManager.getLevelLabel().setText("Level " + level);
		guiManager.getLevelBar()
				.setToolTipText(player.getExperience().getXp() + "/" + player.getExperience().getRequiredXp() + " XP");

		setSkills(guiManager, player);

		if (player.isOutfitEquipped()) {
			guiManager.getCurrentOutfit()
					.setText(player.getOutfit().getName() + " (" + player.getOutfit().getArmor() + ")");
		} else {
			guiManager.getCurrentOutfit().setText("-");
		}

		if (player.isWeaponEquipped()) {
			guiManager.getCurrentWeapon()
					.setText(player.getWeapon().getName() + " (" + player.getWeapon().getDamage() + ")");
		} else {
			guiManager.getCurrentWeapon().setText("-");
		}
	}

	private static void setSkills(GUIManager guiManager, Player player) {
		guiManager.getStrengthValue().setForeground(Color.BLACK);
		guiManager.getPerceptionValue().setForeground(Color.BLACK);
		guiManager.getEnduranceValue().setForeground(Color.BLACK);
		guiManager.getCharismaValue().setForeground(Color.BLACK);
		guiManager.getIntelligenceValue().setForeground(Color.BLACK);
		guiManager.getAgilityValue().setForeground(Color.BLACK);
		guiManager.getLuckValue().setForeground(Color.BLACK);

		// STRENGTH
		int strengthBoost = 0;
		if (player.isOutfitEquipped()) {
			strengthBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.STRENGTH);
		}
		String strengthSkill = (int) player.getSkillSet().getSkillValue(Skill.STRENGTH) + "";
		if (strengthBoost > 0) {
			strengthSkill += "(" + (strengthBoost > 0 ? "+" : "") + "" + strengthBoost + ")";
			guiManager.getStrengthValue().setForeground(strengthBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getStrengthValue().setText(strengthSkill);

		// PERCEPTION
		int perceptionBoost = 0;
		if (player.isOutfitEquipped()) {
			perceptionBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.PERCEPTION);
		}
		String perceptionSkill = (int) player.getSkillSet().getSkillValue(Skill.PERCEPTION) + "";
		if (perceptionBoost > 0) {
			perceptionSkill += "(" + (perceptionBoost > 0 ? "+" : "") + "" + perceptionBoost + ")";
			guiManager.getPerceptionValue().setForeground(perceptionBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getPerceptionValue().setText(perceptionSkill);

		// ENDURANCE
		int enduranceBoost = 0;
		if (player.isOutfitEquipped()) {
			enduranceBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.ENDURANCE);
		}
		String enduranceSkill = (int) player.getSkillSet().getSkillValue(Skill.ENDURANCE) + "";
		if (enduranceBoost > 0) {
			enduranceSkill += "(" + (enduranceBoost > 0 ? "+" : "") + "" + enduranceBoost + ")";
			guiManager.getEnduranceValue().setForeground(enduranceBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getEnduranceValue().setText(enduranceSkill);

		// CHARISMA
		int charismaBoost = 0;
		if (player.isOutfitEquipped()) {
			charismaBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.CHARISMA);
		}
		String charismaSkill = (int) player.getSkillSet().getSkillValue(Skill.CHARISMA) + "";
		if (charismaBoost != 0) {
			charismaSkill += "(" + (charismaBoost > 0 ? "+" : "") + "" + charismaBoost + ")";
			guiManager.getCharismaValue().setForeground(charismaBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getCharismaValue().setText(charismaSkill);

		// INTELLIGENCE
		int intelligenceBoost = 0;
		if (player.isOutfitEquipped()) {
			intelligenceBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.INTELLIGENCE);
		}
		String intelligenceSkill = (int) player.getSkillSet().getSkillValue(Skill.INTELLIGENCE) + "";
		if (intelligenceBoost != 0) {
			intelligenceSkill += "(" + (intelligenceBoost > 0 ? "+" : "") + "" + intelligenceBoost + ")";
			guiManager.getIntelligenceValue().setForeground(intelligenceBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getIntelligenceValue().setText(intelligenceSkill);

		// AGILITY
		int agilityBoost = 0;
		if (player.isOutfitEquipped()) {
			agilityBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.AGILITY);
		}
		String agilitySkill = (int) player.getSkillSet().getSkillValue(Skill.AGILITY) + "";
		if (agilityBoost != 0) {
			agilitySkill += "(" + (agilityBoost > 0 ? "+" : "") + "" + agilityBoost + ")";
			guiManager.getAgilityValue().setForeground(agilityBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getAgilityValue().setText(agilitySkill);

		// LUCK
		int luckBoost = 0;
		if (player.isOutfitEquipped()) {
			luckBoost = player.getOutfit().getOutfitFx().getSkillBoost().getSkillValue(Skill.LUCK);
		}
		String luckSkill = (int) player.getSkillSet().getSkillValue(Skill.LUCK) + "";
		if (luckBoost != 0) {
			luckSkill += "(" + (luckBoost > 0 ? "+" : "") + "" + luckBoost + ")";
			guiManager.getLuckValue().setForeground(luckBoost > 0 ? Color.GREEN : Color.RED);
		}
		guiManager.getLuckValue().setText(luckSkill);
	}

}
