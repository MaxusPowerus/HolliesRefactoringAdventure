package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;

public class EscapeButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public EscapeButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Wegrennen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		// TODO

		this.gameManager.update();
	}
}
