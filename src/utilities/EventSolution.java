package utilities;

import java.util.ArrayList;

import entities.Player;
import items.Item;

public class EventSolution {
	private String name;
	private String solutionShort;
	private String solutionTry;
	private String success;
	private String failure;

	private Skill requiredSkill;
	private int requiredSkillValue;
	private ArrayList<Item> requiredItems;
	private boolean needOnlyOneItem;
	private boolean needItemPermanet;
	private int rewardXp;
	private ArrayList<Item> rewardItems;
	private int rewardGold;
	private int takeDamage;

	public EventSolution(String name, String solutionShort, String solutionTry, String success, String failure,
			Skill requiredSkill, int requiredSkillValue, ArrayList<Item> requiredItems, boolean needOnlyOneItem,
			boolean needItemPermanet, int rewardXp, ArrayList<Item> rewardItems, int rewardGold, int takeDamage) {

		this.name = name;
		this.solutionShort = solutionShort;
		this.solutionTry = solutionTry;
		this.success = success;
		this.failure = failure;
		this.requiredSkill = requiredSkill;
		this.requiredSkillValue = requiredSkillValue;
		this.requiredItems = requiredItems;
		this.needOnlyOneItem = needOnlyOneItem;
		this.needItemPermanet = needItemPermanet;
		this.rewardXp = rewardXp;
		this.rewardItems = rewardItems;
		this.rewardGold = rewardGold;
		this.takeDamage = takeDamage;
	}

	public void printParameter() {
		System.out.println("solutionTry: " + solutionTry);
		System.out.println("success: " + success);
		System.out.println("failure: " + failure);
		if (requiredSkill != null) {
			System.out.println(
					"RequiredSkill: " + requiredSkill.toString() + ", RequiredSkillValue: " + requiredSkillValue);
		} else {
			System.out.println("RequiredSkill: " + ">empty< " + ", RequiredSkillValue: " + ">empty<");

		}
		if (requiredItems != null) {
			for (int i = 0; i < requiredItems.size(); i++) {
				System.out.println("RequiredItem " + i + ": " + requiredItems.get(i).getName());
			}
		} else {
			System.out.println("requiredItems: >empty<");
		}

		System.out.println("needOnlyOneItem: " + needOnlyOneItem);
		System.out.println("needItemPermanet:" + needItemPermanet);

		System.out.println("rewardXp: " + rewardXp);

		if (rewardItems != null) {
			for (int i = 0; i < requiredItems.size(); i++) {
				System.out.println("RewardItem " + i + ": " + rewardItems.get(i).getName());
			}
		} else {
			System.out.println("RewardItems: >empty<");
		}
		System.out.println("rewardGold: " + rewardGold);
		System.out.println("takeDamage: " + takeDamage);
	}

	public void rewardPlayer(Player player) {
		player.getExperience().addXp(rewardXp);
		player.getInventory().add(rewardItems, rewardGold);

	}

	public void punishPlayer(Player player) {
		player.setHealth(player.getHealth() - takeDamage);
	}

	public boolean tryIt(Player player) {

		return true;
	}

	public boolean tryIt2(Player player) {

		if (requiredSkill != null) {
			if (player.getSkillSet().getSkillValue(requiredSkill) < requiredSkillValue) {
				return false;
			}
		}

		if (requiredItems != null) {

			for (int i = 0; i < player.getInventory().getAllItems().size(); i++) {
				for (int j = 0; j < getRequiredItems().size(); j++) {
					if (player.getInventory().getAllItems().get(i) == getRequiredItems().get(j)) {
						player.getInventory().remove(player.getInventory().getAllItems().get(i));
						return true;
					}
				}
			}
		}

		/*
		 * if (requiredItems != null) { if (needOnlyOneItem) { for (int i = 0; i <
		 * requiredItems.size(); i++) { for (int j = 0; j <
		 * player.getInventory().getAllItems().size(); j++) { if
		 * (requiredItems.get(i).getName()
		 * .equals(player.getInventory().getAllItems().get(j).getName())) { if
		 * (needItemPermanet)
		 * player.getInventory().remove(player.getInventory().getAllItems().get(i));
		 * return true; }
		 * 
		 * } } } else { boolean found = false; for (int i = 0; i < requiredItems.size();
		 * i++) { found = false; for (int j = 0; j <
		 * player.getInventory().getAllItems().size(); j++) { if
		 * (requiredItems.get(i).getName()
		 * .equals(player.getInventory().getAllItems().get(j).getName())) { found =
		 * true; if (needItemPermanet)
		 * player.getInventory().remove(player.getInventory().getAllItems().get(i));
		 * return true; } if (found == false) return false; } } } }
		 */

		return true;
	}

	public String getSolutionTry() {
		return solutionTry;
	}

	public String getSuccess() {
		return success;
	}

	public String getFailure() {
		return failure;
	}

	public Skill getRequiredSkill() {
		return requiredSkill;
	}

	public int getRequiredSkillValue() {
		return requiredSkillValue;
	}

	public ArrayList<Item> getRequiredItems() {
		return requiredItems;
	}

	public boolean isNeedOnlyOneItem() {
		return needOnlyOneItem;
	}

	public boolean isNeedItemPermanet() {
		return needItemPermanet;
	}

	public int getRewardXp() {
		return rewardXp;
	}

	public ArrayList<Item> getRewardItems() {
		return rewardItems;
	}

	public int getRewardGold() {
		return rewardGold;
	}

	public String getSolutionShort() {
		return solutionShort;
	}

	public int getTakeDamage() {
		return takeDamage;
	}

	public String getName() {
		return name;
	}
}
