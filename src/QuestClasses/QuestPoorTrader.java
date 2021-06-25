package QuestClasses;

import java.util.ArrayList;

import basic.GameManager;
import entities.Merchant;
import entities.Player;
import gui.actions.InventoryShowAction;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Inventory;
import utilities.Skill;

public class QuestPoorTrader extends Quest {
	public QuestPoorTrader(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom, boolean updateOnEnter,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<Possibility> possibilities, ArrayList<Flag> flags) {
		super(targetPoint, targetZone, biom, updateOnEnter, appearsInQuestLog, title, questInfo, worldInfoLine,
				possibilities, flags);

	}

	@Override
	public void update(String attempt, Player player) {

		if (super.isUpdateOnEnter() == false) {
			return;
		}

		System.out.println(" EnterUpdate - ActiveFalg: " + super.getActiveFlagName());

		switch (getActiveFlagName()) {
		case "start":
			if (attempt.equals(super.possibilities.get(0).getButtonLabel())) {
				if (basicSkillCheck(player, Skill.CHARISMA, 10)) {
					GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
							.setNewFlag("success");
					super.setQuestInfo("Du hast das Amulett umsonst zurückbekommen, gehe zu Theodoras!");
					super.setWorldInfoLine("Händler: \"Nagut...ich wusste ja nicht wie viel es ihm bedeutet...\"");
					player.getInventory()
							.add(GameManager.getInstance().getResourceManager().getItemByUniqueName("TheodorasAmulet"));
					setSuccess();
				} else {
					GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
							.setNewFlag("failure");
					super.setQuestInfo("Du hast das Amulett nicht zurück bekommen, gehe zu Theodoras!");
					super.setWorldInfoLine(
							"Händler: \"Haha...mach dich nicht lächerlich kleine, ich verschenke doch nicht meine Ware!");

					setFailure();

				}
				super.clearPossibilities();

				super.setUpdateOnEnter(false);
				super.setActive(false);
				super.setFinished(true);

			} else if (attempt.equals(super.possibilities.get(1).getButtonLabel())) {
				Inventory inv = new Inventory();
				inv.add(GameManager.getInstance().getResourceManager().getItemByUniqueName("TheodorasAmulet"));
				Merchant merchant = new Merchant("Händler", "den", "Wiese", "HändlerTheodoras", 3);
				merchant.setInventory(inv);
				new InventoryShowAction(GameManager.getInstance(), inv, "Händler", merchant).initBuy();
				if (super.basicUseItem(player, "TheodorasAmulet")) {
					GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
							.setNewFlag("success");
					super.setQuestInfo("Du hast das Amulett zurückgekauft, gehe zu Theodoras!");
					super.setWorldInfoLine("Händler: \"Eine Freude mit euch Geschäfte zu machen!\"");

					super.clearPossibilities();

					setSuccess();

					super.setUpdateOnEnter(false);
					super.setActive(false);
					super.setFinished(true);

				} else {
					return;
				}

			} else if (attempt.equals(super.possibilities.get(2).getButtonLabel())) {
				if (basicSkillCheck(player, Skill.STRENGTH, 6)) {
					GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
							.setNewFlag("success");
					super.setQuestInfo(
							"Du machst den Händlern mit deinen Fäusten bekannt und nimmst dir das Amlett zurück.");
					super.setWorldInfoLine("Händler: \"Nehmt Alles! Aber tut mir nicht weiter weh!\"");
					player.getInventory()
							.add(GameManager.getInstance().getResourceManager().getItemByUniqueName("TheodorasAmulet"));
					player.getInventory().addGold(50);
					setSuccess();
				} else {

					GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
							.setNewFlag("failure");
					super.setQuestInfo(
							"Da warst du wohl zu übermütig, der Händler hebt seine Fäuste und weiß damit umzugehen...du kannst froh sein das du noch lebest! Sag Theodoras bescheid!");
					super.setWorldInfoLine(
							"Händler: \"Ich hoffe das wird dir eine Lehere sein, dass dich Gewalt im Leben nicht weiter bringt, Kleine!\"");
					player.setHealth(player.getHealth() - 30);
					setFailure();
				}
				super.clearPossibilities();

				super.setUpdateOnEnter(false);
				super.setActive(false);
				super.setFinished(true);
			}

			break;

		}
		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}

	@Override
	public void update(Player player) {
		if (isUpdateOnEnter() == false) {
			return;
		}
		System.out.println(" EnterUpdate(Simple) - ActiveFalg: " + super.getActiveFlagName());
		if (super.isActive() == false && super.isFinished() == false) {
			super.setActive(true);
			super.setNewFlag("start");
		}

		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}

	public void setSuccess() {
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.setWorldInfoLine("Und habt ihr das Amullett zurückbekommen?");

		Possibility p1 = new Possibility(
				"\"Es warsehr anstrengend das Amulett zu beschaffen, also werde ich es behalten!\"", "Behalten", -1);
		Possibility p2 = new Possibility(
				"\"Es warsehr anstrengend das Amulett zu beschaffen, deshalb wird es dich eine Kleinigkeit kosten!\"",
				"Verkaufen", -1);
		Possibility p3 = new Possibility("\"Bittesehr\"", "Geben", -1);

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add(p1);
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add(p2);
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add(p3);

		GameManager.getInstance().getMainMap().getMapFieldByCoordinate(super.getTargetPoint()).setQuest(null);
	}

	public void setFailure() {
		Possibility p1 = new Possibility(
				"\"\\\"Es ist mir leider nicht gelungen das Amulet wieder zu bekommen...es tut mir Leid!\\\"\"",
				"Es tut mir Leid...", -1);

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.setWorldInfoLine("Und habt ihr das Amullett zurückbekommen?");
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add(p1);

		GameManager.getInstance().getMainMap().getMapFieldByCoordinate(super.getTargetPoint()).setQuest(null);
	}

}
