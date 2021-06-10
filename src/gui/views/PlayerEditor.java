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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import basic.Config;
import basic.HelperFunctions;

public class PlayerEditor extends JPanel {
	private JTextField textField;

	public PlayerEditor() {
		setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

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

		JButton btnSpielStarten = new JButton("Spiel starten");
		btnSpielStarten.setBorderPainted(false);
		btnSpielStarten.setBackground(Color.GREEN);

		JLabel lblNochPunkte = new JLabel("Noch 35 Punkte zu verteilen");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup().addGap(42)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblName)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField, Alignment.LEADING)
										.addComponent(skillSetter, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 471,
												Short.MAX_VALUE)
										.addComponent(lblNochPunkte, Alignment.LEADING).addComponent(btnSpielStarten,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)))
						.addContainerGap(37, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(33).addComponent(lblName)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addGap(35)
						.addComponent(skillSetter, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNochPunkte).addGap(47)
						.addComponent(btnSpielStarten, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(169, Short.MAX_VALUE)));

		JPanel line1 = new JPanel();
		line1.setBackground(new Color(0, 0, 0, 0));

		JPanel line2 = new JPanel();
		line2.setBackground(new Color(0, 0, 0, 0));

		JLabel lblWahrnehmung = new JLabel("Wahrnehmung");
		lblWahrnehmung.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1 = new JLabel("1/10");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_2 = new JButton("-");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setContentAreaFilled(false);
		button_2.setAlignmentY(0.0f);

		JButton button_1_1 = new JButton("+");
		button_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1_1.setContentAreaFilled(false);
		button_1_1.setAlignmentY(0.0f);
		GroupLayout gl_line2 = new GroupLayout(line2);
		gl_line2.setHorizontalGroup(gl_line2.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line2.createSequentialGroup().addContainerGap().addComponent(lblWahrnehmung)
						.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE).addComponent(label_1)
						.addGap(108).addComponent(button_2).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button_1_1).addGap(6)));
		gl_line2.setVerticalGroup(gl_line2.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line2.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line2.createParallelGroup(Alignment.BASELINE).addComponent(lblWahrnehmung)
								.addComponent(label_1).addComponent(button_1_1).addComponent(button_2))
						.addContainerGap()));
		line2.setLayout(gl_line2);

		JPanel line3 = new JPanel();
		line3.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma = new JLabel("Ausdauer");
		lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1_1 = new JLabel("1/10");
		label_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_2_1 = new JButton("-");
		button_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2_1.setContentAreaFilled(false);
		button_2_1.setAlignmentY(0.0f);

		JButton button_1_1_1 = new JButton("+");
		button_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1_1_1.setContentAreaFilled(false);
		button_1_1_1.setAlignmentY(0.0f);
		GroupLayout gl_line3 = new GroupLayout(line3);
		gl_line3.setHorizontalGroup(gl_line3.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line3.createSequentialGroup().addContainerGap().addComponent(lblCharisma)
						.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE).addComponent(label_1_1)
						.addGap(108).addComponent(button_2_1).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button_1_1_1).addGap(6)));
		gl_line3.setVerticalGroup(gl_line3.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line3.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line3.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma)
								.addComponent(label_1_1).addComponent(button_1_1_1).addComponent(button_2_1))
						.addContainerGap()));
		line3.setLayout(gl_line3);

		JPanel line4 = new JPanel();
		line4.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2 = new JLabel("Charisma");
		lblCharisma_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1_1_1 = new JLabel("1/10");
		label_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_2_1_1 = new JButton("-");
		button_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2_1_1.setContentAreaFilled(false);
		button_2_1_1.setAlignmentY(0.0f);

		JButton button_1_1_1_1 = new JButton("+");
		button_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1_1_1_1.setContentAreaFilled(false);
		button_1_1_1_1.setAlignmentY(0.0f);
		GroupLayout gl_line4 = new GroupLayout(line4);
		gl_line4.setHorizontalGroup(gl_line4.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line4.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(label_1_1_1)
						.addGap(108).addComponent(button_2_1_1).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button_1_1_1_1).addGap(6)));
		gl_line4.setVerticalGroup(gl_line4.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line4.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line4.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2)
								.addComponent(label_1_1_1).addComponent(button_1_1_1_1).addComponent(button_2_1_1))
						.addContainerGap()));
		line4.setLayout(gl_line4);

		JPanel line5 = new JPanel();
		line5.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2_1 = new JLabel("Intelligenz");
		lblCharisma_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1_1_1_1 = new JLabel("1/10");
		label_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_2_1_1_1 = new JButton("-");
		button_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2_1_1_1.setContentAreaFilled(false);
		button_2_1_1_1.setAlignmentY(0.0f);

		JButton button_1_1_1_1_1 = new JButton("+");
		button_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1_1_1_1_1.setContentAreaFilled(false);
		button_1_1_1_1_1.setAlignmentY(0.0f);
		GroupLayout gl_line5 = new GroupLayout(line5);
		gl_line5.setHorizontalGroup(gl_line5.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line5.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2_1)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(label_1_1_1_1)
						.addGap(108).addComponent(button_2_1_1_1).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button_1_1_1_1_1).addGap(6)));
		gl_line5.setVerticalGroup(gl_line5.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line5.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line5.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2_1)
								.addComponent(label_1_1_1_1).addComponent(button_1_1_1_1_1)
								.addComponent(button_2_1_1_1))
						.addContainerGap()));
		line5.setLayout(gl_line5);

		JPanel line6 = new JPanel();
		line6.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2_1_1 = new JLabel("Geschicklichkeit");
		lblCharisma_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1_1_1_1_1 = new JLabel("1/10");
		label_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_2_1_1_1_1 = new JButton("-");
		button_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2_1_1_1_1.setContentAreaFilled(false);
		button_2_1_1_1_1.setAlignmentY(0.0f);

		JButton button_1_1_1_1_1_1 = new JButton("+");
		button_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1_1_1_1_1_1.setContentAreaFilled(false);
		button_1_1_1_1_1_1.setAlignmentY(0.0f);
		GroupLayout gl_line6 = new GroupLayout(line6);
		gl_line6.setHorizontalGroup(gl_line6.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line6.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2_1_1)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(label_1_1_1_1_1)
						.addGap(108).addComponent(button_2_1_1_1_1).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button_1_1_1_1_1_1).addGap(6)));
		gl_line6.setVerticalGroup(gl_line6.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line6.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line6.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2_1_1)
								.addComponent(label_1_1_1_1_1).addComponent(button_1_1_1_1_1_1)
								.addComponent(button_2_1_1_1_1))
						.addContainerGap()));
		line6.setLayout(gl_line6);

		JPanel line7 = new JPanel();
		line7.setBackground(new Color(0, 0, 0, 0));

		JLabel lblCharisma_2_1_1_1 = new JLabel("Gl\u00FCck");
		lblCharisma_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel label_1_1_1_1_1_1 = new JLabel("1/10");
		label_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button_2_1_1_1_1_1 = new JButton("-");
		button_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2_1_1_1_1_1.setContentAreaFilled(false);
		button_2_1_1_1_1_1.setAlignmentY(0.0f);

		JButton button_1_1_1_1_1_1_1 = new JButton("+");
		button_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1_1_1_1_1_1_1.setContentAreaFilled(false);
		button_1_1_1_1_1_1_1.setAlignmentY(0.0f);
		GroupLayout gl_line7 = new GroupLayout(line7);
		gl_line7.setHorizontalGroup(gl_line7.createParallelGroup(Alignment.TRAILING).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE).addGap(0, 469, Short.MAX_VALUE)
				.addGap(0, 469, Short.MAX_VALUE)
				.addGroup(gl_line7.createSequentialGroup().addContainerGap().addComponent(lblCharisma_2_1_1_1)
						.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
						.addComponent(label_1_1_1_1_1_1).addGap(108).addComponent(button_2_1_1_1_1_1)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(button_1_1_1_1_1_1_1).addGap(6)));
		gl_line7.setVerticalGroup(gl_line7.createParallelGroup(Alignment.TRAILING).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE).addGap(0, 47, Short.MAX_VALUE)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_line7.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_line7.createParallelGroup(Alignment.BASELINE).addComponent(lblCharisma_2_1_1_1)
								.addComponent(label_1_1_1_1_1_1).addComponent(button_1_1_1_1_1_1_1)
								.addComponent(button_2_1_1_1_1_1))
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

		JLabel label = new JLabel("1/10");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton button = new JButton("-");
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setContentAreaFilled(false);
		button.setAlignmentY(0.0f);

		JButton button_1 = new JButton("+");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setContentAreaFilled(false);
		button_1.setAlignmentY(0.0f);
		GroupLayout gl_line1 = new GroupLayout(line1);
		gl_line1.setHorizontalGroup(gl_line1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_line1.createSequentialGroup().addContainerGap().addComponent(lblStrke)
						.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE).addComponent(label)
						.addGap(108).addComponent(button).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(button_1).addGap(6)));
		gl_line1.setVerticalGroup(
				gl_line1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_line1.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_line1.createParallelGroup(Alignment.BASELINE).addComponent(lblStrke)
										.addComponent(label).addComponent(button_1).addComponent(button))
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
}
