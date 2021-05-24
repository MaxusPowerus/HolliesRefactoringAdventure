package gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import basic.GameManager;
import entities.Merchant;
import entities.Player;
import gui.actions.InventoryShowAction;
import gui.actions.MapShowAction;
import utilities.Challenge;

public class BuyButton extends JButton implements ActionListener {

	private Challenge challenge;
	private Player player;
	private GameManager gameManager;

	public BuyButton(Challenge challenge, Player player, GameManager gameManager) {
		this.challenge = challenge;
		this.player = player;
		this.gameManager = gameManager;

		this.setText("Kaufen");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.gameManager.getGuiManager().setNavigationEnabled(false);
		new InventoryShowAction(this.gameManager, ((Merchant) challenge.getNpc()).getInventory(),
				"Items kaufen: Inventar des H�ndlers", (Merchant) this.challenge.getNpc()).initBuy();

		JButton stopHandling = new JButton("Handel beenden");
		stopHandling.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MapShowAction(gameManager).initialize();

				gameManager.getGuiManager()
						.addFieldInfo("Du hast den Handel mit <b>" + challenge.getNpc().getName() + "</b> beendet");

				gameManager.getGuiManager().getActionButtonPanel().removeAll();

				BuyButton buyButton = new BuyButton(challenge, player, gameManager);
				gameManager.getGuiManager().getActionButtonPanel().add(buyButton);

				SellButton sellButton = new SellButton(challenge, player, gameManager);
				gameManager.getGuiManager().getActionButtonPanel().add(sellButton);

				gameManager.getGuiManager().setNavigationEnabled(true);
				gameManager.update();
			}
		});
		this.gameManager.getGuiManager().getActionButtonPanel().removeAll();
		this.gameManager.getGuiManager().getActionButtonPanel().add(stopHandling);
	}

}