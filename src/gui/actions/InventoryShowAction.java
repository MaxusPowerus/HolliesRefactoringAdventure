package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GUIHelper;
import gui.MainPanel;

public class InventoryShowAction implements ActionListener {

	MainPanel mainPanel;

	public InventoryShowAction(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GUIHelper.resetPanel(this.mainPanel);

		this.mainPanel.printHeadline("Dein Beutel");
		this.mainPanel.addBackButton();

		// load items
	}

}
