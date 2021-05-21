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
import entities.Merchant;
import entities.NPC;
import items.Food;
import items.Item;
import items.Note;
import items.Other;
import items.Outfit;
import items.Weapon;
import utilities.Inventory;

public class ResourceManager {

	private ArrayList<Food> food;

	private ArrayList<NPC> npcs;

	public ResourceManager() {
		this.food = new ArrayList<Food>();

		this.npcs = new ArrayList<NPC>();
		this.loadFood();
//		this.loadNPCs();
	}

	@SuppressWarnings("unchecked")
	private void loadFood() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\Food.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String label : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(label);

				Food item = new Food(label, jsonItem.get("label").toString(),
						Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("energy").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()));

				this.food.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Item> getAllItems() {
		ArrayList<Item> cloned = new ArrayList<Item>();
		for (Item item : this.items) {
			cloned.add(item);
		}

		return cloned;
	}

	public ArrayList<Weapon> getWeapons() {
		ArrayList<Weapon> out = new ArrayList<Weapon>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Weapon) {
				out.add((Weapon) items.get(i).clone());
			}
		}
		return out;
	}

	public ArrayList<Outfit> getOutfits() {
		ArrayList<Outfit> out = new ArrayList<Outfit>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Outfit) {
				out.add((Outfit) items.get(i).clone());
			}
		}
		return out;
	}

	public ArrayList<Food> getFood() {
		ArrayList<Food> out = new ArrayList<Food>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Food) {
				out.add((Food) items.get(i).clone());
			}
		}
		return out;
	}

	public ArrayList<Note> getNotes() {
		ArrayList<Note> out = new ArrayList<Note>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Note) {
				out.add((Note) items.get(i).clone());
			}
		}
		return out;
	}

	public ArrayList<Other> getOther() {
		ArrayList<Other> out = new ArrayList<Other>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Other) {
				out.add((Other) items.get(i).clone());
			}
		}
		return out;
	}

	public Item getItemByUniqueName(String uniqueName) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getUniqueName().equalsIgnoreCase(uniqueName)) {
				return items.get(i).clone();
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
								Integer.valueOf(innerEntity.get("lk").toString()), innerEntity.get("biom").toString(),
								Integer.valueOf(innerEntity.get("xp").toString()));

						Inventory enemyInv = new Inventory();

						JSONObject enemiesItemList = (JSONObject) innerEntity.get("items");
						Set<Map> enemiesItems = enemiesItemList.keySet();
						Iterator<Map> enemiesItemItr = enemiesItems.iterator();

						for (int i = 0; i < enemiesItemList.size(); i++) {
							JSONObject enemiesItem = (JSONObject) enemiesItemList.get(enemiesItemItr.next());

							Item item = this.getItemByUniqueName(enemiesItems.toArray()[i].toString());
							item.setCount(Integer.valueOf(enemiesItem.get("amount").toString()));
							enemyInv.add(item.clone());
						}

						npc.setInventory(enemyInv);

						break;
					case "Merchant":
						npc = new Merchant(label, innerEntity.get("prefix").toString(),
								innerEntity.get("biom").toString(), innerEntity.get("type").toString(),
								Integer.valueOf(innerEntity.get("size").toString()));

						break;
					default:
						npc = new NPC(label, innerEntity.get("prefix").toString(), innerEntity.get("biom").toString());
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

	public ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> out = new ArrayList<Enemy>();
		for (int i = 0; i < npcs.size(); i++) {
			if (npcs.get(i) instanceof Enemy) {
				out.add((Enemy) npcs.get(i));
			}
		}
		return out;
	}
}
