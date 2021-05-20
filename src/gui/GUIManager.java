package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import com.formdev.flatlaf.FlatLightLaf;

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
	private JPanel actionButtonPanel;
	private JPanel leftContentPanel;
	private JLabel leftPanelHeadline;
	private JProgressBar levelBar;
	private JPanel leftInfoContentPanel;
	private JPanel fieldInfos;
	private JPanel innerSkillPanel;
	private JLabel lblSt;
	private JLabel lblWa;
	private JLabel lblAu;
	private JLabel lblCh;
	private JLabel lblIn;
	private JLabel lblGe;
	private JLabel lblGl;
	private JLabel strengthValue;
	private JLabel perceptionValue;
	private JLabel enduranceValue;
	private JLabel charismaValue;
	private JLabel intelligenceValue;
	private JLabel agilityValue;
	private JLabel luckValue;
	private JPanel equippedPanel;
	private JLabel lblEquipped;
	private JPanel innerEquippedPanel;
	private JLabel lblNewLabel;
	private JLabel currentWeapon;
	private JLabel lblRstungkleidung;
	private JLabel currentOutfit;
	private JLabel fieldBackground;

	public GUIManager() {
		initialize();
	}

	private void initialize() {
		try {
			FlatLightLaf.install();
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.setLookAndFeel(new FlatLightLaf());
			UIManager.getLookAndFeelDefaults().put("Desktop.background", Color.decode("#FFFFFF"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setTitle(Config.GAME_TITLE);
		frame.setBounds(100, 100, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftMainPanel = new JPanel();
		leftMainPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		leftMainPanel.setBackground(Color.WHITE);

		playerInfoPanel = new JPanel();
		playerInfoPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		playerInfoPanel.setBackground(Color.WHITE);

		leftInfoPanel = new JPanel();
		leftInfoPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		leftInfoPanel.setBackground(Color.WHITE);

		actionPanel = new JPanel();
		actionPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		actionPanel.setBackground(Color.WHITE);

		fieldInfoPanel = new JPanel();
		fieldInfoPanel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		fieldInfoPanel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
								.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
								.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE).addGap(0))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(playerInfoPanel, GroupLayout.PREFERRED_SIZE, 154,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
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
		fieldInfoPanel.setLayout(null);

		fieldInfos = new JPanel();
		fieldInfos.setBounds(16, 16, 568, 296);
		fieldInfos.setBackground(new Color(0, 0, 0, 0.3f));
		fieldInfos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		fieldInfos.setLayout(new BoxLayout(fieldInfos, BoxLayout.Y_AXIS));
		fieldInfoPanel.add(fieldInfos);

		fieldBackground = new JLabel("");
		fieldBackground.setBounds(0, 0, 599, 329);
		fieldInfoPanel.add(fieldBackground);

		actionButtonPanel = new JPanel();
		actionButtonPanel.setBackground(Color.WHITE);

		openInvButton = new JButton("[INV_BTN]");

		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.WHITE);
		GroupLayout gl_actionPanel = new GroupLayout(actionPanel);
		gl_actionPanel.setHorizontalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_actionPanel
				.createSequentialGroup()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createSequentialGroup().addGap(10).addComponent(openInvButton)
								.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING,
								gl_actionPanel.createSequentialGroup().addContainerGap()
										.addComponent(navigationPanel, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(114)))
				.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		gl_actionPanel.setVerticalGroup(gl_actionPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_actionPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addComponent(openInvButton)
						.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(gl_actionPanel
						.createSequentialGroup().addContainerGap(84, Short.MAX_VALUE).addComponent(navigationPanel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(46)));
		navigationPanel.setLayout(new GridLayout(3, 3, 0, 0));

		JLabel label = new JLabel("");
		navigationPanel.add(label);

		goNorthButton = new JButton("N");
		navigationPanel.add(goNorthButton);
		goNorthButton.setFont(new Font("Tahoma", Font.PLAIN, 28));

		JLabel lblNewLabel_1 = new JLabel("");
		navigationPanel.add(lblNewLabel_1);

		goWestButton = new JButton("W");
		navigationPanel.add(goWestButton);
		goWestButton.setFont(new Font("Tahoma", Font.PLAIN, 28));

		JLabel label_2 = new JLabel("");
		navigationPanel.add(label_2);

		goEastButton = new JButton("O");
		navigationPanel.add(goEastButton);
		goEastButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		goEastButton.addActionListener(new NavigationButtonAction(Direction.EAST));

		JLabel label_3 = new JLabel("");
		navigationPanel.add(label_3);

		goSouthButton = new JButton("S");
		navigationPanel.add(goSouthButton);
		goSouthButton.setFont(new Font("Tahoma", Font.PLAIN, 28));
		goSouthButton.addActionListener(new NavigationButtonAction(Direction.SOUTH));

		JLabel label_1 = new JLabel("");
		navigationPanel.add(label_1);
		goWestButton.addActionListener(new NavigationButtonAction(Direction.WEST));
		goNorthButton.addActionListener(new NavigationButtonAction(Direction.NORTH));
		actionButtonPanel.setLayout(new GridLayout(5, 1, 0, 0));
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
				.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE));
		gl_leftMainPanel.setVerticalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftMainPanel.createSequentialGroup()
						.addComponent(leftPanelHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)));
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

		equippedPanel = new JPanel();
		equippedPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		equippedPanel.setBackground(Color.WHITE);

		lblEquipped = new JLabel("Ausr\u00FCstung");
		lblEquipped.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipped.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipped.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		innerEquippedPanel = new JPanel();
		innerEquippedPanel.setBackground(Color.WHITE);
		innerEquippedPanel.setLayout(new GridLayout(0, 2, 0, 0));
		GroupLayout gl_equippedPanel = new GroupLayout(equippedPanel);
		gl_equippedPanel.setHorizontalGroup(
				gl_equippedPanel.createParallelGroup(Alignment.LEADING).addGap(0, 226, Short.MAX_VALUE)
						.addComponent(lblEquipped, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
						.addComponent(innerEquippedPanel, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE));
		gl_equippedPanel
				.setVerticalGroup(gl_equippedPanel.createParallelGroup(Alignment.LEADING).addGap(0, 71, Short.MAX_VALUE)
						.addGroup(gl_equippedPanel.createSequentialGroup().addComponent(lblEquipped)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(innerEquippedPanel, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)));

		lblNewLabel = new JLabel("Waffe: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		innerEquippedPanel.add(lblNewLabel);

		currentWeapon = new JLabel("-");
		innerEquippedPanel.add(currentWeapon);

		lblRstungkleidung = new JLabel("Kleidung/R\u00FCstung: ");
		lblRstungkleidung.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRstungkleidung.setHorizontalAlignment(SwingConstants.RIGHT);
		innerEquippedPanel.add(lblRstungkleidung);

		currentOutfit = new JLabel("-");
		innerEquippedPanel.add(currentOutfit);
		equippedPanel.setLayout(gl_equippedPanel);
		GroupLayout gl_playerInfoPanel = new GroupLayout(playerInfoPanel);
		gl_playerInfoPanel.setHorizontalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(playerInfoHeadline, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
				.addComponent(playerBarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING,
						gl_playerInfoPanel.createSequentialGroup().addContainerGap()
								.addComponent(skillPanel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(equippedPanel, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
								.addContainerGap()));
		gl_playerInfoPanel.setVerticalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(playerInfoHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(playerBarPanel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(skillPanel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(equippedPanel, GroupLayout.PREFERRED_SIZE, 71,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(8, Short.MAX_VALUE)));

		lblSkills = new JLabel("Skills");
		lblSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSkills.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblSkills.setHorizontalAlignment(SwingConstants.CENTER);

		innerSkillPanel = new JPanel();
		innerSkillPanel.setBackground(Color.WHITE);
		GroupLayout gl_skillPanel = new GroupLayout(skillPanel);
		gl_skillPanel.setHorizontalGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblSkills, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
				.addComponent(innerSkillPanel, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE));
		gl_skillPanel.setVerticalGroup(gl_skillPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_skillPanel.createSequentialGroup().addComponent(lblSkills)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(innerSkillPanel, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)));
		innerSkillPanel.setLayout(new GridLayout(0, 7, 0, 0));

		lblSt = new JLabel("ST");
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSt.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblSt);

		lblWa = new JLabel("WA");
		lblWa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWa.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblWa);

		lblAu = new JLabel("AU");
		lblAu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAu.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblAu);

		lblCh = new JLabel("CH");
		lblCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCh.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblCh);

		lblIn = new JLabel("IN");
		lblIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIn.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblIn);

		lblGe = new JLabel("GE");
		lblGe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGe.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblGe);

		lblGl = new JLabel("GL");
		lblGl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGl.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(lblGl);

		strengthValue = new JLabel("x");
		strengthValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(strengthValue);

		perceptionValue = new JLabel("x");
		perceptionValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(perceptionValue);

		enduranceValue = new JLabel("x");
		enduranceValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(enduranceValue);

		charismaValue = new JLabel("x");
		charismaValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(charismaValue);

		intelligenceValue = new JLabel("x");
		intelligenceValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(intelligenceValue);

		agilityValue = new JLabel("x");
		agilityValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(agilityValue);

		luckValue = new JLabel("x");
		luckValue.setHorizontalAlignment(SwingConstants.CENTER);
		innerSkillPanel.add(luckValue);
		skillPanel.setLayout(gl_skillPanel);

		healthLabel = new JLabel("Lebenspunkte");

		healthBar = new JProgressBar();
		healthBar.setForeground(Color.RED);

		levelLabel = new JLabel("Level X");

		levelBar = new JProgressBar();
		levelBar.setToolTipText("");
		GroupLayout gl_playerBarPanel = new GroupLayout(playerBarPanel);
		gl_playerBarPanel.setHorizontalGroup(gl_playerBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerBarPanel.createSequentialGroup().addContainerGap().addComponent(healthLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(healthBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE).addComponent(levelLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(levelBar, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_playerBarPanel.setVerticalGroup(gl_playerBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerBarPanel.createSequentialGroup().addGap(5).addGroup(gl_playerBarPanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(healthBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(gl_playerBarPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(levelLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(healthLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(levelBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
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

	public JLabel getAgilityValue() {
		return agilityValue;
	}

	public JLabel getEnduranceValue() {
		return enduranceValue;
	}

	public JLabel getCharismaValue() {
		return charismaValue;
	}

	public JLabel getIntelligenceValue() {
		return intelligenceValue;
	}

	public JLabel getLuckValue() {
		return luckValue;
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

	public JPanel getFieldInfos() {
		return fieldInfos;
	}

	public JLabel getCurrentOutfit() {
		return currentOutfit;
	}

	public JLabel getCurrentWeapon() {
		return currentWeapon;
	}

	public JLabel getFieldBackground() {
		return fieldBackground;
	}

	public void setNavigationEnabled(boolean enabled) {
		this.goNorthButton.setEnabled(enabled);
		this.goEastButton.setEnabled(enabled);
		this.goSouthButton.setEnabled(enabled);
		this.goWestButton.setEnabled(enabled);
	}

	public void addFieldInfo(String info) {
		JLabel label = new JLabel("<html>" + info + "</html>");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));
		this.fieldInfos.add(label);

		this.frame.revalidate();
		this.frame.repaint();
	}
}