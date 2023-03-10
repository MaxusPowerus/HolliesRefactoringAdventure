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
		System.out.println(rewardItems.size());
		player.getInventory().add(rewardItems, rewardGold);

	}

	public void punishPlayer(Player player) {
		player.setHealth(player.getHealth() - takeDamage);
	}

	public boolean tryIt(Player player) {
		if (requiredSkill != null) {
			System.out.println("Skill required!");
			if (player.getSkillSet().getSkillValue(requiredSkill) < requiredSkillValue) {
				return false;
			}
		} else {
			System.out.println("No Skill required!");
		}
		if (requiredItems.size() > 0) {
			System.out.println("Item required!");
			return takeItem(player, needItemPermanet, needOnlyOneItem);
		} else {
			System.out.println("No Item required!");
		}
		return true;
	}

	public boolean takeItem(Player player, boolean needItemPermanet, boolean needOnlyOneItem) {
		System.out.println("Enter takeItem");
		if (needOnlyOneItem) {
			for (int i = 0; i < player.getInventory().getAllItems().size(); i++) {
				for (int j = 0; j < getRequiredItems().size(); j++) {
					if (player.getInventory().getAllItems().get(i).equals(getRequiredItems().get(j))) {
						if (needItemPermanet) {
							player.getInventory().remove(player.getInventory().getAllItems().get(i));
						}
						return true;
					}
				}
			}

		} else {
			boolean found = false;
			for (int j = 0; j < getRequiredItems().size(); j++) {
				for (int i = 0; i < player.getInventory().getAllItems().size(); i++) {
					System.out.println(player.getInventory().getAllItems().get(i).getName());
					if (player.getInventory().getAllItems().get(i).equals(getRequiredItems().get(j))) {
						if (needItemPermanet) {
							player.getInventory().remove(player.getInventory().getAllItems().get(i));
							getRequiredItems().remove(j);
						}
						found = true;
						System.out.println("found = true");
					}
				}
				if (found == true) {
					found = false;
				} else {
					return false;
				}
			}
			if (requiredItems.size() == 0) {
				return true;
			}
		}
		return false;
	}

	public int getTryChance(Player player) {
		int chance = 0;
		int chanceFac = 20;
		if (requiredSkill == null && requiredItems.size() == 0) {
			chance = 100;
		} else if (requiredSkill != null && requiredItems.size() == 0) {

			chance = 100 - (player.getSkillSet().getSkillValue(requiredSkill) - requiredSkillValue) * chanceFac;
			if (chance < 5) {
				chance = 5;
			}
			if (chance > 95) {
				chance = 5;
			}
			return chance;
		} else if (requiredSkill == null && requiredItems.size() > 0) {
			for (int i = 0; i < requiredItems.size(); i++) {
				if (needOnlyOneItem) {
					if (player.getInventory().getAllItems().contains(requiredItems.get(i))) {
						return 100;
					}
				} else {
					if (!player.getInventory().getAllItems().contains(requiredItems.get(i))) {
						return 0;
					}
				}
			}
		} else {// requiredSkill != null && requiredItems.size() > 0
			for (int i = 0; i < requiredItems.size(); i++) {
				if (needOnlyOneItem) {
					if (player.getInventory().getAllItems().contains(requiredItems.get(i))) {
						chance = 100;
						break;
					} else {
						chance = 0;
					}

				} else {
					if (!player.getInventory().getAllItems().contains(requiredItems.get(i))) {
						chance = 0;
					} else {
						chance = 100;
					}
				}
			}

		}
		chance = chance - (player.getSkillSet().getSkillValue(requiredSkill) - requiredSkillValue) * (chanceFac / 2);
		if (chance < 5) {
			chance = 5;
		}
		if (chance > 95) {
			chance = 5;
		}

		return chance;
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
