package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import basic.Config;
import entities.Player;

public class GUIManager {

	private JFrame jFrame;
	private JPanel contentPane;
	private JPanel playerInfoPanel;
	private JPanel worldInfoPanel;
	private JPanel mainPanel;

	public GUIManager() {
		this.buildWindow();
	}

	private void buildWindow() {
		this.jFrame = new JFrame();
		this.jFrame.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		this.jFrame.setTitle(Config.GAME_TITLE);
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.contentPane = new ContentPane();

		this.jFrame.setContentPane(this.contentPane);

		this.playerInfoPanel = new PlayerInfoPanel();
		this.worldInfoPanel = new WorldInfoPanel();
		this.mainPanel = new MainPanel();

		this.contentPane.add(BorderLayout.NORTH, this.playerInfoPanel);
		this.contentPane.add(BorderLayout.CENTER, this.mainPanel);
		this.contentPane.add(BorderLayout.SOUTH, this.worldInfoPanel);

		this.jFrame.setLocationRelativeTo(null);
		this.jFrame.setVisible(true);
	}

	public void destroy() {
		this.jFrame.dispose();
	}

	public void updateView(Player player) {
		((MainPanel) this.mainPanel).loadView(player);
	}

}
