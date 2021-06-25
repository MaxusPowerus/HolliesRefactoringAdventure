package QuestClasses;

import java.util.ArrayList;

import entities.Player;
import items.Item;
import map.Biom;
import utilities.Coordinate;
import utilities.Flag;
import utilities.Skill;

public abstract class Quest {

	private static int instanceLimit;

	private boolean active;
	private boolean finished;

	private boolean updateOnEnter;

	private Coordinate targetPoint;
	private ArrayList<Coordinate> targetZone;
	private Biom biom;

	private boolean appearsInQuestLog;

	//// questLog
	private String Title;
	private String questInfo;

	// infoPanel
	private String WorldInfoLine;

	// get this Lonz!======================================
	ArrayList<Possibility> possibilities;
	// ===================================================

	private ArrayList<Flag> flags;

	public Quest(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom,
			boolean updateOnEnter, boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<Possibility> possibilities, ArrayList<Flag> flags) {
		super();
		this.active = false;
		this.finished = false;
		this.targetPoint = targetPoint;
		this.targetZone = targetZone;
		this.biom = biom;
		this.updateOnEnter = updateOnEnter;
		this.appearsInQuestLog = appearsInQuestLog;
		Title = title;
		this.questInfo = questInfo;
		WorldInfoLine = worldInfoLine;
		this.possibilities = possibilities;
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

	public void setQuest(int instanceLimit, Coordinate targetPoint, ArrayList<Coordinate> targetZone, Biom biom,
			boolean appearsInQuestLog, String title, String questInfo, String worldInfoLine,
			ArrayList<Possibility> possibilities, ArrayList<Flag> flags) {

		this.active = false;
		this.finished = false;
		this.targetPoint = targetPoint;
		this.targetZone = targetZone;
		this.biom = biom;
		this.appearsInQuestLog = appearsInQuestLog;
		Title = title;
		this.questInfo = questInfo;
		WorldInfoLine = worldInfoLine;
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

	public static int getInstanceLimit() {
		return instanceLimit;
	}

	public static void setInstanceLimit(int instanceLimit) {
		Quest.instanceLimit = instanceLimit;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	/*
	 * public ArrayList<Possibility> getPossibilities() { return possibilities; }
	 * 
	 * public void setPossibilities(ArrayList<Possibility> possibilities) {
	 * this.possibilities = possibilities; }
	 */

	// Lösche mich
	public ArrayList<String> getPossibilities() {
		ArrayList<String> p = new ArrayList<String>();
		for (int i = 0; i < this.possibilities.size(); i++) {
			p.add(this.possibilities.get(i).getLine());
		}
		return p;
	}

	// Lösche mich
	public void setPossibilities(ArrayList<String> possibilities) {
		ArrayList<String> p = new ArrayList<String>();
		for (int i = 0; i < possibilities.size(); i++) {
			this.possibilities.get(i).setLine(possibilities.get(i));
		}
	}

	// Lösche mich
	public ArrayList<String> getPossibilitiesButtonlabels() {
		ArrayList<String> pbl = new ArrayList<String>();
		for (int i = 0; i < this.possibilities.size(); i++) {
			pbl.add(this.possibilities.get(i).getButtonLabel());
			System.out.println(pbl.get(i));
		}

		return pbl;
	}

	// Lösche mich
	public void setPossibilitiesButtonlabels(ArrayList<String> possibilitiesButtonlabels) {
		for (int i = 0; i < this.possibilities.size(); i++) {
			this.possibilities.get(i).setButtonLabel(possibilitiesButtonlabels.get(i));
		}
	}

	// Lösche mich
	public ArrayList<Integer> getPossibilitiesChances() {
		ArrayList<Integer> pc = new ArrayList<Integer>();
		for (int i = 0; i < this.possibilities.size(); i++) {
			pc.add(this.possibilities.get(i).getChance());
		}
		return pc;
	}

	// Lösche mich
	public void setPossibilitiesChances(ArrayList<Integer> possibilitiesChances) {
		for (int i = 0; i < possibilities.size(); i++) {
			this.possibilities.get(i).setChance(possibilitiesChances.get(i));
		}
	}

	public ArrayList<Flag> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<Flag> flags) {
		this.flags = flags;
	}
}
