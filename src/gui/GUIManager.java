package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

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
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new BorderLayout());
		this.contentPane.setBackground(Color.BLUE);
		
		this.jFrame.setContentPane(this.contentPane);
		
		this.playerInfoPanel = new JPanel();
		this.buildPlayerInfoPanel();
		
		this.worldInfoPanel = new JPanel();
		this.buildWorldInfoPanel();
		
		this.mainPanel = new JPanel();
		this.buildMainPanel();
		
		this.contentPane.add(BorderLayout.NORTH, this.playerInfoPanel);
		this.contentPane.add(BorderLayout.CENTER, this.mainPanel);
		this.contentPane.add(BorderLayout.SOUTH, this.worldInfoPanel);
		
		this.jFrame.setVisible(true);
	}
	
	private void buildPlayerInfoPanel() {
		Player player = GameManager.getPlayer();
		
		this.playerInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		this.playerInfoPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		
		JButton restartButton = new JButton();
		restartButton.setText("Restart");
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameManager.getInstance().restart();
			}
		});
		this.playerInfoPanel.add(restartButton);
		
		JLabel name = new JLabel();
		name.setText("Name: " + player.getName());
		name.setBorder(new EmptyBorder(0,  80, 0, 80));
		this.playerInfoPanel.add(name, FlowLayout.LEFT);
		
		JLabel health = new JLabel();
		health.setText("Lebenspunkte: " + String.valueOf(player.getHealth()));	
		name.setBorder(new EmptyBorder(0,  80, 0, 80));
		this.playerInfoPanel.add(health, FlowLayout.CENTER);
		
		JLabel position = new JLabel();
		position.setText("Position: " + player.getCurrentMapField().getCoordinate().toString());	
		position.setBorder(new EmptyBorder(0,  80, 0, 80));
		this.playerInfoPanel.add(position, FlowLayout.RIGHT);
	}
	
	private void buildWorldInfoPanel() {
		Player player = GameManager.getPlayer();

		this.worldInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		this.worldInfoPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

		JLabel position = new JLabel();
		position.setText("Du befindest dich hier: " + player.getCurrentMapField().getBiom().getName());	
		position.setBorder(new EmptyBorder(0,  80, 0, 80));
		this.worldInfoPanel.add(position);

		JLabel time = new JLabel();
		time.setText("Tageszeit: " + player.getTime().getName());	
		time.setBorder(new EmptyBorder(0,  80, 0, 80));
		this.worldInfoPanel.add(time);
	}
	
	public void destroy() {
		this.jFrame.dispose();
	}
	
	private void buildMainPanel() {
	}
	
	private void printMapField() {
		
	}

}
