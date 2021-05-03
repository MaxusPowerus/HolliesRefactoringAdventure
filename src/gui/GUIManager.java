package gui;

import javax.swing.JFrame;

import basic.Config;

public class GUIManager {
	
	private JFrame jFrame;
	
	public GUIManager() {
		this.jFrame = new JFrame();
		this.jFrame.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		this.jFrame.setTitle(Config.GAME_TITLE);
		this.jFrame.setVisible(true);
	}
	
	private void printMapField() {
		
	}

}
