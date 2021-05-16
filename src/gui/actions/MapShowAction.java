package gui.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import basic.GameManager;

public class MapShowAction implements ActionListener {

	GameManager gameManager;

	public MapShowAction(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		initialize();
	}

	public void initialize() {
		this.gameManager.getGuiManager().getLeftContentPanel().removeAll();
		this.gameManager.getGuiManager().getLeftContentPanel().setLayout(new BorderLayout());

		this.gameManager.getGuiManager().getOpenInvButton().setText("Inventar");
		this.gameManager.getGuiManager().getOpenInvButton().removeActionListener(this);
		this.gameManager.getGuiManager().getOpenInvButton()
				.addActionListener(new InventoryShowAction(this.gameManager));

		this.gameManager.getGuiManager().getLeftPanelHeadline().setText("Map");

		this.gameManager.update();
	}

}
