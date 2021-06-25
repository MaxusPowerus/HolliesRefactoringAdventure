package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import QuestClasses.Quest;
import basic.GameManager;
import entities.Player;
import gui.GraphicalButton;
import gui.PlayerInfoPanel;
import gui.actions.InventoryShowAction;

public class QuestButton extends GraphicalButton implements ActionListener {

	private Quest quest;
	private Player player;
	private GameManager gameManager;
	private String label;
	private int possibility;
	private String possibilityString;

	public QuestButton(Quest quest, Player player, GameManager gameManager, String label, int possibility,
			String possibilityString) {
		this.quest = quest;
		this.player = player;
		this.gameManager = gameManager;
		this.label = label;
		this.possibility = possibility;
		this.possibilityString = possibilityString;

		this.setText(label);
		if (possibility != -1) {
			possibilityString += " (Wahrscheinlichkeit: " + possibility + ")";
		}
		this.setToolTipText(possibilityString);
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
					quest.getPossibilitiesButtonlabels().get(i), quest.getPossibilitiesChances().get(i),
					quest.getPossibilities().get(i));
			this.gameManager.getGuiManager().getMain().getActionButtonPanel().add(questButton);
		}

		PlayerInfoPanel.update();
		if (this.gameManager.getGuiManager().getMain().getLeftPanelHeadline().getText().contains("Inventar")) {
			new InventoryShowAction(this.gameManager, this.gameManager.getPlayer().getInventory()).updateView();
		}
		this.gameManager.update();
	}
}
