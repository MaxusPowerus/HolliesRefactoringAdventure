package gui.playereditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import gui.views.PlayerEditor;

public class ChangeValueButton implements ActionListener {

	private PlayerEditor playerEditor;
	private String name;
	private int value;
	private boolean levelUp;

	public ChangeValueButton(PlayerEditor playerEditor, String name, int value, boolean levelUp) {
		this.playerEditor = playerEditor;
		this.name = name;
		this.value = value;
		this.levelUp = levelUp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int points = 0;
		JLabel label = null;

		if (this.name == "perception")
			label = this.playerEditor.getPerceptionLabel();
		if (this.name == "luck")
			label = this.playerEditor.getLuckLabel();
		if (this.name == "agility")
			label = this.playerEditor.getAgilityLabel();
		if (this.name == "endurance")
			label = this.playerEditor.getEnduranceLabel();
		if (this.name == "intelligence")
			label = this.playerEditor.getIntelligenceLabel();
		if (this.name == "strength")
			label = this.playerEditor.getStrengthLabel();
		if (this.name == "charisma")
			label = this.playerEditor.getCharismaLabel();

		points = getPoints(label.getText());

		if (this.value > 0 && this.playerEditor.getPoints() > 0 && points < 10) { // add
			points++;
			this.playerEditor.setPoints(this.playerEditor.getPoints() - 1);

			if (levelUp) {
				// TODO
			}

		} else if (this.value < 0 && points > 0) { // remove
			points--;
			this.playerEditor.setPoints(this.playerEditor.getPoints() + 1);
		}

		label.setText(points + "/10");
		this.playerEditor.getLeftPointsLabel()
				.setText("<html>Noch <b>" + this.playerEditor.getPoints() + "</b> Punkte zu verteilen</html>");

	}

	private int getPoints(String label) {
		return Integer.parseInt(label.split("/")[0]);
	}

}
