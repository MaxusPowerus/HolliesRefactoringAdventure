package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
import basic.HelperFunctions;
import gui.actions.NavigationButtonAction;
import gui.actions.ResizeAction;
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
	private JPanel mapPanel;
	private JPanel inventoryPanel;
	private JPanel backgroundImagePanel;
	private BackgroundImagePanel compassBackgroundPanel;
	private Font customFont;

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

		JLabel backgroundImageLabel = new JLabel(
				new ImageIcon(HelperFunctions.getResource("images/GUI/UI_Background.png")));
		backgroundImageLabel.setOpaque(true);
		frame.setContentPane(backgroundImageLabel);

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
		leftInfoPanel.setBackground(new Color(0, 0, 0, 0));

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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
								.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(fieldInfoPanel, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
								.addComponent(actionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(leftMainPanel, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(leftInfoPanel, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(playerInfoPanel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(fieldInfoPanel, GroupLayout.PREFERRED_SIZE, 288,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(actionPanel,
												GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));

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

		openInvButton = new JButton("[INV_BTN]");

		BufferedImage compassBackground;
		try {
			compassBackground = ImageIO.read(new File(HelperFunctions.getResource("images/GUI/Compass.png")));
			compassBackgroundPanel = new BackgroundImagePanel(
					GUIHelper.scaleIcon(new ImageIcon(compassBackground), 250).getImage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		compassBackgroundPanel.setOpaque(false);

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

		GroupLayout gl_actionPanel = new GroupLayout(actionPanel);
		gl_actionPanel.setHorizontalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_actionPanel
				.createSequentialGroup()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addComponent(openInvButton)
						.addGroup(gl_actionPanel.createSequentialGroup().addGap(6).addComponent(compassBackgroundPanel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
				.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)));
		gl_actionPanel.setVerticalGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_actionPanel
				.createSequentialGroup()
				.addGroup(gl_actionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_actionPanel.createSequentialGroup().addComponent(openInvButton)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(compassBackgroundPanel, GroupLayout.PREFERRED_SIZE, 242, Short.MAX_VALUE))
						.addComponent(actionButtonPanel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		actionButtonPanel.setLayout(new GridLayout(5, 1, 0, 5));
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
		leftPanelHeadline.setFont(new Font("Tahoma", Font.BOLD, 12));
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
				.addComponent(leftPanelHeadline, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
				.addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE));
		gl_leftMainPanel.setVerticalGroup(gl_leftMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftMainPanel.createSequentialGroup()
						.addComponent(leftPanelHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(8).addComponent(leftContentPanel, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)));
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
		mapPanel.setBounds(0, 0, 561, 537);
		leftContentPanel.add(mapPanel);

		inventoryPanel = new JPanel();
		inventoryPanel.setBackground(new Color(0, 0, 0, 0));
		inventoryPanel.setBounds(0, 0, 561, 537);
		leftContentPanel.add(inventoryPanel);
		leftMainPanel.setLayout(gl_leftMainPanel);

		JLabel playerInfoHeadline = new JLabel("Das ist Holly. Holly ist spiels�chtig.") {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		playerInfoHeadline.setOpaque(false);
		playerInfoHeadline.setBackground(new Color(0, 0, 0, 0.4f));
		playerInfoHeadline.setForeground(Color.WHITE);
		playerInfoHeadline.setFont(new Font("Tahoma", Font.BOLD, 12));
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
				.addComponent(playerInfoHeadline, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(skillPanel, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE).addGap(30)
						.addComponent(equippedPanel, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
				.addComponent(playerBarPanelFirstLine, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE));
		gl_playerInfoPanel.setVerticalGroup(gl_playerInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfoPanel.createSequentialGroup()
						.addComponent(playerInfoHeadline, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(
								playerBarPanelFirstLine, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_playerInfoPanel.createParallelGroup(Alignment.TRAILING)
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
		lblSkills.setOpaque(fullscreen);
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

	public JPanel getInventoryPanel() {
		return inventoryPanel;
	}

	public JPanel getMapPanel() {
		return mapPanel;
	}

	public JPanel getBackgroundImagePanel() {
		return backgroundImagePanel;
	}

	public void setBackgroundImagePanel(JPanel backgroundImagePanel) {
		this.backgroundImagePanel = backgroundImagePanel;
	}

	public Font getCustomFont() {
		return customFont;
	}

	public void setNavigationEnabled(boolean enabled) {
		this.goNorthButton.setEnabled(enabled);
		this.goEastButton.setEnabled(enabled);
		this.goSouthButton.setEnabled(enabled);
		this.goWestButton.setEnabled(enabled);
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
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));
		this.fieldInfos.add(label);

		this.frame.revalidate();
		this.frame.repaint();
	}
}