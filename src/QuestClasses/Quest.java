package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import items.Item;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public abstract class Quest {

	private int instanceLimit;

	private boolean active;
	private boolean finished;

	private boolean updateOnEnter;

	private Coordinate targetPoint;
	private ArrayList<Coordinate> targetZone;
	private Biom biom;

	private boolean appearsInQuestLog;

	//// questLog
	private String title;
	private String questInfo;
	private ArrayList<String> allQuestInfoLines;

	// infoPanel
	private String worldInfoLine;

	// get this Lonz!======================================
	ArrayList<Possibility> possibilities;
	// ===================================================

	private ArrayList<Flag> flags;

	public Quest(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom, boolean updateOnEnter,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<Possibility> possibilities, ArrayList<Flag> flags) {
		super();
		this.active = false;
		this.finished = false;
		this.targetPoint = targetPoint;
		this.targetZone = targetZone;
		this.biom = biom;
		this.updateOnEnter = updateOnEnter;
		this.appearsInQuestLog = appearsInQuestLog;
		this.title = title;
		this.questInfo = questInfo;
		this.allQuestInfoLines = new ArrayList<String>();
		// DEBUG START
		this.allQuestInfoLines.add("Line 1");
		this.allQuestInfoLines.add("Line 2");
		// DEBUG END
		this.worldInfoLine = worldInfoLine;
		this.possibilities = possibilities;
		this.flags = flags;
		// this.instanceLimit--;
	}

	public Quest() {
		/*
		 * Flag firstFlag = new Flag("first"); Flag secondFlag = new Flag("second");
		 * Flag thirdFlag = new Flag("third");
		 * 
		 * flags.add(firstFlag); flags.add(secondFlag); flags.add(thirdFlag);
		 */
	}

	public void setQuest(Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom, boolean appearsInQuestLog,
			String title, String questInfo, String worldInfoLine, ArrayList<Possibility> possibilities,
			ArrayList<Flag> flags) {

		this.active = false;
		this.finished = false;
		this.targetPoint = targetPoint;
		this.targetZone = targetZone;
		this.biom = biom;
		this.appearsInQuestLog = appearsInQuestLog;
		this.title = title;
		this.questInfo = questInfo;
		this.worldInfoLine = worldInfoLine;
		this.possibilities = possibilities;
		this.flags = flags;
		this.instanceLimit--;
	}

	public void trigger() {
		finished = true;
		flags.get(0).setValue(true);
	}

	public abstract void update(String attempt, Player player);

	public abstract void update(Player player);

	// abstract public void rewardPlayer(Player player);
	// abstract public void punishPlayer(Player player);

	public void clearPossibilities() {
		this.possibilities.clear();
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

	public void setAllFlagsOff() {
		for (int i = 0; i < flags.size(); i++) {
			flags.get(i).setValue(false);
		}
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

	public boolean basicSkillCheck(Player player, Skill skill, int threshold) {
		if (player.getSkillSet().getSkillValue(skill) >= threshold) {
			return true;
		} else {
			return false;
		}
	}

	public boolean basicUseItem(Player player, String itemName) {
		for (int i = 0; i < player.getInventory().getAllItems().size(); i++) {
			if (player.getInventory().getAllItems().get(i).getUniqueName().equals(itemName)) {
				return true;
			}
		}
		return false;

	}

	public int getInstanceLimit() {
		return instanceLimit;
	}

	public void setInstanceLimit(int instanceLimit) {
		// Quest.instanceLimit = instanceLimit;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ArrayList<String> getAllQuestInfoLines() {
		return allQuestInfoLines;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isUpdateOnEnter() {
		return updateOnEnter;
	}

	public void setUpdateOnEnter(boolean updateOnEnter) {
		this.updateOnEnter = updateOnEnter;
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

	public Biom getBiom() {
		return biom;
	}

	public void setBiom(Biom biom) {
		this.biom = biom;
	}

	public boolean isAppearsInQuestLog() {
		return appearsInQuestLog;
	}

	public void setAppearsInQuestLog(boolean appearsInQuestLog) {
		this.appearsInQuestLog = appearsInQuestLog;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestInfo() {
		return questInfo;
	}

	public void setQuestInfo(String questInfo) {
		this.questInfo = questInfo;
	}

	public String getWorldInfoLine() {
		return worldInfoLine;
	}

	public void setWorldInfoLine(String worldInfoLine) {
		this.worldInfoLine = worldInfoLine;
	}

	public ArrayList<Possibility> getPossibilities() {
		return possibilities;
	}

	public void setPossibilities(ArrayList<Possibility> possibilities) {
		this.possibilities = possibilities;
	}

	public ArrayList<Flag> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<Flag> flags) {
		this.flags = flags;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		return ((Quest) obj).getTitle() == this.title;
	}
}
