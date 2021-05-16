package gui;

import java.awt.Color;
import java.awt.EventQueue;

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

public class GUIManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIManager window = new GUIManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 920, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(113)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		JLabel lblWald = new JLabel(">>> Wald <<<");

		JLabel lblChallengeErledigt = new JLabel("Challenge: Erledigt");

		JButton btnUntersuchen = new JButton("Untersuchen");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblWald)
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblChallengeErledigt)
										.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
										.addComponent(btnUntersuchen)))
						.addContainerGap()));
		gl_panel_2
				.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(lblWald)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblChallengeErledigt).addComponent(btnUntersuchen))
								.addContainerGap(51, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_3.createSequentialGroup().addContainerGap(318, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap(29, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE).addGap(30)));

		JButton btnNewButton = new JButton("Aktion 1");
		panel_5.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Aktion 2");
		panel_5.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Aktion 3");
		panel_5.add(btnNewButton_2);
		panel_3.setLayout(gl_panel_3);

		JLabel lblNewLabel = new JLabel("Du bist in...");

		JLabel lblDuSiehst = new JLabel("Du siehst...");

		JLabel lblDirGelingt = new JLabel("Dir gelingt...");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDuSiehst, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addComponent(lblDirGelingt, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDuSiehst)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDirGelingt)
						.addContainerGap(104, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JLabel lblMap = new JLabel("Map");
		lblMap.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(107, 142, 35));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblMap, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel.createSequentialGroup()
						.addComponent(lblMap, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE).addContainerGap()));
		panel.setLayout(gl_panel);

		JLabel lblDieKleine = new JLabel(">>> Die kleine Holly <<<");
		lblDieKleine.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblDieKleine.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHp = new JLabel("HP");

		JProgressBar progressBar = new JProgressBar();

		JLabel lblLevel = new JLabel("Level 3");

		JProgressBar progressBar_1 = new JProgressBar();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblHp)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(26).addComponent(lblLevel).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(54, Short.MAX_VALUE))
				.addComponent(lblDieKleine, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(lblDieKleine, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblHp)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLevel).addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(59, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
