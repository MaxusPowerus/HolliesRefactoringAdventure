package gui.playereditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;
import gui.views.PlayerEditor;
import utilities.Skill;

public class StartGameAction implements ActionListener {

	private PlayerEditor playerEditor;

	public StartGameAction(PlayerEditor playerEditor) {
		this.playerEditor = playerEditor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameManager gm = GameManager.getInstance();

		this.playerEditor.getStartGame().setEnabled(false);

		// set skill points
		gm.getPlayer().getSkillSet().setSkillValue(Skill.AGILITY,
				Integer.parseInt(this.playerEditor.getAgilityLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.PERCEPTION,
				Integer.parseInt(this.playerEditor.getPerceptionLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.LUCK,
				Integer.parseInt(this.playerEditor.getLuckLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.ENDURANCE,
				Integer.parseInt(this.playerEditor.getEnduranceLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.STRENGTH,
				Integer.parseInt(this.playerEditor.getStrengthLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.CHARISMA,
				Integer.parseInt(this.playerEditor.getCharismaLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.INTELLIGENCE,
				Integer.parseInt(this.playerEditor.getIntelligenceLabel().getText().split("/")[0]));

		gm.startGame();
	}
}
