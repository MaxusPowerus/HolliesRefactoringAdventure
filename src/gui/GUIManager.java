package gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;

import basic.Config;
import basic.GameManager;
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
		
		this.contentPane = new JPanel();
		
		this.playerInfoPanel = new JPanel();
		this.buildPlayerInfoPanel();
		
		this.worldInfoPanel = new JPanel();
		this.buildWorldInfoPanel();
		
//		this.mainPanel = new JPanel();
//		this.buildMainPanel();
		
		this.contentPane.add(this.playerInfoPanel);
		this.contentPane.add(this.worldInfoPanel);
		
		this.jFrame.setContentPane(this.contentPane);
		this.jFrame.setVisible(true);
	}
	
	private void buildPlayerInfoPanel() {
		Player player = GameManager.getPlayer();
		
		this.playerInfoPanel.setBackground(Color.RED);
		
		JLabel name = new JLabel();
		name.setText("Name: " + player.getName());
		name.setBounds(0, 0, 200, 20);
		this.playerInfoPanel.add(name);
		
		JLabel health = new JLabel();
		health.setText("Lebenspunkte: " + String.valueOf(player.getHealth()));	
		this.playerInfoPanel.add(health);
		
		JLabel position = new JLabel();
		position.setText("Position: " + player.getCurrentMapField().getCoordinate().toString());	
		this.playerInfoPanel.add(position);
	}
	
	private void buildWorldInfoPanel() {
		Player player = GameManager.getPlayer();
		
		this.worldInfoPanel.setBackground(Color.GREEN);

		JLabel position = new JLabel();
		position.setText("Du befindest dich: " + player.getCurrentMapField().getBiom().getName());	
		this.worldInfoPanel.add(position);

		JLabel time = new JLabel();
		time.setText("Tageszeit: " + player.getTime().getName());	
		this.worldInfoPanel.add(time);
	}
	
	private void printMapField() {
		
	}

}
