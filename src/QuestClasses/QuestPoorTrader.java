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
	public QuestPoorTrader(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom,
			boolean updateOnEnter, boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<String> possibilities, ArrayList<String> possibilitiesButtonlabels,
			ArrayList<Integer> possibilitiesChances, ArrayList<Flag> flags) {
		super(instanceLimit, targetPoint, targetZone, biom, updateOnEnter, appearsInQuestLog, title, questInfo,
				worldInfoLine, possibilities, possibilitiesButtonlabels, possibilitiesChances, flags);

	}

	@Override
	public void update(String attempt, Player player) {

		if (super.isUpdateOnEnter() == false) {
			return;
		}

		System.out.println(" EnterUpdate - ActiveFalg: " + super.getActiveFlagName());

		switch (getActiveFlagName()) {
		case "start":
			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
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

			} else if (attempt.equals(getPossibilitiesButtonlabels().get(1))) {
				// TODO
				Merchant merchant = new Merchant("Händler", "den", "Wiese", "HändlerTheodoras", 3);
				Inventory inv = new Inventory();
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

			} else if (attempt.equals(getPossibilitiesButtonlabels().get(2))) {
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
							"Da warst du wohl zu übermütig, der Händler zhebt seine Fäuste und weiß damit umzugehen...du kannst froh sein das du noch lebest! Sag Theodoras bescheid!");
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

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add("\"Es warsehr anstrengend das Amulett zu beschaffen, also werde ich es behalten!\"");
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities().add(
				"\"Es warsehr anstrengend das Amulett zu beschaffen, deshalb wird es dich eine Kleinigkeit kosten!\"");
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add("\"Bittesehr\"");

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesButtonlabels().add("Behalten");
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesButtonlabels().add("Verkaufen");
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesButtonlabels().add("Geben");

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesChances().add(-1);
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesChances().add(-1);
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesChances().add(-1);

		GameManager.getInstance().getMainMap().getMapFieldByCoordinate(super.getTargetPoint()).setQuest(null);
	}

	public void setFailure() {

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.setWorldInfoLine("Und habt ihr das Amullett zurückbekommen?");
		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung").getPossibilities()
				.add("\"Es ist mir leider nicht gelungen das Amulet wieder zu bekommen...es tut mir Leid!\"");

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesButtonlabels().add("Es tut mir Leid...");

		GameManager.getInstance().getQuestManager().getQuestByTitle("Eine falsche Entscheidung")
				.getPossibilitiesChances().add(-1);

		GameManager.getInstance().getMainMap().getMapFieldByCoordinate(super.getTargetPoint()).setQuest(null);
	}

}
