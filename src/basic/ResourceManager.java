package basic;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entities.Enemy;
import entities.Merchant;
import items.Food;
import items.Item;
import items.LootTable;
import items.Note;
import items.Other;
import items.Outfit;
import items.QuestItem;
import items.Weapon;
import utilities.Inventory;

public class ResourceManager {

	private ArrayList<Food> food;
	private ArrayList<Note> notes;
	private ArrayList<Other> others;
	private ArrayList<Outfit> outfits;
	private ArrayList<QuestItem> questItems;
	private ArrayList<Weapon> weapons;

	private ArrayList<LootTable> lootTables;

	private ArrayList<Enemy> enemies;
	private ArrayList<Merchant> merchants;

	public ResourceManager() {
		this.food = new ArrayList<Food>();
		this.notes = new ArrayList<Note>();
		this.others = new ArrayList<Other>();
		this.outfits = new ArrayList<Outfit>();
		this.questItems = new ArrayList<QuestItem>();
		this.weapons = new ArrayList<Weapon>();

		lootTables = new ArrayList<LootTable>();

		this.enemies = new ArrayList<Enemy>();
		this.merchants = new ArrayList<Merchant>();

		this.loadWeapons();
		this.loadOutfits();
		this.loadFood();
		this.loadNotes();
		this.loadOthers();
		this.loadQuestItems();

		// this.loadLootTables();

		this.loadEnemies();
		this.loadMerchants();
	}

	@SuppressWarnings("unchecked")
	private void loadWeapons() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\Weapons.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String keyName : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(keyName);

