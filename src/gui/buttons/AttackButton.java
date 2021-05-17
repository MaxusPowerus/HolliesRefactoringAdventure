package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Player;
import utilities.Challenge;

public class AttackButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public AttackButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Angreifen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);

		// TODO

		this.gameManager.update();
	}
}
