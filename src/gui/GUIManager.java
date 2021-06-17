package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import basic.Config;
import basic.HelperFunctions;
import gui.actions.ResizeAction;
import gui.views.GameOver;
import gui.views.Main;
import gui.views.PlayerEditor;

public class GUIManager {

	private JFrame frame;
	private Font customFont;
	private Main main;
	private PlayerEditor playerEditor;

	public GUIManager(boolean fullscreen) {
		initialize(fullscreen);
	}

	private void initialize(boolean fullscreen) {
		try {
			FlatLightLaf.install();
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.setLookAndFeel(new FlatLightLaf());
			UIManager.getLookAndFeelDefaults().put("Desktop.background", Color.decode("#FFFFFF"));

			customFont = Font.createFont(Font.TRUETYPE_FONT, new File(HelperFunctions.getResource("Fontasy.ttf")))
					.deriveFont(70f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);

		} catch (Exception e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setTitle(Config.GAME_TITLE);
		frame.setBounds(100, 100, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentListener(new ResizeAction(this));

		if (fullscreen) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
		}

		playerEditor = new PlayerEditor();

		frame.setContentPane(playerEditor);

		frame.setVisible(true);
	}

	public Font getCustomFont() {
		return customFont;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void showGameOver() {
		GameOver gameOver = new GameOver();
		frame.setContentPane(gameOver);
	}
}