package gui.views;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import basic.Config;
import basic.HelperFunctions;

public class GameOver extends JPanel {

	public GameOver() {
		setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		setLayout(null);

		JLabel gameOver = new JLabel("GAME OVER");
		gameOver.setBounds(0, 0, 1200, 800);
		gameOver.setFont(new Font("Dialog", Font.BOLD, 99));
		add(gameOver);
	}

	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon image = new ImageIcon(HelperFunctions.getResource("images/GUI/UI_Background.png"));
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}
}
