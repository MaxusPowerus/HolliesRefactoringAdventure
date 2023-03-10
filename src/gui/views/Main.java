package gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import QuestClasses.Quest;
import basic.Config;
import basic.GameManager;
import basic.HelperFunctions;
import gui.BackgroundImagePanel;
import gui.GUIHelper;
import gui.GUIManager;
import gui.Icon;
import gui.actions.NavigationButtonAction;
import map.Direction;
import utilities.Coordinate;

public class Main extends JLabel {
	private JPanel leftInfoPanel;
	private JPanel leftMainPanel;
	private JPanel actionPanel;
	private JPanel fieldInfoPanel;
	private JPanel playerInfoPanel;
	private JLabel healthLabel;
	private JProgressBar healthBar;
	private JLabel levelLabel;
	private JButton invButton;
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
	private JPanel mapPanel;
	private JPanel inventoryPanel;
	private JPanel backgroundImagePanel;
	private BackgroundImagePanel compassBackgroundPanel;
	private JLabel playerInfoHeadline;
	private JPanel hintPanel;
	private JButton logButton;
	private JButton mapButton;
	private JPanel logPanel;

	public Main() {

		setBounds(0, 0, Config.WINDOW_WIDTH - 10, Config.WINDOW_HEIGHT - 10);

		leftMainPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		leftMainPanel.setOpaque(false);
		leftMainPanel.setBorder(null);
		leftMainPanel.setBackground(new Color(0, 0, 0, 0));

		playerInfoPanel = new JPanel();
		playerInfoPanel.setBorder(null);
		playerInfoPanel.setBackground(new Color(0, 0, 0, 0));

		leftInfoPanel = new JPanel();
		leftInfoPanel.setBorder(null);
		leftInfoPanel.setBackground(new Color(0, 0, 0, 0.4f));

		actionPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		actionPanel.setOpaque(false);
		actionPanel.setBorder(null);
		actionPanel.setBackground(new Color(0, 0, 0, 0));

		fieldInfoPanel = new JPanel();
		fieldInfoPanel.setBorder(null);
		fieldInfoPanel.setBackground(new Color(0, 0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
								.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(fieldInfoPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 598,
										Short.MAX_VALUE)
								.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5).addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(leftMainPanel, GroupLayout.PREFERRED_SIZE, 581,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(playerInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(actionPanel,
										GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))
						.addGap(3)));

		leftInfoContentPanel = new JPanel();
		leftInfoContentPanel.setBackground(new Color(0, 0, 0, 0));
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
		fieldInfoPanel.setOpaque(true);

		fieldInfos = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		fieldInfos.setOpaque(false);
		fieldInfos.setBounds(6, 6, 589, 276);
		fieldInfos.setBackground(new Color(0f, 0f, 0f, 0.4F));
		fieldInfos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		fieldInfos.setLayout(new BoxLayout(fieldInfos, BoxLayout.Y_AXIS));
		fieldInfoPanel.add(fieldInfos);

		fieldBackground = new JLabel("");
		fieldBackground.setBounds(0, 0, 599, 288);
		fieldInfoPanel.add(fieldBackground);

		actionButtonPanel = new JPanel();
		actionButtonPanel.setBackground(new Color(0, 0, 0, 0));

		invButton = new JButton("");
		invButton.setContentAreaFilled(false);
		invButton.setIcon(GUIHelper.getIcon(Icon.INV_TOGGLER, 75, 75));
		invButton.setRolloverIcon(GUIHelper.getIcon(Icon.INV_TOGGLER_HIGHLIGHTED, 75, 75));
		invButton.setDisabledIcon(GUIHelper.getIcon(Icon.INV_TOGGLER_DISABLED, 75, 75));

		this.updateCompass();

		goNorthButton = new JButton();
		goNorthButton
				.setIcon(new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_N.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goNorthButton.setRolloverIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_N_Highlighted.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goNorthButton.setDisabledIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_N_Disabled.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goNorthButton.setBackground(new Color(0, 0, 0, 0));
		goNorthButton.setContentAreaFilled(false);
		goNorthButton.setBorder(null);
		goNorthButton.setBounds(100, 42, 50, 50);
		compassBackgroundPanel.add(goNorthButton);

		goSouthButton = new JButton();
		goSouthButton
				.setIcon(new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_S.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goSouthButton.setRolloverIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_S_Highlighted.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goSouthButton.setDisabledIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_S_Disabled.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goSouthButton.setBackground(new Color(0, 0, 0, 0));
		goSouthButton.setContentAreaFilled(false);
		goSouthButton.setBorder(null);
		goSouthButton.setBounds(100, 158, 50, 50);
		compassBackgroundPanel.add(goSouthButton);

		goWestButton = new JButton();
		goWestButton
				.setIcon(new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_W.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goWestButton.setRolloverIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_W_Highlighted.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goWestButton.setDisabledIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_W_Disabled.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goWestButton.setBackground(new Color(0, 0, 0, 0));
		goWestButton.setContentAreaFilled(false);
		goWestButton.setBorder(null);
		goWestButton.setBounds(47, 99, 50, 50);
		compassBackgroundPanel.add(goWestButton);
		goWestButton.setFont(new Font("Tahoma", Font.PLAIN, 28));

		goEastButton = new JButton();
		goEastButton
				.setIcon(new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_O.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goEastButton.setRolloverIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_O_Highlighted.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goEastButton.setDisabledIcon(
				new ImageIcon(new ImageIcon(HelperFunctions.getResource("images/GUI/Buttons/Compass_O_Disabled.png"))
						.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)));
		goEastButton.setBackground(new Color(0, 0, 0, 0));
		goEastButton.setContentAreaFilled(false);
		goEastButton.setBorder(null);
		goEastButton.setBounds(156, 98, 50, 50);
		compassBackgroundPanel.add(goEastButton);
		goEastButton.setFont(new Font("Tahoma", Font.PLAIN, 28));

		goEastButton.addActionListener(new NavigationButtonAction(Direction.EAST));
		goWestButton.addActionListener(new NavigationButtonAction(Direction.WEST));
		goSouthButton.addActionListener(new NavigationButtonAction(Direction.SOUTH));
		goNorthButton.addActionListener(new NavigationButtonAction(Direction.NORTH));

		mapButton = new JButton("");
		mapButton.setContentAreaFilled(false);
		mapButton.setIcon(GUIHelper.getIcon(Icon.MAP_TOGGLER, 75, 75));
		mapButton.setRolloverIcon(GUIHelper.getIcon(Icon.MAP_TOGGLER_HIGHLIGHTED, 75, 75));
		mapButton.setDisabledIcon(GUIHelper.getIcon(Icon.MAP_TOGGLER_DISABLED, 75, 75));

		logButton = new JButton("");
		logButton.setContentAreaFilled(false);
		logButton.setIcon(GUIHelper.getIcon(Icon.LOG_TOGGLER, 75, 75));
		logButton.setRolloverIcon(GUIHelper.getIcon(Icon.LOG_TOGGLER_HIGHLIGHTED, 75, 75));
		logButton.setDisabledIcon(GUIHelper.getIcon(Icon.LOG_TOGGLER_DISABLED, 75, 75));

		GroupLayout gl_actionPanel = new GroupLayout(actionPanel);
		gl_actionPanel.setHorizontalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_actionPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(invButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(mapButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addComponent(logButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(compassBackgroundPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(32)
				.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)));
		gl_actionPanel.setVerticalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_actionPanel
				.createSequentialGroup()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createSequentialGroup().addGap(15).addComponent(compassBackgroundPanel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_actionPanel.createSequentialGroup()
								.addComponent(invButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(mapButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(logButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		actionButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		JButton btnTest = new JButton("test");
		btnTest.setIconTextGap(0);
		btnTest.setMargin(new Insets(10, 14, 10, 14));
		btnTest.setSize(new Dimension(50, 20));
		btnTest.setMinimumSize(new Dimension(51, 20));
		btnTest.setMaximumSize(new Dimension(51, 20));
		btnTest.setPreferredSize(new Dimension(51, 20));
		actionButtonPanel.add(btnTest);
		actionPanel.setLayout(gl_actionPanel);

		leftPanelHeadline = new JLabel("[HEADLINE1]") {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		leftPanelHeadline.setOpaque(false);
		leftPanelHeadline.setBackground(new Color(0, 0, 0, 0.4f));
		leftPanelHeadline.setForeground(Color.WHITE);
		leftPanelHeadline.setFont(new Font(GUIManager.getCustomFont().getFamily(), Font.BOLD, 18));
		leftPanelHeadline.setBorder(null);
		leftPanelHeadline.setHorizontalAlignment(SwingConstants.CENTER);

		leftContentPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		leftContentPanel.setOpaque(false);
		leftContentPanel.setBackground(new Color(0, 0, 0, 0));
		GroupLayout gl_leftMainPanel = new GroupLayout(leftMainPanel);
		gl_leftMainPanel.setHorizontalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
				.addComponent(leftPanelHeadline, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE));
		gl_leftMainPanel.setVerticalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftMainPanel.createSequentialGroup()
						.addComponent(leftPanelHeadline, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)));
		leftContentPanel.setLayout(null);

		mapPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		mapPanel.setOpaque(false);
		mapPanel.setBorder(null);
		mapPanel.setBackground(new Color(0, 0, 0, 0));
		mapPanel.setBounds(0, 0, 537, 537);
		leftContentPanel.add(mapPanel);
		GroupLayout gl_mapPanel = new GroupLayout(mapPanel);
		gl_mapPanel
				.setHorizontalGroup(gl_mapPanel.createParallelGroup(Alignment.LEADING).addGap(0, 547, Short.MAX_VALUE));
		gl_mapPanel
				.setVerticalGroup(gl_mapPanel.createParallelGroup(Alignment.LEADING).addGap(0, 548, Short.MAX_VALUE));
		mapPanel.setLayout(gl_mapPanel);

		inventoryPanel = new JPanel();
		inventoryPanel.setBackground(new Color(0, 0, 0, 0));
		inventoryPanel.setBounds(0, 0, 537, 537);
		leftContentPanel.add(inventoryPanel);
		leftMainPanel.setLayout(gl_leftMainPanel);
		GroupLayout gl_invPanel = new GroupLayout(inventoryPanel);
		gl_invPanel
				.setHorizontalGroup(gl_invPanel.createParallelGroup(Alignment.LEADING).addGap(0, 561, Short.MAX_VALUE));
		gl_invPanel
				.setVerticalGroup(gl_invPanel.createParallelGroup(Alignment.LEADING).addGap(0, 537, Short.MAX_VALUE));
		inventoryPanel.setLayout(gl_invPanel);

		logPanel = new JPanel();
		logPanel.setBounds(0, 0, 537, 537);
		leftContentPanel.add(logPanel);
		logPanel.setOpaque(false);
		logPanel.setBorder(null);
		logPanel.setBackground(new Color(0, 0, 0, 0));
		GroupLayout gl_logPanel = new GroupLayout(logPanel);
		gl_logPanel.setHorizontalGroup(gl_logPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 537, Short.MAX_VALUE).addGap(0, 561, Short.MAX_VALUE));
		gl_logPanel.setVerticalGroup(gl_logPanel.createParallelGroup(Alignment.LEADING).addGap(0, 537, Short.MAX_VALUE)
				.addGap(0, 537, Short.MAX_VALUE));
		logPanel.setLayout(gl_logPanel);
		leftMainPanel.setLayout(gl_leftMainPanel);

		playerInfoHeadline = new JLabel("Das ist Holly. Holly ist spiels??chtig.") {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		playerInfoHeadline.setPreferredSize(new Dimension(0, 30));
		playerInfoHeadline.setMaximumSize(new Dimension(0, 30));
		playerInfoHeadline.setOpaque(false);
		playerInfoHeadline.setBackground(new Color(0, 0, 0, 0.4f));
		playerInfoHeadline.setForeground(Color.WHITE);
		playerInfoHeadline.setFont(new Font(GUIManager.getCustomFont().getFamily(), Font.BOLD, 18));
		playerInfoHeadline.setBorder(null);
		playerInfoHeadline.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel playerBarPanelFirstLine = new JPanel();
		playerBarPanelFirstLine.setBackground(new Color(0, 0, 0, 0));

		JPanel skillPanel = new JPanel();
		skillPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		skillPanel.setBackground(new Color(0, 0, 0, 0));

		equippedPanel = new JPanel();
		equippedPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		equippedPanel.setBackground(new Color(0, 0, 0, 0));

		lblEquipped = new JLabel("Ausr\u00FCstung") {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		lblEquipped.setOpaque(false);
		lblEquipped.setForeground(Color.WHITE);
		lblEquipped.setBackground(new Color(0, 0, 0, 0.4f));
		lblEquipped.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipped.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipped.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));

		innerEquippedPanel = new JPanel();
		innerEquippedPanel.setBackground(new Color(0, 0, 0, 0));
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
		gl_playerInfoPanel.setHorizontalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(skillPanel, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE).addGap(30)
						.addComponent(equippedPanel, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(playerBarPanelFirstLine, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(playerInfoHeadline, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE));
		gl_playerInfoPanel.setVerticalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(playerInfoHeadline, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(14)
						.addComponent(
								playerBarPanelFirstLine, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addGroup(gl_playerInfoPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(skillPanel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(equippedPanel, GroupLayout.PREFERRED_SIZE, 71,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		lblSkills = new JLabel("Skills") {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		lblSkills.setOpaque(false);
		lblSkills.setForeground(Color.WHITE);
		lblSkills.setBackground(new Color(0, 0, 0, 0.4f));
		lblSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSkills.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblSkills.setHorizontalAlignment(SwingConstants.CENTER);

		innerSkillPanel = new JPanel();
		innerSkillPanel.setBackground(new Color(0, 0, 0, 0));
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
		GroupLayout gl_playerBarPanelFirstLine = new GroupLayout(playerBarPanelFirstLine);
		gl_playerBarPanelFirstLine.setHorizontalGroup(gl_playerBarPanelFirstLine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerBarPanelFirstLine.createSequentialGroup().addContainerGap()
						.addGroup(gl_playerBarPanelFirstLine.createParallelGroup(Alignment.LEADING)
								.addComponent(healthLabel).addComponent(levelLabel))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_playerBarPanelFirstLine.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(levelBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(healthBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(370, Short.MAX_VALUE)));
		gl_playerBarPanelFirstLine.setVerticalGroup(gl_playerBarPanelFirstLine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerBarPanelFirstLine.createSequentialGroup().addGap(5)
						.addGroup(gl_playerBarPanelFirstLine.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(healthLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(healthBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_playerBarPanelFirstLine.createParallelGroup(Alignment.TRAILING)
								.addComponent(levelBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(levelLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(10)));
		playerBarPanelFirstLine.setLayout(gl_playerBarPanelFirstLine);
		playerInfoPanel.setLayout(gl_playerInfoPanel);
		setLayout(groupLayout);

		hintPanel = new JPanel();
		hintPanel.setBounds(getWidth() - 150, getHeight() - 100, 150, 100);
		hintPanel.setBackground(new Color(0, 0, 0, 0));
		this.add(hintPanel);
		hintPanel.setLayout(null);

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				updateHintPanel();
			}
		};
		timer.schedule(task, 0L, 1000L);
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

	public JPanel getMapInfoPanel() {
		return leftInfoPanel;
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

	public JButton getInvButton() {
		return invButton;
	}

	public JButton getMapButton() {
		return mapButton;
	}

	public JButton getLogButton() {
		return logButton;
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

	public JPanel getInventoryPanel() {
		return inventoryPanel;
	}

	public JPanel getMapPanel() {
		return mapPanel;
	}

	public JPanel getBackgroundImagePanel() {
		return backgroundImagePanel;
	}

	public JPanel getLogPanel() {
		return logPanel;
	}

	public void setBackgroundImagePanel(JPanel backgroundImagePanel) {
		this.backgroundImagePanel = backgroundImagePanel;
	}

	public JLabel getPlayerInfoHeadline() {
		return playerInfoHeadline;
	}

	public void setNavigationEnabled(boolean enabled) {
		this.goNorthButton.setEnabled(enabled);
		this.goEastButton.setEnabled(enabled);
		this.goSouthButton.setEnabled(enabled);
		this.goWestButton.setEnabled(enabled);
	}

	public void updateCompass() {
		Quest currentQuest = GameManager.getInstance().getPlayer().getCurrentQuest();
		BufferedImage compassBackground;
		String ressource = "images/GUI/Compass.png";
		if (currentQuest != null) {
			System.out.println("FOOBAR");
			Coordinate targetPoint = currentQuest.getTargetPoint();
			Coordinate currentPos = GameManager.getInstance().getPlayer().getCurrentMapField().getCoordinate();
			if (targetPoint != null && !targetPoint.isEqual(currentPos)) {
				String direction = currentPos.getDirectionTo(targetPoint);
				ressource = "images/GUI/CompassPointer/CompassPointer_" + direction + ".png";
			}
		}
		try {
			compassBackground = ImageIO.read(new File(HelperFunctions.getResource(ressource)));
			this.compassBackgroundPanel = new BackgroundImagePanel(
					GUIHelper.scaleIcon(new ImageIcon(compassBackground), 250).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.compassBackgroundPanel.setOpaque(false);

		GameManager.getInstance().update();
	}

	public void addFieldInfo(String info) {

		if (this.fieldInfos.getComponents().length > 8) {
			this.fieldInfos.remove(this.fieldInfos.getComponents()[0]);
			((JLabel) this.fieldInfos.getComponents()[0]).setText("...");
		}

		JLabel label = new JLabel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		label.setOpaque(false);
		label.setText("<html>" + info + "</html>");
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(0, 0, 0, 0));
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBorder(BorderFactory.createEmptyBorder(2, 0, 4, 0));
		this.fieldInfos.add(label);

		GameManager.getInstance().update();
	}

	private void updateHintPanel() {
		if (GameManager.getInstance().getHints().size() > 0) {
			this.hintPanel.setBackground(new Color(0, 0, 0, 0.2f));
			this.hintPanel.removeAll();

			int max = 3;
			if (GameManager.getInstance().getHints().size() < max) {
				max = GameManager.getInstance().getHints().size();
			}

			int y = 10;
			for (int i = 0; i < max; i++) {
				JLabel element = GameManager.getInstance().getHints().get(i);
				element.setBounds(10, y, 150, 20);
				y += 18;
				this.hintPanel.add(element);
			}
			GameManager.getInstance().getHints().remove(0);
			GameManager.getInstance().update();

		} else {
			this.hintPanel.removeAll();
			this.hintPanel.setBackground(new Color(0, 0, 0, 0));
			GameManager.getInstance().update();

		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon image = new ImageIcon(HelperFunctions.getResource("images/GUI/UI_Background.png"));
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}
}
