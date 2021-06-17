package gui.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import basic.Config;
import basic.GameManager;
import basic.HelperFunctions;
import utilities.Skill;

public class PlayerEditor extends JPanel {
	private JTextField textField;
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

	public PlayerEditor() {

		setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

		points = 35;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(375, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE).addGap(275)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE).addContainerGap()));

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel skillSetter = new JPanel();
		skillSetter.setBackground(new Color(0, 0, 0, 0));
		skillSetter.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		startGame = new JButton("Spiel starten");
		startGame.setBorderPainted(false);
		startGame.setBackground(Color.GREEN);
		startGame.addActionListener(new StartGameAction(this));

		leftPointsLabel = new JLabel("Noch 35 Punkte zu verteilen");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addGap(42)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblName)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField, Alignment.LEADING)
										.addComponent(skillSetter, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 471,
												Short.MAX_VALUE)
										.addComponent(leftPointsLabel, Alignment.LEADING).addComponent(startGame,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
						.addContainerGap(37, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(33).addComponent(lblName)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(35)
						.addComponent(skillSetter, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(leftPointsLabel).addGap(47)
						.addComponent(startGame, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(169, Short.MAX_VALUE)));

		JPanel line1 = new JPanel();
		line1.setBackground(new Color(0, 0, 0, 0));

		JPanel line2 = new JPanel();
		line2.setBackground(new Color(0, 0, 0, 0));

		JLabel lblWahrnehmung = new JLabel("Wahrnehmung");
		lblWahrnehmung.setFont(new Font("Tahoma", Font.PLAIN, 14));

		perceptionLabel = new JLabel("0/10");
		perceptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton perceptionMinus = new JButton("-");
		perceptionMinus.addActionListener(new ChangeValueButton(this, "perception", -1));
		perceptionMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		perceptionMinus.setAlignmentY(0.0f);

		JButton perceptionPlus = new JButton("+");
		perceptionPlus.addActionListener(new ChangeValueButton(this, "perception", 1));
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
		line3.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma = new JLabel("Ausdauer");
		lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 14));

		enduranceLabel = new JLabel("0/10");
		enduranceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton enduranceMinus = new JButton("-");
		enduranceMinus.addActionListener(new ChangeValueButton(this, "endurance", -1));
		enduranceMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		enduranceMinus.setAlignmentY(0.0f);

		JButton endurancePlus = new JButton("+");
		endurancePlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		endurancePlus.addActionListener(new ChangeValueButton(this, "endurance", 1));
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
		line4.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2 = new JLabel("Charisma");
		lblCharisma_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		charismaLabel = new JLabel("0/10");
		charismaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton charismaMinus = new JButton("-");
		charismaMinus.addActionListener(new ChangeValueButton(this, "charisma", -1));
		charismaMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		charismaMinus.setAlignmentY(0.0f);

		JButton charismaPlus = new JButton("+");
		charismaPlus.addActionListener(new ChangeValueButton(this, "charisma", 1));
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
		line5.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2_1 = new JLabel("Intelligenz");
		lblCharisma_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		intelligenceLabel = new JLabel("0/10");
		intelligenceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton intelligenceMinus = new JButton("-");
		intelligenceMinus.addActionListener(new ChangeValueButton(this, "intelligence", -1));
		intelligenceMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		intelligenceMinus.setAlignmentY(0.0f);

		JButton intelligencePlus = new JButton("+");
		intelligencePlus.addActionListener(new ChangeValueButton(this, "intelligence", 1));
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
		line6.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2_1_1 = new JLabel("Geschicklichkeit");
		lblCharisma_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		agilityLabel = new JLabel("0/10");
		agilityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton agilityMinus = new JButton("-");
		agilityMinus.addActionListener(new ChangeValueButton(this, "agility", -1));
		agilityMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		agilityMinus.setAlignmentY(0.0f);

		JButton agilityPlus = new JButton("+");
		agilityPlus.addActionListener(new ChangeValueButton(this, "agility", 1));
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
		line7.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2_1_1_1 = new JLabel("Gl\u00FCck");
		lblCharisma_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		luckLabel = new JLabel("0/10");
		luckLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton luckMinus = new JButton("-");
		luckMinus.addActionListener(new ChangeValueButton(this, "luck", -1));
		luckMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		luckMinus.setAlignmentY(0.0f);

		JButton luckPlus = new JButton("+");
		luckPlus.addActionListener(new ChangeValueButton(this, "luck", 1));
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

		strengthLabel = new JLabel("0/10");
		strengthLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton strengthMinus = new JButton("-");
		strengthMinus.addActionListener(new ChangeValueButton(this, "strength", -1));
		strengthMinus.setFont(new Font("Tahoma", Font.BOLD, 14));
		strengthMinus.setAlignmentY(0.0f);

		JButton strengthPlus = new JButton("+");
		strengthPlus.addActionListener(new ChangeValueButton(this, "strength", 1));
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

class ChangeValueButton implements ActionListener {

	private PlayerEditor playerEditor;
	private String name;
	private int value;

	public ChangeValueButton(PlayerEditor playerEditor, String name, int value) {
		this.playerEditor = playerEditor;
		this.name = name;
		this.value = value;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int points = 0;
		JLabel label = null;

		if (this.name == "perception")
			label = this.playerEditor.getPerceptionLabel();
		if (this.name == "luck")
			label = this.playerEditor.getLuckLabel();
		if (this.name == "agility")
			label = this.playerEditor.getAgilityLabel();
		if (this.name == "endurance")
			label = this.playerEditor.getEnduranceLabel();
		if (this.name == "intelligence")
			label = this.playerEditor.getIntelligenceLabel();
		if (this.name == "strength")
			label = this.playerEditor.getStrengthLabel();
		if (this.name == "charisma")
			label = this.playerEditor.getCharismaLabel();

		points = getPoints(label.getText());

		if (this.value > 0 && this.playerEditor.getPoints() > 0 && points < 10) { // add
			points++;
			this.playerEditor.setPoints(this.playerEditor.getPoints() - 1);
		} else if (this.value < 0 && points > 0) { // remove
			points--;
			this.playerEditor.setPoints(this.playerEditor.getPoints() + 1);
		}

		label.setText(points + "/10");
		this.playerEditor.getLeftPointsLabel()
				.setText("Noch " + this.playerEditor.getPoints() + " Punkte zu verteilen");

	}

	private int getPoints(String label) {
		return Integer.parseInt(label.split("/")[0]);
	}

}

class StartGameAction implements ActionListener {

	private PlayerEditor playerEditor;

	public StartGameAction(PlayerEditor playerEditor) {
		this.playerEditor = playerEditor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameManager gm = GameManager.getInstance();

		this.playerEditor.getStartGame().setEnabled(false);

		// set skill points
		gm.getPlayer().getSkillSet().setSkillValue(Skill.AGILITY,
				Integer.parseInt(this.playerEditor.getAgilityLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.PERCEPTION,
				Integer.parseInt(this.playerEditor.getPerceptionLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.LUCK,
				Integer.parseInt(this.playerEditor.getLuckLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.ENDURANCE,
				Integer.parseInt(this.playerEditor.getEnduranceLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.STRENGTH,
				Integer.parseInt(this.playerEditor.getStrengthLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.CHARISMA,
				Integer.parseInt(this.playerEditor.getCharismaLabel().getText().split("/")[0]));
		gm.getPlayer().getSkillSet().setSkillValue(Skill.INTELLIGENCE,
				Integer.parseInt(this.playerEditor.getIntelligenceLabel().getText().split("/")[0]));

		gm.startGame();
	}
}