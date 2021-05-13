package basic;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entities.Enemy;
import entities.Friend;
import entities.NPC;
import items.Food;
import items.Item;
import items.Outfit;
import items.Weapon;

public class ResourceManager {

	private ArrayList<Item> items;
	private ArrayList<NPC> npcs;

	public ResourceManager() {
		this.items = new ArrayList<Item>();
		this.npcs = new ArrayList<NPC>();
		this.loadItems();
		this.loadNPCs();
	}

	@SuppressWarnings("unchecked")
	private void loadItems() {
		try {
			FileReader fileReader = new FileReader("resources\\items.json");
			JSONParser parser = new JSONParser();

			JSONObject items = (JSONObject) parser.parse(fileReader);
			items = (JSONObject) items.get("Categories");
			Set<Map> set = items.keySet();
			Iterator<Map> itr = set.iterator();

			for (Object key : items.keySet()) {
				Object value = items.get(key);

				JSONObject category = (JSONObject) items.get(itr.next());
				Set<Map> categoryItem = category.keySet();
				Iterator<Map> itemItr = categoryItem.iterator();

				for (int i = 0; i < categoryItem.size(); i++) {
					JSONObject innerItem = (JSONObject) category.get(itemItr.next());
					Item item = null;

					switch (key.toString()) {
					case "Weapons":
						item = new Weapon(categoryItem.toArray()[i].toString(), innerItem.get("label").toString(),
								Integer.valueOf(String.valueOf(innerItem.get("value"))),
								Integer.valueOf(innerItem.get("value").toString()));
						break;
					case "Outfits":
						item = new Outfit(categoryItem.toArray()[i].toString(), innerItem.get("label").toString(),
								Integer.valueOf(String.valueOf(innerItem.get("value"))),
								Integer.valueOf(innerItem.get("armor").toString()));
						break;
					case "Food":
						item = new Food(categoryItem.toArray()[i].toString(), innerItem.get("label").toString(),
								Integer.valueOf(String.valueOf(innerItem.get("value"))),
								Integer.valueOf(innerItem.get("energy").toString()));
						break;
					default:
						item = new Item(categoryItem.toArray()[i].toString(), innerItem.get("label").toString(),
								Integer.valueOf(String.valueOf(innerItem.get("value"))));
						break;
					}

					this.items.add(item);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Item> getAllItems() {
		return items;
	}

	public Item getItemByUniqueName(String name) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getUniqueName().equals(name)) {
				return items.get(i);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private void loadNPCs() {
		try {
			FileReader fileReader = new FileReader("resources\\npcs.json");
			JSONParser parser = new JSONParser();

			JSONObject items = (JSONObject) parser.parse(fileReader);
			items = (JSONObject) items.get("Categories");
			Set<Map> set = items.keySet();
			Iterator<Map> itr = set.iterator();

			for (Object key : items.keySet()) {
				Object value = items.get(key);

				JSONObject category = (JSONObject) items.get(itr.next());
				Set<Map> entity = category.keySet();
				Iterator<Map> entityItr = entity.iterator();

				while (entityItr.hasNext()) {
					JSONObject innerEntity = (JSONObject) category.get(entityItr.next());
					NPC npc;

					switch (key.toString()) {
					case "Enemy":
						npc = new Enemy(innerEntity.get("label").toString(),
								Double.valueOf(innerEntity.get("damage").toString()));

						// TODO as Inventory

						break;
					case "Friend":
						npc = new Friend(innerEntity.get("label").toString());

						// TODO as Inventory

						JSONObject friendsItemList = (JSONObject) innerEntity.get("items");
						Set<Map> friendsItems = friendsItemList.keySet();
						Iterator<Map> friendsItemItr = friendsItems.iterator();

						for (int i = 0; i < friendsItemList.size(); i++) {
							JSONObject friendsItem = (JSONObject) friendsItemList.get(friendsItemItr.next());

							Item item = this.getItemByUniqueName(friendsItems.toArray()[i].toString());
							item.setCount(Integer.valueOf(friendsItem.get("amount").toString()));
							item.setDiscount(Double.valueOf(friendsItem.get("discount").toString()));

							((Friend) npc).addItem(item);
						}

						break;
					default:
						npc = new NPC(innerEntity.get("label").toString());
						break;
					}

					this.npcs.add(npc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
