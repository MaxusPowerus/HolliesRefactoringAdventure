package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public class QuestLolosCat extends Quest {
	public QuestLolosCat(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<String> possibilities, ArrayList<String> possibilitiesButtonlabels,
			ArrayList<Integer> possibilitiesChances, ArrayList<Flag> flags) {
		super(instanceLimit, targetPoint, targetZone, appearsInQuestLog, title, questInfo, worldInfoLine, possibilities,
				possibilitiesButtonlabels, possibilitiesChances, flags);

	}

	@Override
	// attempt = possibilities.get(was der player wählt)
	public void update(String attempt, Player player) {
		if (super.isActive() == false && super.isFinished() == false
				&& player.getCurrentMapField().getCoordinate().equals(super.getTargetPoint())) {
			super.setActive(true);
			super.getPossibilities().add("Suche nach Lolos Katze");
			super.setNewFlag("searchCat");
		}

		switch (getActiveFlagName()) {
		case "searchCat":
			if (attempt.equals(getPossibilities().get(0))) {
				if (player.getSkillSet().getSkillValue(Skill.PERCEPTION) < 5) {
					super.setNewFlag("getCat");
					super.setQuestInfo(
							"Du entdeckst die Katze in einem Busch und schnappst sie dir!<br>Bringe sie zurück zu Lolo.");
					super.setWorldInfoLine(
							"Du entdeckst die Katze in einem Busch und schnappst sie dir!<br>Bringe sie zurück zu Lolo.");
					super.getPossibilities().clear();
					super.getPossibilities().add("Lolo die Katze zurückgeben.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten");

				} else {
					super.setNewFlag("catchCat");
					super.setQuestInfo(
							"Du entdeckst die Katze allerdings etwas zu spät als sie sich bereits auf der Flucht befindet.<br>Wenn du sie jetzt Fangen willst musst du sehr schnell sein!");
					super.setWorldInfoLine(
							"Du entdeckst die Katze allerdings etwas zu spät als sie sich bereits auf der Flucht befindet.<br>Wenn du sie jetzt Fangen willst musst du sehr schnell sein!");
					super.getPossibilities().clear();
					super.getPossibilities().add("Lolo sagen, dass du seine Katze verloren hast.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten");
				}

			}
			break;
		case "getCat":
			if (attempt.equals(getPossibilities().get(0))) {
				player.getExperience().addXp(100);
				super.setQuestInfo("Lolo ist überglücklich, das du ihn mit seinem Liebsten wiedervereint hast!");
				super.setWorldInfoLine("Lolo ist überglücklich, das du ihn mit seinem Liebsten wiedervereint hast!");
				super.setActive(false);
				super.setFinished(true);
			}

			break;

		case "catchCat":
			if (attempt.equals(getPossibilities().get(0))) {
				if (player.getSkillSet().getSkillValue(Skill.AGILITY) < 7) {
					super.setNewFlag("getCat");
					super.getPossibilities().add("Lolo die Katze zurückgeben.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten");
				} else {
					super.setNewFlag("looseCat");
					super.getPossibilities().add("Lolo sagen, dass du seine Katze verloren hast.");
					super.getPossibilitiesButtonlabels().add("Lolo berichten");
				}
			}
			break;

		case "looseCat":
			if (attempt.equals(getPossibilities().get(0))) {

				super.setQuestInfo("Lolo ist sehr traurig, die Katze war sein bester Freund");
				super.setWorldInfoLine("Lolo ist sehr traurig, die Katze war sein bester Freund");
				super.setActive(false);
				super.setFinished(true);
			}

			break;
		}

	}

	@Override
	public void update(Player player) {
		// TODO Auto-generated method stub

	}

}
