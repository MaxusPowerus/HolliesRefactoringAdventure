package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basic.Config;
import basic.GameManager;
import entities.Player;

public class PlayerInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public PlayerInfoPanel() {
		Player player = GameManager.getPlayer();

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
//		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		this.setBackground(Color.decode(Config.BOX_COLOR));

		JButton restartButton = new JButton();
		restartButton.setText("RESTART");
		restartButton.setBorder(new EmptyBorder(7, 20, 7, 20));
		restartButton.setFocusPainted(false);
		restartButton.setBackground(Color.decode(Config.BUTTON_COLOR));
		restartButton.setForeground(Color.WHITE);
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().restart();
			}
		});
		this.add(restartButton);

		this.add(GUIHelper.createTextPanel("Name", player.getName()), FlowLayout.LEFT);
		this.add(GUIHelper.createTextPanel("Lebenspunkte", String.valueOf(player.getHealth())), FlowLayout.CENTER);
		this.add(GUIHelper.createTextPanel("Position", player.getCurrentMapField().getCoordinate().toString()),
				FlowLayout.RIGHT);
	}

}
