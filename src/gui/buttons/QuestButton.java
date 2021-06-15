package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import QuestClasses.Quest;
import basic.GameManager;
import entities.Player;
import gui.GraphicalButton;
import gui.PlayerInfoPanel;

public class QuestButton extends GraphicalButton implements ActionListener {

	private Quest quest;
	private Player player;
	private GameManager gameManager;
	private String label;
	private int possibility;

	public QuestButton(Quest quest, Player player, GameManager gameManager, String label, int possibility) {
		this.quest = quest;
		this.player = player;
		this.gameManager = gameManager;
		this.label = label;
		this.possibility = possibility;

		this.setText(label);
		this.setToolTipText("Wahrscheinlichkeit: " + possibility);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		this.quest.update(this.label, this.player);

		this.gameManager.getGuiManager().getMain().addFieldInfo(quest.getWorldInfoLine());

		this.gameManager.getGuiManager().getMain().getActionButtonPanel().removeAll();

		for (int i = 0; i < quest.getPossibilities().size(); i++) {
			QuestButton questButton = new QuestButton(this.quest, player, this.gameManager,
					quest.getPossibilitiesButtonlabels().get(i), quest.getPossibilitiesChances().get(i));
			this.gameManager.getGuiManager().getMain().getActionButtonPanel().add(questButton);
		}

		PlayerInfoPanel.update();
		this.gameManager.update();
	}
}
