package gui.mainPanelComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import basic.Config;
import basic.GameManager;
import basic.HelperFunctions;
import entities.NPC;
import gui.MainPanel;

public class NPCDialog extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;

	public NPCDialog(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		this.update();
	}

	private void update() {
		GameManager gameManager = GameManager.getInstance();

		Random Randy = new Random();
		NPC npc = gameManager.getResourceManager().getNpcs()
				.get(Randy.nextInt(gameManager.getResourceManager().getNpcs().size()));
		StringBuilder builder = new StringBuilder();

		if (npc.isDiscovered()) {
			builder.append("Der NPC auf diesem Feld wurde bereits entdeckt!");
		} else {
			builder.append("Huhu! ");
			builder.append(HelperFunctions.firstLetter2Upper(npc.getPrefix()));
			builder.append(" <b>");
			builder.append(HelperFunctions.firstLetter2Lower(npc.getName()));
			builder.append("</b>");
			builder.append(" ist erschienen!");
		}

		this.mainPanel.clearMainDialog();
		JLabel npcDialog = new JLabel();
		npcDialog.setFont(new Font("Dialog", Font.PLAIN, 15));
		npcDialog.setForeground(Color.decode(Config.TEXT_COLOR));
		npcDialog.setText("<html><p style=\"text-align:center;\">" + builder.toString() + "</p></html>");
		this.mainPanel.getMainDialog().add(npcDialog, BorderLayout.CENTER);
		this.mainPanel.add(this.mainPanel.getMainDialog(), BorderLayout.CENTER);
		this.mainPanel.repaintMainDialog();

		npc.setDiscovered(true);
	}

}
