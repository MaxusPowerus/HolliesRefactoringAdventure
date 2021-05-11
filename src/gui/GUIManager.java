package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import basic.Config;

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
		this.jFrame.setMinimumSize(new Dimension(Config.MIN_WINDOW_WIDTH, Config.MIN_WINDOW_HEIGHT));
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

	public void updateMainView() {
		((MainPanel) this.mainPanel).updateView();
	}

	public void updatePlayerInfoView() {
		((PlayerInfoPanel) this.playerInfoPanel).updateView();
	}

	public void updateWorldInfoView() {
		((WorldInfoPanel) this.getWorldInfoPanel()).updateView();
	}

	public void updateAllViews() {
		this.updatePlayerInfoView();
		this.updateMainView();
		this.updateWorldInfoView();

		this.jFrame.revalidate();
		this.jFrame.repaint();
	}

	public MainPanel getMainPanel() {
		return (MainPanel) mainPanel;
	}

	public PlayerInfoPanel getPlayerInfoPanel() {
		return (PlayerInfoPanel) playerInfoPanel;
	}

	public WorldInfoPanel getWorldInfoPanel() {
		return (WorldInfoPanel) worldInfoPanel;
	}

}
