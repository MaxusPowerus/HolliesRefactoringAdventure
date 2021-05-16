package basic;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
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
import utilities.Inventory;

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

			JSONObject itemObj = (JSONObject) parser.parse(fileReader);
			itemObj = (JSONObject) itemObj.get("Categories");
			Set<Map> set = itemObj.keySet();
			Iterator<Map> itr = set.iterator();

			for (Object key : itemObj.keySet()) {
				Object value = itemObj.get(key);

				JSONObject category = (JSONObject) itemObj.get(itr.next());
				Set<Map> categoryItem = category.keySet();
				Iterator<Map> itemItr = categoryItem.iterator();

				for (int i = 0; i < categoryItem.size(); i++) {
					JSONObject innerItem = (JSONObject) category.get(itemItr.next());
					Item item = null;

					String label = new String(innerItem.get("label").toString().getBytes(), StandardCharsets.UTF_8);

					switch (key.toString()) {
					case "Weapons":
						item = new Weapon(categoryItem.toArray()[i].toString(), label,
								Integer.valueOf(String.valueOf(innerItem.get("value"))),
								Integer.valueOf(innerItem.get("value").toString()));
						break;
					case "Outfits":
						item = new Outfit(categoryItem.toArray()[i].toString(), label,
								Integer.valueOf(String.valueOf(innerItem.get("value"))),
								Integer.valueOf(innerItem.get("armor").toString()));
						break;
					case "Food":
						item = new Food(categoryItem.toArray()[i].toString(), label,
								Integer.valueOf(String.valueOf(innerItem.get("value"))),
								Integer.valueOf(innerItem.get("energy").toString()));
						break;
					default:
						item = new Item(categoryItem.toArray()[i].toString(), label,
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

	public Item getItemByUniqueName(String uniqueName) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getUniqueName().equalsIgnoreCase(uniqueName)) {
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

					String label = new String(innerEntity.get("label").toString().getBytes(), StandardCharsets.UTF_8);

					switch (key.toString()) {
					case "Enemy":
						npc = new Enemy(label, innerEntity.get("prefix").toString(),
								Double.valueOf(innerEntity.get("damage").toString()),
								Double.valueOf(innerEntity.get("health").toString()),
								Integer.valueOf(innerEntity.get("st").toString()),
								Integer.valueOf(innerEntity.get("pe").toString()),
								Integer.valueOf(innerEntity.get("en").toString()),
								Integer.valueOf(innerEntity.get("ch").toString()),
								Integer.valueOf(innerEntity.get("in").toString()),
								Integer.valueOf(innerEntity.get("ag").toString()),
								Integer.valueOf(innerEntity.get("lk").toString()), innerEntity.get("biom").toString());

						Inventory enemyInv = new Inventory();

						JSONObject enemiesItemList = (JSONObject) innerEntity.get("items");
						Set<Map> enemiesItems = enemiesItemList.keySet();
						Iterator<Map> enemiesItemItr = enemiesItems.iterator();

						for (int i = 0; i < enemiesItemList.size(); i++) {
							JSONObject enemiesItem = (JSONObject) enemiesItemList.get(enemiesItemItr.next());

							Item item = this.getItemByUniqueName(enemiesItems.toArray()[i].toString());
							item.setCount(Integer.valueOf(enemiesItem.get("amount").toString()));
							enemyInv.add(item);
						}

						npc.setInventory(enemyInv);

						break;
					case "Friend":
						npc = new Friend(label, innerEntity.get("prefix").toString());

						Inventory friendInv = new Inventory();

						JSONObject friendsItemList = (JSONObject) innerEntity.get("items");
						Set<Map> friendsItems = friendsItemList.keySet();
						Iterator<Map> friendsItemItr = friendsItems.iterator();

						for (int i = 0; i < friendsItemList.size(); i++) {
							JSONObject friendsItem = (JSONObject) friendsItemList.get(friendsItemItr.next());

							Item item = this.getItemByUniqueName(friendsItems.toArray()[i].toString());
							item.setCount(Integer.valueOf(friendsItem.get("amount").toString()));
							item.setDiscount(Double.valueOf(friendsItem.get("discount").toString()));
							friendInv.add(item);
						}

						npc.setInventory(friendInv);

						break;
					default:
						npc = new NPC(label, innerEntity.get("prefix").toString());
						break;
					}

					this.npcs.add(npc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NPC> getNpcs() {
		return npcs;
	}
}
