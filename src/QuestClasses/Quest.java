package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import items.Item;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public abstract class Quest {

	private static int instanceLimit;

	private boolean active;
	private boolean finished;

	private Coordinate targetPoint;
	private ArrayList<Coordinate> targetZone;

	private boolean appearsInQuestLog;

	//// questLog
	private String Title;
	private String questInfo;

	// infoPanel
	private String WorldInfoLine;

	// get this Lonz!======================================
	private ArrayList<String> possibilities;
	private ArrayList<String> possibilitiesButtonlabels;
	private ArrayList<Integer> possibilitiesChances;
	// ===================================================

	private ArrayList<Flag> flags;

	public Quest(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone, boolean appearsInQuestLog,
			String title, String questInfo, String worldInfoLine, ArrayList<String> possibilities,
			ArrayList<String> possibilitiesButtonlabels, ArrayList<Integer> possibilitiesChances,
			ArrayList<Flag> flags) {
		super();
		this.active = false;
		this.finished = false;
		this.targetPoint = targetPoint;
		this.targetZone = targetZone;
		this.appearsInQuestLog = appearsInQuestLog;
		Title = title;
		this.questInfo = questInfo;
		WorldInfoLine = worldInfoLine;
		this.possibilities = possibilities;
		this.possibilitiesButtonlabels = possibilitiesButtonlabels;
		this.possibilitiesChances = possibilitiesChances;
		this.flags = flags;
		this.instanceLimit--;
	}

	public Quest() {
		/*
		 * Flag firstFlag = new Flag("first"); Flag secondFlag = new Flag("second");
		 * Flag thirdFlag = new Flag("third");
		 * 
		 * flags.add(firstFlag); flags.add(secondFlag); flags.add(thirdFlag);
		 */
	}

	public void setQuest(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<String> possibilities, ArrayList<String> possibilitiesButtonlabels, ArrayList<Flag> flags) {

		this.active = false;
		this.finished = false;
		this.targetPoint = targetPoint;
		this.targetZone = targetZone;
		this.appearsInQuestLog = appearsInQuestLog;
		Title = title;
		this.questInfo = questInfo;
		WorldInfoLine = worldInfoLine;
		this.possibilities = possibilities;
		this.possibilitiesButtonlabels = possibilitiesButtonlabels;
		this.flags = flags;
		this.instanceLimit--;
	}

	public void trigger() {
		finished = true;
		flags.get(0).setValue(true);
	}

	public abstract void update(String attempt, Player player);

	public abstract void update(Player player);
	// {
	/*
	 * String activeFlag = getActiveFlag();
	 * 
	 * switch (activeFlag) { case "firstFlag": firstFlagFunctio(attempt, player);
	 * break;
	 * 
	 * case "secondFlag": firstFlagFunctio(attempt, player); break;
	 * 
	 * case "thirdFlag": firstFlagFunctio(attempt, player); break; }
	 */
	// }

	public void firstFlagFunctio(String attempt, Player player) {

	}

	public void secondFlagFunctio(String attempt, Player player) {

	}

	public void thirdFlagFunction(String attempt, Player player) {

	}

	public boolean useSkill(Player player, Skill skill) {

		return false;
	}

	public boolean useOneItem(Player player, Item item, boolean permanet) {
		return false;
	}

	public boolean useOneItem(Player player, ArrayList<Item> item, boolean permanet) {
		return false;
	}

	public void setNewFlag(String name) {
		for (int i = 0; i < flags.size(); i++) {
			if (flags.get(i).getName().equals(name)) {
				flags.get(i).setValue(true);
			} else {
				flags.get(i).setValue(false);
			}
		}
	}

	public String getActiveFlagName() {
		for (int i = 0; i < flags.size(); i++) {
			if (flags.get(i).isValue() == true) {
				return flags.get(i).getName();
			}
		}
		return null;
	}

	public Flag getFlagByName(String flagName) {
		for (int i = 0; i < flags.size(); i++) {
			if (flags.get(i).getName().equals(flagName)) {
				return flags.get(i);
			}
		}
		return null;
	}

	public boolean isActive() {
		return active;
	}

	public boolean isFinished() {
		return finished;
	}

	public static int getInstanceLimit() {
		return instanceLimit;
	}

	public static void setInstanceLimit(int instanceLimit) {
		Quest.instanceLimit = instanceLimit;
	}

	public Coordinate getTargetPoint() {
		return targetPoint;
	}

	public void setTargetPoint(Coordinate targetPoint) {
		this.targetPoint = targetPoint;
	}

	public ArrayList<Coordinate> getTargetZone() {
		return targetZone;
	}

	public void setTargetZone(ArrayList<Coordinate> targetZone) {
		this.targetZone = targetZone;
	}

	public boolean isAppearsInQuestLog() {
		return appearsInQuestLog;
	}

	public void setAppearsInQuestLog(boolean appearsInQuestLog) {
		this.appearsInQuestLog = appearsInQuestLog;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getQuestInfo() {
		return questInfo;
	}

	public void setQuestInfo(String questInfo) {
		this.questInfo = questInfo;
	}

	public String getWorldInfoLine() {
		return WorldInfoLine;
	}

	public void setWorldInfoLine(String worldInfoLine) {
		WorldInfoLine = worldInfoLine;
	}

	public ArrayList<String> getPossibilities() {
		return possibilities;
	}

	public void setPossibilities(ArrayList<String> possibilities) {
		this.possibilities = possibilities;
	}

	public ArrayList<String> getPossibilitiesButtonlabels() {
		return possibilitiesButtonlabels;
	}

	public void setPossibilitiesButtonlabels(ArrayList<String> possibilitiesButtonlabels) {
		this.possibilitiesButtonlabels = possibilitiesButtonlabels;
	}

	public ArrayList<Flag> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<Flag> flags) {
		this.flags = flags;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public ArrayList<Integer> getPossibilitiesChances() {
		return possibilitiesChances;
	}

	public void setPossibilitiesChances(ArrayList<Integer> possibilitiesChances) {
		this.possibilitiesChances = possibilitiesChances;
	}

}
