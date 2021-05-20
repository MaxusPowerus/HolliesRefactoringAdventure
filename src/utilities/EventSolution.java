package utilities;

import java.util.ArrayList;

import entities.Player;
import items.Item;

public class EventSolution {
	private String success;
	private String failure;
	private Skill requiredSkill;
	private int requiredSkillValue;
	private ArrayList<Item> requiredItems;
	private boolean needOnlyOneItem;
	private boolean needItemPermanet;
	private int rewardXp;
	private ArrayList<Item> rewardItems;

	public EventSolution(String success, String failure, Skill requiredSkill, int requiredSkillValue,
			String[] requiredItems, boolean needOnlyOneItem, boolean needItemPermanet, int rewardXp,
			ArrayList<Item> rewardItems) {

		this.success = success;
		this.failure = failure;
		this.requiredSkill = requiredSkill;
		this.requiredSkillValue = requiredSkillValue;
		this.requiredItems = getItemsFromStringArrayForArrayList(requiredItems);
		this.needOnlyOneItem = needOnlyOneItem;
		this.needItemPermanet = needItemPermanet;
		this.rewardXp = rewardXp;
		this.rewardItems = rewardItems;
	}

	public boolean tryIt(Player player) {

		if (requiredSkill != null) {
			if (player.getSkillSet().getSkillValue(requiredSkill) < requiredSkillValue) {
				return false;
			}
		}
		if (requiredItems != null) {
			if (needOnlyOneItem) {

				for (int i = 0; i < requiredItems.size(); i++) {
					for (int j = 0; j < player.getInventory().getAllItems().size(); j++) {
						if (requiredItems.get(i).getName()
								.equals(player.getInventory().getAllItems().get(j).getName())) {
							if (needItemPermanet)
								player.getInventory().remove(player.getInventory().getAllItems().get(i));
							return true;
						}

					}
				}
			} else {
				boolean found = false;
				for (int i = 0; i < requiredItems.size(); i++) {
					found = false;
					for (int j = 0; j < player.getInventory().getAllItems().size(); j++) {
						if (requiredItems.get(i).getName()
								.equals(player.getInventory().getAllItems().get(j).getName())) {
							found = true;
							if (needItemPermanet)
								player.getInventory().remove(player.getInventory().getAllItems().get(i));
							return true;
						}
						if (found == false)
							return false;
					}
				}
			}
		}

		return true;
	}

	public ArrayList<Item> getItemsFromStringArrayForArrayList(String[] stringArray) {
		ArrayList<Item> arrayList = new ArrayList<Item>();
		return arrayList;
	}

}
