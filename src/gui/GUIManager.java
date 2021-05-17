package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
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
	private JPanel leftInfoPanel;
	private JPanel leftMainPanel;
	private JPanel actionPanel;
	private JPanel fieldInfoPanel;
	private JPanel playerInfoPanel;
	private JLabel healthLabel;
	private JProgressBar healthBar;
	private JLabel levelLabel;
	private JButton openInvButton;
	private JButton goNorthButton;
	private JButton goEastButton;
	private JButton goSouthButton;
	private JButton goWestButton;
	private JLabel lblSkills;
	private JLabel lblSt;
	private JLabel lblWa;
	private JLabel lblAu;
	private JLabel lblCh;
	private JLabel lblIn;
	private JLabel lblGe;
	private JLabel lblGl;
	private JLabel strengthValue;
	private JLabel perceptionValue;
	private JLabel perseveranceValue;
	private JLabel charismaValue;
	private JLabel intelligenceValue;
	private JLabel skillValue;
	private JLabel luckValue;
	private JPanel actionButtonPanel;
	private JPanel leftContentPanel;
	private JLabel leftPanelHeadline;
	private JProgressBar levelBar;
	private JPanel leftInfoContentPanel;
	private JPanel fieldInfos;

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

		leftInfoPanel = new JPanel();
		leftInfoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		leftInfoPanel.setBackground(Color.WHITE);

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
								.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
								.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
								.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(
												leftInfoPanel, GroupLayout.PREFERRED_SIZE, 149,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
						.addContainerGap()));

		leftInfoContentPanel = new JPanel();
		leftInfoContentPanel.setBackground(Color.WHITE);
		GroupLayout gl_leftInfoPanel = new GroupLayout(leftInfoPanel);
		gl_leftInfoPanel.setHorizontalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(leftInfoContentPanel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap()));
		gl_leftInfoPanel.setVerticalGroup(gl_leftInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(leftInfoContentPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addContainerGap()));
		GroupLayout gl_leftInfoContentPanel = new GroupLayout(leftInfoContentPanel);
		gl_leftInfoContentPanel.setHorizontalGroup(
				gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING).addGap(0, 539, Short.MAX_VALUE));
		gl_leftInfoContentPanel.setVerticalGroup(
				gl_leftInfoContentPanel.createParallelGroup(Alignment.LEADING).addGap(0, 125, Short.MAX_VALUE));
		leftInfoContentPanel.setLayout(gl_leftInfoContentPanel);
		leftInfoPanel.setLayout(gl_leftInfoPanel);

		fieldInfos = new JPanel();
		fieldInfos.setBackground(Color.WHITE);
		GroupLayout gl_fieldInfoPanel = new GroupLayout(fieldInfoPanel);
		gl_fieldInfoPanel.setHorizontalGroup(gl_fieldInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_fieldInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(fieldInfos, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE).addContainerGap()));
		gl_fieldInfoPanel.setVerticalGroup(gl_fieldInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fieldInfoPanel.createSequentialGroup().addContainerGap()
						.addComponent(fieldInfos, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(194, Short.MAX_VALUE)));
		fieldInfos.setLayout(new BoxLayout(fieldInfos, BoxLayout.Y_AXIS));
		fieldInfoPanel.setLayout(gl_fieldInfoPanel);

		actionButtonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) actionButtonPanel.getLayout();
		actionButtonPanel.setBackground(Color.WHITE);

		openInvButton = new JButton("[INV_BTN]");

		goNorthButton = new JButton("N");
		goNorthButton.addActionListener(new NavigationButtonAction(Direction.NORTH));

		goEastButton = new JButton("O");
		goEastButton.addActionListener(new NavigationButtonAction(Direction.EAST));

		goSouthButton = new JButton("S");
		goSouthButton.addActionListener(new NavigationButtonAction(Direction.SOUTH));

		goWestButton = new JButton("W");
		goWestButton.addActionListener(new NavigationButtonAction(Direction.WEST));
		GroupLayout gl_actionPanel = new GroupLayout(actionPanel);
		gl_actionPanel.setHorizontalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_actionPanel.createSequentialGroup()
						.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_actionPanel.createSequentialGroup().addGap(111).addComponent(goWestButton)
										.addGap(38).addComponent(goEastButton))
								.addGroup(gl_actionPanel.createSequentialGroup().addGap(154)
										.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(goSouthButton).addComponent(goNorthButton)))
								.addGroup(gl_actionPanel.createSequentialGroup().addContainerGap()
										.addComponent(openInvButton)))
						.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
						.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_actionPanel
				.setVerticalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createSequentialGroup().addContainerGap()
								.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_actionPanel.createSequentialGroup()
												.addComponent(actionButtonPanel, GroupLayout.DEFAULT_SIZE, 201,
														Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(gl_actionPanel.createSequentialGroup().addComponent(openInvButton)
												.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
												.addComponent(goNorthButton).addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_actionPanel.createParallelGroup(Alignment.BASELINE)
														.addComponent(goWestButton).addComponent(goEastButton))
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(goSouthButton)
												.addGap(37)))));
		actionPanel.setLayout(gl_actionPanel);

		leftPanelHeadline = new JLabel("[HEADLINE1]");
		leftPanelHeadline.setBackground(new Color(0, 0, 0));
		leftPanelHeadline.setFont(new Font("Tahoma", Font.BOLD, 12));
		leftPanelHeadline.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		leftPanelHeadline.setHorizontalAlignment(SwingConstants.CENTER);

		leftContentPanel = new JPanel();
		leftContentPanel.setBackground(Color.WHITE);
		GroupLayout gl_leftMainPanel = new GroupLayout(leftMainPanel);
		gl_leftMainPanel.setHorizontalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(leftPanelHeadline, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
				.addGroup(gl_leftMainPanel.createSequentialGroup().addGap(10)
						.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE).addGap(10)));
		gl_leftMainPanel.setVerticalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftMainPanel.createSequentialGroup()
						.addComponent(leftPanelHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
						.addContainerGap()));
		leftContentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
		gl_playerInfoPanel
				.setHorizontalGroup(
						gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(playerInfoHeadline, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
								.addGroup(gl_playerInfoPanel.createSequentialGroup().addContainerGap()
										.addComponent(skillPanel, GroupLayout.PREFERRED_SIZE, 249,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(336, Short.MAX_VALUE))
								.addComponent(playerBarPanel, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE));
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

		lblSt = new JLabel("ST");

		lblWa = new JLabel("WA");

		lblAu = new JLabel("AU");

		lblCh = new JLabel("CH");

		lblIn = new JLabel("IN");

		lblGe = new JLabel("GE");

		lblGl = new JLabel("GL");

		strengthValue = new JLabel("xx");

		perceptionValue = new JLabel("xx");

		perseveranceValue = new JLabel("xx");

		charismaValue = new JLabel("xx");

		intelligenceValue = new JLabel("xx");

		skillValue = new JLabel("xx");

		luckValue = new JLabel("xx");
		GroupLayout gl_skillPanel = new GroupLayout(skillPanel);
		gl_skillPanel.setHorizontalGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblSkills, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
				.addGroup(gl_skillPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING).addComponent(lblSt).addComponent(
								strengthValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED).addGroup(
								gl_skillPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_skillPanel.createSequentialGroup()
												.addComponent(perceptionValue, GroupLayout.PREFERRED_SIZE, 17,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(perseveranceValue, GroupLayout.PREFERRED_SIZE, 14,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(charismaValue, GroupLayout.PREFERRED_SIZE, 14,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(intelligenceValue)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(skillValue, GroupLayout.PREFERRED_SIZE, 13,
														GroupLayout.PREFERRED_SIZE)
												.addGap(17)
												.addComponent(luckValue, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(96))
										.addGroup(gl_skillPanel.createSequentialGroup().addComponent(lblWa)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAu)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblCh)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblIn)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblGe)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblGl)
												.addContainerGap(108, Short.MAX_VALUE)))));
		gl_skillPanel.setVerticalGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_skillPanel
				.createSequentialGroup().addComponent(lblSkills).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_skillPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblSt).addComponent(lblWa)
						.addComponent(lblAu).addComponent(lblCh).addComponent(lblIn).addComponent(lblGe)
						.addComponent(lblGl))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_skillPanel.createParallelGroup(Alignment.BASELINE).addComponent(strengthValue)
						.addComponent(perceptionValue).addComponent(perseveranceValue).addComponent(charismaValue)
						.addComponent(intelligenceValue).addComponent(luckValue).addComponent(skillValue))
				.addContainerGap(38, Short.MAX_VALUE)));
		skillPanel.setLayout(gl_skillPanel);

		healthLabel = new JLabel("HP (xxx)");

		healthBar = new JProgressBar();
		healthBar.setToolTipText("");

		levelLabel = new JLabel("Level X");

		levelBar = new JProgressBar();
		levelBar.setToolTipText("");
		GroupLayout gl_playerBarPanel = new GroupLayout(playerBarPanel);
		gl_playerBarPanel.setHorizontalGroup(gl_playerBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerBarPanel.createSequentialGroup().addContainerGap().addComponent(healthLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(healthBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(54).addComponent(levelLabel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(levelBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(155, Short.MAX_VALUE)));
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
		return leftInfoPanel;
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

	public JPanel getLeftMainPanel() {
		return leftMainPanel;
	}

	public JButton getBtnInventar() {
		return openInvButton;
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

	public JLabel getStrengthValue() {
		return strengthValue;
	}

	public JLabel getPerceptionValue() {
		return perceptionValue;
	}

	public JLabel getPerseveranceValue() {
		return perseveranceValue;
	}

	public JLabel getCharismaValue() {
		return charismaValue;
	}

	public JLabel getIntelligenceValue() {
		return intelligenceValue;
	}

	public JLabel getSkillValue() {
		return skillValue;
	}

	public JLabel getLuckValue() {
		return luckValue;
	}

	public JPanel getFieldInfos() {
		return fieldInfos;
	}

	public JPanel getActionButtonPanel() {
		return actionButtonPanel;
	}

	public JButton getOpenInvButton() {
		return openInvButton;
	}

	public JPanel getLeftContentPanel() {
		return leftContentPanel;
	}

	public JLabel getLeftPanelHeadline() {
		return leftPanelHeadline;
	}

	public JPanel getLeftInfoContentPanel() {
		return leftInfoContentPanel;
	}

	public JPanel getLeftInfoPanel() {
		return leftInfoPanel;
	}

	public void addFieldInfo(String info) {
		this.fieldInfos.add(new JLabel(info));

		this.frame.revalidate();
		this.frame.repaint();
	}
}
