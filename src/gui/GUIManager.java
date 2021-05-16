package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import basic.Config;
import gui.actions.NavigationButtonAction;
import map.Direction;

public class GUIManager {

	private JFrame frame;
	private JPanel mapInfoPanel;
	private JPanel leftMainPanel;
	private JPanel actionPanel;
	private JPanel fieldInfoPanel;
	private JPanel playerInfoPanel;
	private JLabel challengeState;
	private JButton inspectButton;
	private JLabel healthLabel;
	private JProgressBar healthBar;
	private JLabel levelLabel;
	private JProgressBar levelBar;
	private JButton btnInventar;
	private JButton goNorthButton;
	private JButton goEastButton;
	private JButton goSouthButton;
	private JButton goWestButton;
	private JLabel currentFieldBiomLabel;
	private JLabel lblSkills;

	public GUIManager() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle(Config.GAME_TITLE);
		frame.setBounds(100, 100, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftMainPanel = new JPanel();
		leftMainPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		leftMainPanel.setBackground(Color.WHITE);

		playerInfoPanel = new JPanel();
		playerInfoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		playerInfoPanel.setBackground(Color.WHITE);

		mapInfoPanel = new JPanel();
		mapInfoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		mapInfoPanel.setBackground(Color.WHITE);

		actionPanel = new JPanel();
		actionPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		actionPanel.setBackground(Color.WHITE);

		fieldInfoPanel = new JPanel();
		fieldInfoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fieldInfoPanel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(mapInfoPanel, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
								.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
								.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(mapInfoPanel,
										GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(playerInfoPanel, GroupLayout.PREFERRED_SIZE, 178,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fieldInfoPanel, GroupLayout.PREFERRED_SIZE, 324,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(actionPanel,
										GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));

		currentFieldBiomLabel = new JLabel("[BIOM]");

		challengeState = new JLabel("[CHALLENGE_STATE]");

		inspectButton = new JButton("Untersuchen");
		GroupLayout gl_mapInfoPanel = new GroupLayout(mapInfoPanel);
		gl_mapInfoPanel.setHorizontalGroup(gl_mapInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mapInfoPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_mapInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(currentFieldBiomLabel)
								.addGroup(gl_mapInfoPanel.createSequentialGroup().addComponent(challengeState)
										.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
										.addComponent(inspectButton)))
						.addContainerGap()));
		gl_mapInfoPanel
				.setVerticalGroup(gl_mapInfoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mapInfoPanel.createSequentialGroup().addContainerGap()
								.addComponent(currentFieldBiomLabel).addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_mapInfoPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(challengeState).addComponent(inspectButton))
								.addContainerGap(51, Short.MAX_VALUE)));
		mapInfoPanel.setLayout(gl_mapInfoPanel);

		JPanel actionButtonPanel = new JPanel();

		btnInventar = new JButton("Inventar");

		goNorthButton = new JButton("N");
		goNorthButton.addActionListener(new NavigationButtonAction(Direction.NORTH));

		goEastButton = new JButton("O");
		goEastButton.addActionListener(new NavigationButtonAction(Direction.EAST));

		goSouthButton = new JButton("S");
		goSouthButton.addActionListener(new NavigationButtonAction(Direction.SOUTH));

		goWestButton = new JButton("W");
		goWestButton.addActionListener(new NavigationButtonAction(Direction.WEST));
		GroupLayout gl_actionPanel = new GroupLayout(actionPanel);
		gl_actionPanel.setHorizontalGroup(gl_actionPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_actionPanel
				.createSequentialGroup()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createSequentialGroup()
								.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_actionPanel.createSequentialGroup().addGap(111)
												.addComponent(goWestButton).addGap(38).addComponent(goEastButton))
										.addGroup(gl_actionPanel.createSequentialGroup().addGap(154)
												.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(goSouthButton).addComponent(goNorthButton))))
								.addPreferredGap(ComponentPlacement.RELATED, 262, Short.MAX_VALUE).addComponent(
										actionButtonPanel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_actionPanel.createSequentialGroup().addContainerGap().addComponent(btnInventar)))
				.addContainerGap()));
		gl_actionPanel.setVerticalGroup(gl_actionPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_actionPanel
				.createSequentialGroup().addContainerGap().addComponent(btnInventar)
				.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createSequentialGroup().addComponent(goNorthButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_actionPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(goWestButton).addComponent(goEastButton))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(goSouthButton))
						.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				.addGap(24)));

		JButton action1Button = new JButton("Aktion 1");
		actionButtonPanel.add(action1Button);

		JButton action2Button = new JButton("Aktion 2");
		actionButtonPanel.add(action2Button);

		JButton action3Button = new JButton("Aktion 3");
		actionButtonPanel.add(action3Button);
		actionPanel.setLayout(gl_actionPanel);

		JLabel lblNewLabel = new JLabel("Du bist in...");

		JLabel lblDuSiehst = new JLabel("Du siehst...");

		JLabel lblDirGelingt = new JLabel("Dir gelingt...");
		GroupLayout gl_fieldInfoPanel = new GroupLayout(fieldInfoPanel);
		gl_fieldInfoPanel.setHorizontalGroup(gl_fieldInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fieldInfoPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_fieldInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDuSiehst, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addComponent(lblDirGelingt, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
						.addContainerGap()));
		gl_fieldInfoPanel.setVerticalGroup(gl_fieldInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fieldInfoPanel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDuSiehst)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDirGelingt)
						.addContainerGap(104, Short.MAX_VALUE)));
		fieldInfoPanel.setLayout(gl_fieldInfoPanel);

		JLabel leftPanelHeadline = new JLabel("Map");
		leftPanelHeadline.setFont(new Font("Tahoma", Font.BOLD, 12));
		leftPanelHeadline.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		leftPanelHeadline.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel mapPanel = new JPanel();
		mapPanel.setBackground(new Color(107, 142, 35));
		GroupLayout gl_leftMainPanel = new GroupLayout(leftMainPanel);
		gl_leftMainPanel.setHorizontalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(leftPanelHeadline, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
				.addGroup(gl_leftMainPanel.createSequentialGroup().addGap(40)
						.addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						.addGap(31)));
		gl_leftMainPanel.setVerticalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftMainPanel.createSequentialGroup()
						.addComponent(leftPanelHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(39).addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(46, Short.MAX_VALUE)));
		leftMainPanel.setLayout(gl_leftMainPanel);

		JLabel playerInfoHeadline = new JLabel(">>> Die kleine Holly <<<");
		playerInfoHeadline.setFont(new Font("Tahoma", Font.BOLD, 12));
		playerInfoHeadline.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		playerInfoHeadline.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel playerBarPanel = new JPanel();
		playerBarPanel.setBackground(Color.WHITE);

		JPanel skillPanel = new JPanel();
		skillPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		skillPanel.setBackground(Color.WHITE);
		GroupLayout gl_playerInfoPanel = new GroupLayout(playerInfoPanel);
		gl_playerInfoPanel.setHorizontalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(playerInfoHeadline, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
				.addGroup(gl_playerInfoPanel.createSequentialGroup().addGap(10)
						.addComponent(playerBarPanel, GroupLayout.PREFERRED_SIZE, 575, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(Alignment.TRAILING,
						gl_playerInfoPanel.createSequentialGroup().addContainerGap(361, Short.MAX_VALUE)
								.addComponent(skillPanel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_playerInfoPanel.setVerticalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(playerInfoHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(playerBarPanel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(skillPanel, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE).addContainerGap()));

		lblSkills = new JLabel("Skills");
		lblSkills.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblSkills.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_skillPanel = new GroupLayout(skillPanel);
		gl_skillPanel.setHorizontalGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING).addComponent(lblSkills,
				GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE));
		gl_skillPanel.setVerticalGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_skillPanel.createSequentialGroup().addComponent(lblSkills).addContainerGap(78, Short.MAX_VALUE)));
		skillPanel.setLayout(gl_skillPanel);

		healthLabel = new JLabel("HP (xxx)");

		healthBar = new JProgressBar();

		levelLabel = new JLabel("Level X");

		levelBar = new JProgressBar();
		GroupLayout gl_playerBarPanel = new GroupLayout(playerBarPanel);
		gl_playerBarPanel.setHorizontalGroup(gl_playerBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerBarPanel.createSequentialGroup().addContainerGap().addComponent(healthLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(healthBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(108).addComponent(levelLabel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(levelBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(81)));
		gl_playerBarPanel
				.setVerticalGroup(
						gl_playerBarPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_playerBarPanel.createSequentialGroup().addGap(5)
										.addGroup(gl_playerBarPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(levelBar, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(levelLabel)
												.addComponent(healthBar, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(healthLabel))
										.addContainerGap()));
		playerBarPanel.setLayout(gl_playerBarPanel);
		playerInfoPanel.setLayout(gl_playerInfoPanel);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JLabel getHealthLabel() {
		return healthLabel;
	}

	public JProgressBar getHealthBar() {
		return healthBar;
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}

	public JProgressBar getLevelBar() {
		return levelBar;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getMapInfoPanel() {
		return mapInfoPanel;
	}

	public JPanel getMapPanel() {
		return leftMainPanel;
	}

	public JPanel getActionPanel() {
		return actionPanel;
	}

	public JPanel getFieldInfoPanel() {
		return fieldInfoPanel;
	}

	public JPanel getPlayerInfoPanel() {
		return playerInfoPanel;
	}

	public JLabel getCurrentFieldBiomLabel() {
		return currentFieldBiomLabel;
	}

	public JPanel getLeftMainPanel() {
		return leftMainPanel;
	}

	public JLabel getChallengeState() {
		return challengeState;
	}

	public JButton getInspectButton() {
		return inspectButton;
	}

	public JButton getBtnInventar() {
		return btnInventar;
	}

	public JButton getGoNorthButton() {
		return goNorthButton;
	}

	public JButton getGoEastButton() {
		return goEastButton;
	}

	public JButton getGoSouthButton() {
		return goSouthButton;
	}

	public JButton getGoWestButton() {
		return goWestButton;
	}

}
