package gui.actions;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import basic.GameManager;
import entities.Player;
import gui.MainPanel;
import utilities.Container;
import utilities.Inventory;

public class InspectAction implements ActionListener {

	MainPanel mainPanel;

	public InspectAction(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Player player = GameManager.getInstance().getPlayer();

		Container container = player.getCurrentMapField().getContainer();
		if (container != null && !container.getFound()) {
			container.setFound(true);

			JLabel containerFound = new JLabel("Du hast ein(e) " + container.getName()
					+ " mit folgendem Inhalt gefunden: " + container.stringifyItems());
			this.mainPanel.add(containerFound, BorderLayout.CENTER);

			this.mainPanel.revalidate();
			this.mainPanel.repaint();

			// add items to player
			Inventory inv = container.getInventory();
			player.getInventory().add(container);
		}
	}

}