				Weapon item = new Weapon(keyName, jsonItem.get("label").toString(),
						Integer.valueOf(jsonItem.get("damage").toString()),
						Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()));

				this.weapons.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadFood() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\Food.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String keyName : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(keyName);

				Food item = new Food(keyName, jsonItem.get("label").toString(),
						Integer.valueOf(jsonItem.get("energy").toString()),
						Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()));

				this.food.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadOutfits() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\Outfits.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String keyName : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(keyName);

				Outfit item = new Outfit(keyName, jsonItem.get("label").toString(),
						Integer.valueOf(jsonItem.get("armor").toString()),
						Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()),
						Integer.valueOf(jsonItem.get("st").toString()), Integer.valueOf(jsonItem.get("pe").toString()),
						Integer.valueOf(jsonItem.get("en").toString()), Integer.valueOf(jsonItem.get("ch").toString()),
						Integer.valueOf(jsonItem.get("in").toString()), Integer.valueOf(jsonItem.get("ag").toString()),
						Integer.valueOf(jsonItem.get("lk").toString()));

				this.outfits.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadNotes() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\Notes.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String keyName : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(keyName);

				Note item = new Note(keyName, jsonItem.get("label").toString(), jsonItem.get("text").toString(),
						Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()));

				this.notes.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadOthers() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\Others.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String keyName : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(keyName);

				Other item = new Other(keyName, jsonItem.get("label").toString(), jsonItem.get("info").toString(),
						Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()));

				this.others.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadQuestItems() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\QuestItems.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonItems = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonItems.keySet();

			for (String keyName : labels) {
				JSONObject jsonItem = (JSONObject) jsonItems.get(keyName);

				QuestItem item = new QuestItem(keyName, jsonItem.get("label").toString(),
						jsonItem.get("info").toString(), Integer.valueOf(jsonItem.get("value").toString()),
						Integer.valueOf(jsonItem.get("chance").toString()));

				this.questItems.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Item> getAllItems() {
		ArrayList<Item> cloned = new ArrayList<Item>();

		for (Item item : this.food) {
			cloned.add(item.clone());
		}
		for (Item item : this.notes) {
			cloned.add(item.clone());
		}
		for (Item item : this.others) {
			cloned.add(item.clone());
		}
		for (Item item : this.outfits) {
			cloned.add(item.clone());
		}
		for (Item item : this.questItems) {
			cloned.add(item.clone());
		}
		for (Item item : this.weapons) {
			cloned.add(item.clone());
		}

		return cloned;
	}

	public ArrayList<Weapon> getWeapons() {
		return this.weapons;
	}

	public ArrayList<Outfit> getOutfits() {
		return this.outfits;
	}

	public ArrayList<Food> getFood() {
		return this.food;
	}

	public ArrayList<Note> getNotes() {
		return this.notes;
	}

	public ArrayList<Other> getOthers() {
		return this.others;
	}

	public Item getItemByUniqueName(String uniqueName) {

		for (Item item : this.food) {
			if (item.getUniqueName().equalsIgnoreCase(uniqueName))
				return item;
		}
		for (Item item : this.notes) {
			if (item.getUniqueName().equalsIgnoreCase(uniqueName))
				return item;
		}
		for (Item item : this.others) {
			if (item.getUniqueName().equalsIgnoreCase(uniqueName))
				return item;
		}
		for (Item item : this.outfits) {
			if (item.getUniqueName().equalsIgnoreCase(uniqueName))
				return item;
		}
		for (Item item : this.questItems) {
			if (item.getUniqueName().equalsIgnoreCase(uniqueName))
				return item;
		}
		for (Item item : this.weapons) {
			if (item.getUniqueName().equalsIgnoreCase(uniqueName))
				return item;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private void loadLootTables() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Items\\LootTables.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonNPCs = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonNPCs.keySet();

			for (String keyName : labels) {
				JSONObject jsonNPC = (JSONObject) jsonNPCs.get(keyName);

				ArrayList<Item> items = new ArrayList<Item>();

				JSONArray itemList = (JSONArray) jsonNPC.get("items");

				itemList.forEach((itemName) -> {
					Item item = this.getItemByUniqueName(itemName.toString()).clone();
					items.add(item);
				});

				LootTable lootTable = new LootTable(keyName, items, Integer.valueOf(jsonNPC.get("gold").toString()));

				this.lootTables.add(lootTable);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LootTable> getLootTables() {
		return this.lootTables;
	}

	@SuppressWarnings("unchecked")
	private void loadEnemies() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Npc\\Enemy.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonNPCs = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonNPCs.keySet();

			for (String keyName : labels) {
				JSONObject jsonNPC = (JSONObject) jsonNPCs.get(keyName);

				Enemy enemy = new Enemy(jsonNPC.get("label").toString(), jsonNPC.get("prefix").toString(),
						Double.valueOf(jsonNPC.get("damage").toString()),
						Double.valueOf(jsonNPC.get("health").toString()), Integer.valueOf(jsonNPC.get("st").toString()),
						Integer.valueOf(jsonNPC.get("pe").toString()), Integer.valueOf(jsonNPC.get("en").toString()),
						Integer.valueOf(jsonNPC.get("ch").toString()), Integer.valueOf(jsonNPC.get("in").toString()),
						Integer.valueOf(jsonNPC.get("ag").toString()), Integer.valueOf(jsonNPC.get("lk").toString()),
						jsonNPC.get("biom").toString(), Integer.valueOf(jsonNPC.get("xp").toString()));

				Inventory enemyInv = new Inventory();

				String lootTable = jsonNPC.get("lootTable").toString();
				LootTable table = this.getLootTableByName(lootTable);
				enemyInv.add(table.getItems(), table.getGold());

				enemy.setInventory(enemyInv);

				this.enemies.add(enemy);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadMerchants() {
		try {

			FileReader fileReader = new FileReader("resources\\jsonFiles\\Npc\\Merchant.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonNPCs = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonNPCs.keySet();

			for (String keyName : labels) {
				JSONObject jsonNPC = (JSONObject) jsonNPCs.get(keyName);

				Merchant merchant = new Merchant(jsonNPC.get("label").toString(), jsonNPC.get("prefix").toString(),
						jsonNPC.get("biom").toString(), jsonNPC.get("type").toString(),
						Integer.valueOf(jsonNPC.get("size").toString()));

				this.merchants.add(merchant);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Merchant> getMerchants() {
		return this.merchants;
	}

	public ArrayList<Enemy> getEnemies() {
		return this.enemies;
	}

	public LootTable getLootTableByName(String name) {
		for (LootTable table : this.lootTables) {
			if (table.getName().equalsIgnoreCase(name))
				return table;
		}
		return null;
	}

}
