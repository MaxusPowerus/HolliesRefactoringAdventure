package QuestClasses;

import java.util.ArrayList;
import java.util.Random;

import basic.GameManager;
import entities.Player;
import items.Item;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public class QuestFishingSwamp extends Quest {

	private int limit;
	private Item fish;

	public QuestFishingSwamp(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom, boolean updateOnEnter,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<Possibility> possibilities, ArrayList<Flag> flags) {
		super(targetPoint, targetZone, biom, updateOnEnter, appearsInQuestLog, title, questInfo, worldInfoLine,
				possibilities, flags);
		Random Randy = new Random();
		limit = Randy.nextInt(5);
		fish = GameManager.getInstance().getResourceManager().getItemByUniqueName("Fish");
	}

	@Override
	public void update(String attempt, Player player) {

		if (super.isUpdateOnEnter() == false) {
			return;
		}

		System.out.println(" EnterUpdate - ActiveFalg: " + super.getActiveFlagName());

		switch (getActiveFlagName()) {
		case "fishing":
			if (attempt.equals(super.possibilities.get(0).getButtonLabel())) {
				if (super.basicUseItem(player, "FishingRod")) {

					setWorldInfoLine("Es dauert einen Moment aber du fängst dir einen saftigen Fisch!");

					player.getInventory().add(fish);
					limit--;

				} else {
					setWorldInfoLine("Besorg dir erstmal einen Angel!");
				}

			} else if (attempt.equals(super.possibilities.get(1).getButtonLabel())) {
				if (super.basicUseItem(player, "Spear")) {
					if (basicSkillCheck(player, Skill.AGILITY, 9)) {
						setWorldInfoLine("Mit viel Geschick fängst du dir einen Fisch");

						player.getInventory().add(fish);
						limit--;
					} else {
						setWorldInfoLine(
								"Dir fehlt einfach das Geschick. Nicht nur dass du nichts fängst, du verscheuchst auch noch Alle Fische!");
						limit = 0;
					}

				} else {
					setWorldInfoLine("Besorg dir erstmal einen Speer!");
				}
			}

			break;

		case "empty":

			setWorldInfoLine("Im Fluss sind keine Fische zu sehen...versuche es später nochmal!");

			super.setUpdateOnEnter(true);
			super.setActive(false);

			break;
		}
		if (limit <= 0) {
			this.setNewFlag("empty");
		}
		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}

	@Override
	public void update(Player player) {

		System.out.println(" EnterUpdate(Simple) - ActiveFalg: " + super.getActiveFlagName());
		if (super.isActive() == false && super.isFinished() == false) {
			super.setActive(true);
			super.setNewFlag("fishing");
		}

		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}
}
