
package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public class QuestPattern extends Quest {
	public QuestPattern(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom, boolean updateOnEnter,
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
		case "flagName":
			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				if (super.basicSkillCheck(player, Skill.PERCEPTION, 5)) {

					// setNewFlag();

					// setWorldInfoLine();
					// setQuestInfo();

					// super.clearPossibilities();

					// Xmal
					// super.getPossibilitiesChances().add(-1);
					// super.getPossibilities().add();
					// super.getPossibilitiesButtonlabels().add();
				} else {

					// setNewFlag();

					// setWorldInfoLine();
					// setQuestInfo();

					// super.clearPossibilities();

					// Xmal
					// super.getPossibilitiesChances().add(-1);
					// super.getPossibilities().add();
					// super.getPossibilitiesButtonlabels().add();
				}

			} else if (attempt.equals(getPossibilitiesButtonlabels().get(1))) {
				/*
				 * 
				 */
			}

			break;

		case "endCase":

			if (attempt.equals(getPossibilitiesButtonlabels().get(0))) {
				// super.setQuestInfo();
				// super.setWorldInfoLine();

				// reward or punish Player (XP, HP, Items, Gold)
			}

			// super.clearPossibilities();

			// super.setUpdateOnEnter(false);
			// super.setActive(false);
			// super.setFinished(true);

			break;

		// more Cases
		/*
		 * 
		 */
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
			super.setNewFlag("flagName");
		}

		System.out.println(" LeaveUpdate - ActiveFalg: " + super.getActiveFlagName());
	}
}
