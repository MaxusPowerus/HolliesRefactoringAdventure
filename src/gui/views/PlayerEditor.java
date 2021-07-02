package gui.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import basic.Config;
import basic.GameManager;
import basic.HelperFunctions;
import gui.GUIHelper;
import gui.GUIManager;
import gui.GraphicalButton;
import gui.Icon;
import gui.playereditor.ChangeValueButton;
import gui.playereditor.ContinueGameAction;
import gui.playereditor.StartGameAction;
import utilities.Skill;

public class PlayerEditor extends JPanel {
	private JLabel strengthLabel;
	private JLabel perceptionLabel;
	private JLabel enduranceLabel;
	private JLabel charismaLabel;
	private JLabel intelligenceLabel;
	private JLabel agilityLabel;
	private JLabel luckLabel;
	private JLabel leftPointsLabel;
	private int points;
	private JButton startGame;
	private boolean levelUp;

	public PlayerEditor(boolean levelUp) {
		this.points = Config.SKILL_POINTS;
		this.levelUp = levelUp;

		if (levelUp)
			points = 1;

		setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(375, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE).addGap(275)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE).addContainerGap()));

		JPanel skillSetter = new JPanel();
		skillSetter.setBackground(new Color(0, 0, 0, 0));

		startGame = new GraphicalButton();
		startGame.setBorderPainted(false);
		startGame.setBackground(Color.GREEN);
		if (levelUp) {
			startGame.setText("Spiel fortsetzen");
			startGame.addActionListener(new ContinueGameAction(this));
		} else {
			startGame.setText("Spiel starten");
			startGame.addActionListener(new StartGameAction(this));
		}

		leftPointsLabel = new JLabel("<html>Noch <b>" + this.points + "</b> Punkte zu verteilen</html>");

		JLabel title = new JLabel("Hollies Adventure", SwingConstants.CENTER);

		title.setFont(new Font(GUIManager.getCustomFont().getFamily(), Font.PLAIN, 70));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addGap(42).addGroup(gl_panel
						.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(title, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(skillSetter, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 471, Short.MAX_VALUE)
						.addComponent(leftPointsLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(startGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap(37, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(61).addComponent(title).addGap(56)
						.addComponent(skillSetter, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(leftPointsLabel).addGap(47)
						.addComponent(startGame, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(119, Short.MAX_VALUE)));

		JPanel line1 = new JPanel();

		JPanel line2 = new JPanel();

		JLabel lblWahrnehmung = new JLabel("Wahrnehmung");
		lblWahrnehmung.setFont(new Font("Tahoma", Font.PLAIN, 14));

		perceptionLabel = new JLabel("5/10");
		if (levelUp)
			perceptionLabel.setText(
					GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.PERCEPTION) + "/10");
		perceptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton perceptionMinus = new JButton();
		perceptionMinus.setContentAreaFilled(false);
		perceptionMinus.setIcon(GUIHelper.getIcon(Icon.MINUS, 25, 25));
		perceptionMinus.setRolloverIcon(GUIHelper.getIcon(Icon.MINUS_HIGHLIGHTED, 25, 25));
		perceptionMinus.setDisabledIcon(GUIHelper.getIcon(Icon.MINUS_DISABLED, 25, 25));
		perceptionMinus.addActionListener(new ChangeValueButton(this, "perception", -1, levelUp));
		perceptionMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		perceptionMinus.setAlignmentY(0.0f);
		if (levelUp)
			perceptionMinus.setVisible(false);

		JButton perceptionPlus = new JButton();
		perceptionPlus.setContentAreaFilled(false);
		perceptionPlus.setIcon(GUIHelper.getIcon(Icon.PLUS, 25, 25));
		perceptionPlus.setRolloverIcon(GUIHelper.getIcon(Icon.PLUS_HIGHLIGHTED, 25, 25));
		perceptionPlus.setDisabledIcon(GUIHelper.getIcon(Icon.PLUS_DISABLED, 25, 25));
		perceptionPlus.addActionListener(new ChangeValueButton(this, "perception", 1, levelUp));
		perceptionPlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		perceptionPlus.setAlignmentY(0.0f);
		GroupLayout gl_line2 = new GroupLayout(line2);
		gl_line2.setHorizontalGroup(gl_line2.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line2.createSequentialGroup().addContainerGap().addComponent(lblWahrnehmung)
						.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE).addComponent(perceptionLabel)
						.addGap(108).addComponent(perceptionMinus).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(perceptionPlus).addGap(6)));
		gl_line2.setVerticalGroup(gl_line2.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line2.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line2.createParallelGroup(Alignment.BASELINE).addComponent(lblWahrnehmung)
								.addComponent(perceptionLabel).addComponent(perceptionPlus)
								.addComponent(perceptionMinus))
						.addContainerGap()));
		line2.setLayout(gl_line2);

		JPanel line3 = new JPanel();

		JLabel lblCharisma = new JLabel("Ausdauer");
		lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 14));

		enduranceLabel = new JLabel("5/10");
		if (levelUp)
			enduranceLabel.setText(
					GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.ENDURANCE) + "/10");
		enduranceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton enduranceMinus = new JButton("-");
		enduranceMinus.addActionListener(new ChangeValueButton(this, "endurance", -1, levelUp));
		enduranceMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		enduranceMinus.setAlignmentY(0.0f);
		if (levelUp)
			enduranceMinus.setVisible(false);

		JButton endurancePlus = new JButton("+");
		endurancePlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		endurancePlus.addActionListener(new ChangeValueButton(this, "endurance", 1, levelUp));
		endurancePlus.setAlignmentY(0.0f);
		GroupLayout gl_line3 = new GroupLayout(line3);
		gl_line3.setHorizontalGroup(gl_line3.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line3.createSequentialGroup().addContainerGap().addComponent(lblCharisma)
						.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE).addComponent(enduranceLabel)
						.addGap(108).addComponent(enduranceMinus).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(endurancePlus).addGap(6)));
		gl_line3.setVerticalGroup(gl_line3.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line3.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line3.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma)
								.addComponent(enduranceLabel).addComponent(endurancePlus).addComponent(enduranceMinus))
						.addContainerGap()));
		line3.setLayout(gl_line3);

		JPanel line4 = new JPanel();

		JLabel lblCharisma_2 = new JLabel("Charisma");
		lblCharisma_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		charismaLabel = new JLabel("5/10");
		if (levelUp)
			charismaLabel
					.setText(GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.CHARISMA) + "/10");
		charismaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton charismaMinus = new JButton("-");
		charismaMinus.addActionListener(new ChangeValueButton(this, "charisma", -1, levelUp));
		charismaMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		charismaMinus.setAlignmentY(0.0f);
		if (levelUp)
			charismaMinus.setVisible(false);

		JButton charismaPlus = new JButton("+");
		charismaPlus.addActionListener(new ChangeValueButton(this, "charisma", 1, levelUp));
		charismaPlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		charismaPlus.setAlignmentY(0.0f);
		GroupLayout gl_line4 = new GroupLayout(line4);
		gl_line4.setHorizontalGroup(gl_line4.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line4.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(charismaLabel)
						.addGap(108).addComponent(charismaMinus).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(charismaPlus).addGap(6)));
		gl_line4.setVerticalGroup(gl_line4.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line4.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line4.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2)
								.addComponent(charismaLabel).addComponent(charismaPlus).addComponent(charismaMinus))
						.addContainerGap()));
		line4.setLayout(gl_line4);

		JPanel line5 = new JPanel();

		JLabel lblCharisma_2_1 = new JLabel("Intelligenz");
		lblCharisma_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		intelligenceLabel = new JLabel("5/10");
		if (levelUp)
			intelligenceLabel.setText(
					GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.INTELLIGENCE) + "/10");
		intelligenceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton intelligenceMinus = new JButton("-");
		intelligenceMinus.addActionListener(new ChangeValueButton(this, "intelligence", -1, levelUp));
		intelligenceMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		intelligenceMinus.setAlignmentY(0.0f);
		if (levelUp)
			intelligenceMinus.setVisible(false);

		JButton intelligencePlus = new JButton("+");
		intelligencePlus.addActionListener(new ChangeValueButton(this, "intelligence", 1, levelUp));
		intelligencePlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		intelligencePlus.setAlignmentY(0.0f);
		GroupLayout gl_line5 = new GroupLayout(line5);
		gl_line5.setHorizontalGroup(gl_line5.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line5.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2_1)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
						.addComponent(intelligenceLabel).addGap(108).addComponent(intelligenceMinus)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(intelligencePlus).addGap(6)));
		gl_line5.setVerticalGroup(gl_line5.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line5.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line5.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2_1)
								.addComponent(intelligenceLabel).addComponent(intelligencePlus)
								.addComponent(intelligenceMinus))
						.addContainerGap()));
		line5.setLayout(gl_line5);

		JPanel line6 = new JPanel();

		JLabel lblCharisma_2_1_1 = new JLabel("Geschicklichkeit");
		lblCharisma_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		agilityLabel = new JLabel("5/10");
		if (levelUp)
			agilityLabel
					.setText(GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.AGILITY) + "/10");
		agilityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton agilityMinus = new JButton("-");
		agilityMinus.addActionListener(new ChangeValueButton(this, "agility", -1, levelUp));
		agilityMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		agilityMinus.setAlignmentY(0.0f);
		if (levelUp)
			agilityMinus.setVisible(false);

		JButton agilityPlus = new JButton("+");
		agilityPlus.addActionListener(new ChangeValueButton(this, "agility", 1, levelUp));
		agilityPlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		agilityPlus.setAlignmentY(0.0f);
		GroupLayout gl_line6 = new GroupLayout(line6);
		gl_line6.setHorizontalGroup(gl_line6.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line6.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2_1_1)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(agilityLabel)
						.addGap(108).addComponent(agilityMinus).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(agilityPlus).addGap(6)));
		gl_line6.setVerticalGroup(gl_line6.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line6.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line6.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2_1_1)
								.addComponent(agilityLabel).addComponent(agilityPlus).addComponent(agilityMinus))
						.addContainerGap()));
		line6.setLayout(gl_line6);

		JPanel line7 = new JPanel();

		JLabel lblCharisma_2_1_1_1 = new JLabel("Gl\u00FCck");
		lblCharisma_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		luckLabel = new JLabel("5/10");
		if (levelUp)
			luckLabel.setText(GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.LUCK) + "/10");
		luckLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton luckMinus = new JButton("-");
		luckMinus.addActionListener(new ChangeValueButton(this, "luck", -1, levelUp));
		luckMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		luckMinus.setAlignmentY(0.0f);
		if (levelUp)
			luckMinus.setVisible(false);

		JButton luckPlus = new JButton("+");
		luckPlus.addActionListener(new ChangeValueButton(this, "luck", 1, levelUp));
		luckPlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		luckPlus.setAlignmentY(0.0f);
		GroupLayout gl_line7 = new GroupLayout(line7);
		gl_line7.setHorizontalGroup(gl_line7.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line7.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2_1_1_1)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(luckLabel)
						.addGap(108).addComponent(luckMinus).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(luckPlus).addGap(6)));
		gl_line7.setVerticalGroup(gl_line7.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line7.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line7.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2_1_1_1)
								.addComponent(luckLabel).addComponent(luckPlus).addComponent(luckMinus))
						.addContainerGap()));
		line7.setLayout(gl_line7);
		GroupLayout gl_skillSetter = new GroupLayout(skillSetter);
		gl_skillSetter.setHorizontalGroup(gl_skillSetter.createParallelGroup(Alignment.LEADING).addGroup(gl_skillSetter
				.createSequentialGroup()
				.addGroup(gl_skillSetter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_skillSetter.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(line1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(line2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
						.addComponent(line3, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addComponent(line4, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addComponent(line5, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addComponent(line6, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
						.addComponent(line7, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_skillSetter.setVerticalGroup(gl_skillSetter.createParallelGroup(Alignment.LEADING).addGroup(gl_skillSetter
				.createSequentialGroup()
				.addComponent(line1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(line2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(line3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(line4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(line5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(line6, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(line7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(21, Short.MAX_VALUE)));

		JLabel lblStrke = new JLabel("St\u00E4rke");
		lblStrke.setFont(new Font("Tahoma", Font.PLAIN, 14));

		strengthLabel = new JLabel("5/10");
		if (levelUp)
			strengthLabel
					.setText(GameManager.getInstance().getPlayer().getSkillSet().getSkillValue(Skill.STRENGTH) + "/10");
		strengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton strengthMinus = new JButton("-");
		strengthMinus.addActionListener(new ChangeValueButton(this, "strength", -1, levelUp));
		strengthMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		strengthMinus.setAlignmentY(0.0f);
		if (levelUp)
			strengthMinus.setVisible(false);

		JButton strengthPlus = new JButton("+");
		strengthPlus.addActionListener(new ChangeValueButton(this, "strength", 1, levelUp));
		strengthPlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		strengthPlus.setAlignmentY(0.0f);
		GroupLayout gl_line1 = new GroupLayout(line1);
		gl_line1.setHorizontalGroup(gl_line1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_line1.createSequentialGroup().addContainerGap().addComponent(lblStrke)
						.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE).addComponent(strengthLabel)
						.addGap(108).addComponent(strengthMinus).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(strengthPlus).addGap(6)));
		gl_line1.setVerticalGroup(gl_line1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_line1.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line1.createParallelGroup(Alignment.BASELINE).addComponent(lblStrke)
								.addComponent(strengthLabel).addComponent(strengthPlus).addComponent(strengthMinus))
						.addContainerGap()));
		line1.setLayout(gl_line1);
		skillSetter.setLayout(gl_skillSetter);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}

	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon image = new ImageIcon(HelperFunctions.getResource("images/GUI/UI_Background.png"));
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}

	public JLabel getLuckLabel() {
		return luckLabel;
	}

	public JLabel getCharismaLabel() {
		return charismaLabel;
	}

	public JLabel getEnduranceLabel() {
		return enduranceLabel;
	}

	public JLabel getPerceptionLabel() {
		return perceptionLabel;
	}

	public JLabel getStrengthLabel() {
		return strengthLabel;
	}

	public JLabel getIntelligenceLabel() {
		return intelligenceLabel;
	}

	public JLabel getAgilityLabel() {
		return agilityLabel;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public JLabel getLeftPointsLabel() {
		return leftPointsLabel;
	}

	public JButton getStartGame() {
		return startGame;
	}
}
