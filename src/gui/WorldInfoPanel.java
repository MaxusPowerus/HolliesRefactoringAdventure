package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import basic.Config;
import basic.GameManager;
import entities.Player;

public class WorldInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public void updateView() {
		Player player = GameManager.getInstance().getPlayer();

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		this.setBackground(Color.decode(Config.BOX_COLOR));

		this.add(GUIHelper.createTextPanel("Du befindest dich hier", player.getCurrentMapField().getBiom().getName()));
		this.add(GUIHelper.createTextPanel("Tageszeit (Stunden)",
				player.getTime().toTimeString() + " (" + player.getTime().getHours() + ")"));
	}

}
