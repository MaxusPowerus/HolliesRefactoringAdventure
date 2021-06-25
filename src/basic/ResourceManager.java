package basic;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import entities.Enemy;
import entities.Merchant;
import entities.Victim;
import items.Food;
import items.Item;
import items.LootTable;
import items.Note;
import items.Other;
import items.Outfit;
import items.QuestItem;
import items.Weapon;
import utilities.Event;
import utilities.EventSolution;
import utilities.Inventory;
import utilities.Skill;

public class ResourceManager {

	private ArrayList<Food> food;
	private ArrayList<Note> notes;
	private ArrayList<Other> others;
	private ArrayList<Outfit> outfits;
	private ArrayList<QuestItem> questItems;
	private ArrayList<Weapon> weapons;

	private ArrayList<LootTable> lootTables;

	private ArrayList<Enemy> enemies;
	private ArrayList<Victim> victims;
	private ArrayList<Merchant> merchants;

	private ArrayList<Event> events;
	private ArrayList<EventSolution> eventSolutions;

	public ResourceManager() {
		this.food = new ArrayList<Food>();
		this.notes = new ArrayList<Note>();
		this.others = new ArrayList<Other>();
		this.outfits = new ArrayList<Outfit>();
		this.questItems = new ArrayList<QuestItem>();
		this.weapons = new ArrayList<Weapon>();

		lootTables = new ArrayList<LootTable>();

		this.enemies = new ArrayList<Enemy>();
		this.victims = new ArrayList<Victim>();
		this.merchants = new ArrayList<Merchant>();

		this.events = new ArrayList<Event>();

		this.eventSolutions = new ArrayList<EventSolution>();

		this.loadWeapons();
		this.loadOutfits();
		this.loadFood();
		this.loadNotes();
		this.loadOthers();
		this.loadQuestItems();

		this.loadLootTables();

		this.loadEnemies();
		this.loadVictims();
		this.loadMerchants();

		// this.loadEventSolutions();
		// this.loadEvents();
	}

	@SuppressWarnings("unchecked")
	private void loadWeapons() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/Weapons.json"));
			JSONParser parser = new JSONParser();

			JSONArray jsonItems = (JSONArray) parser.parse(fileReader);
			jsonItems.forEach((item) -> {
				JSONObject itemObj = (JSONObject) item;
				String label = new String(itemObj.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Weapon weapon = new Weapon(itemObj.get("uniqueName").toString(), label,
						Integer.valueOf(itemObj.get("damage").toString()),
						Integer.valueOf(itemObj.get("value").toString()),
						Integer.valueOf(itemObj.get("chance").toString()));
				this.weapons.add(weapon);
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadFood() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/Food.json"));
			JSONParser parser = new JSONParser();

			JSONArray jsonItems = (JSONArray) parser.parse(fileReader);
			jsonItems.forEach((item) -> {
				JSONObject itemObj = (JSONObject) item;
				String label = new String(itemObj.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Food food = new Food(itemObj.get("uniqueName").toString(), label,
						Integer.valueOf(itemObj.get("energy").toString()),
						Integer.valueOf(itemObj.get("value").toString()),
						Integer.valueOf(itemObj.get("chance").toString()));
				this.food.add(food);

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadOutfits() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/Outfits.json"));
			JSONParser parser = new JSONParser();

			JSONArray jsonItems = (JSONArray) parser.parse(fileReader);
			jsonItems.forEach((item) -> {
				JSONObject itemObj = (JSONObject) item;
				String label = new String(itemObj.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Outfit outfit = new Outfit(itemObj.get("uniqueName").toString(), label,
						Integer.valueOf(itemObj.get("value").toString()),
						Integer.valueOf(itemObj.get("armor").toString()),
						Integer.valueOf(itemObj.get("chance").toString()),
						Integer.valueOf(itemObj.get("st").toString()), Integer.valueOf(itemObj.get("pe").toString()),
						Integer.valueOf(itemObj.get("en").toString()), Integer.valueOf(itemObj.get("ch").toString()),
						Integer.valueOf(itemObj.get("in").toString()), Integer.valueOf(itemObj.get("ag").toString()),
						Integer.valueOf(itemObj.get("lk").toString()));
				this.outfits.add(outfit);

			});
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadNotes() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/Notes.json"));
			JSONParser parser = new JSONParser();

			JSONArray jsonItems = (JSONArray) parser.parse(fileReader);
			jsonItems.forEach((item) -> {
				JSONObject itemObj = (JSONObject) item;
				String label = new String(itemObj.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Note note = new Note(itemObj.get("uniqueName").toString(), label, itemObj.get("text").toString(),
						Integer.valueOf(itemObj.get("value").toString()),
						Integer.valueOf(itemObj.get("chance").toString()));
				this.notes.add(note);

			});

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadOthers() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/Others.json"));
			JSONParser parser = new JSONParser();

			JSONArray jsonItems = (JSONArray) parser.parse(fileReader);
			jsonItems.forEach((item) -> {
				JSONObject itemObj = (JSONObject) item;
				String label = new String(itemObj.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Other other = new Other(itemObj.get("uniqueName").toString(), label, itemObj.get("info").toString(),
						Integer.valueOf(itemObj.get("value").toString()),
						Integer.valueOf(itemObj.get("chance").toString()));
				this.others.add(other);

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadQuestItems() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/QuestItems.json"));
			JSONParser parser = new JSONParser();

			JSONArray jsonItems = (JSONArray) parser.parse(fileReader);
			jsonItems.forEach((item) -> {
				JSONObject itemObj = (JSONObject) item;
				String label = new String(itemObj.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				QuestItem questItem = new QuestItem(itemObj.get("uniqueName").toString(), label,
						itemObj.get("info").toString(), Integer.valueOf(itemObj.get("value").toString()),
						Integer.valueOf(itemObj.get("chance").toString()));
				this.questItems.add(questItem);

			});

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

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Items/LootTables.json"));
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

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Npc/Enemy.json"));
			JSONParser parser = new JSONParser();
			JSONObject jsonNPCs = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonNPCs.keySet();

			for (String keyName : labels) {
				JSONObject jsonNPC = (JSONObject) jsonNPCs.get(keyName);

				String label = new String(jsonNPC.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Enemy enemy = new Enemy(label, jsonNPC.get("prefix").toString(),
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

	private void loadVictims() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Npc/Victims.json"));
			JSONParser parser = new JSONParser();
			JSONObject jsonNPCs = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonNPCs.keySet();

			for (String keyName : labels) {
				JSONObject jsonNPC = (JSONObject) jsonNPCs.get(keyName);

				String label = new String(jsonNPC.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Victim victim = new Victim(label, jsonNPC.get("prefix").toString(),
						Double.valueOf(jsonNPC.get("health").toString()), Integer.valueOf(jsonNPC.get("st").toString()),
						Integer.valueOf(jsonNPC.get("pe").toString()), Integer.valueOf(jsonNPC.get("en").toString()),
						Integer.valueOf(jsonNPC.get("ch").toString()), Integer.valueOf(jsonNPC.get("in").toString()),
						Integer.valueOf(jsonNPC.get("ag").toString()), Integer.valueOf(jsonNPC.get("lk").toString()),
						jsonNPC.get("biom").toString(), Integer.valueOf(jsonNPC.get("xp").toString()));

				Inventory victimInv = new Inventory();

				String lootTable = jsonNPC.get("lootTable").toString();
				LootTable table = this.getLootTableByName(lootTable);
				victimInv.add(table.getItems(), table.getGold());

				victim.setInventory(victimInv);

				this.victims.add(victim);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void loadMerchants() {
		try {

			FileReader fileReader = new FileReader(HelperFunctions.getResource("jsonFiles/Npc/Merchant.json"));
			JSONParser parser = new JSONParser();
			JSONObject jsonNPCs = (JSONObject) parser.parse(fileReader);

			Set<String> labels = jsonNPCs.keySet();

			for (String keyName : labels) {
				JSONObject jsonNPC = (JSONObject) jsonNPCs.get(keyName);

				String label = new String(jsonNPC.get("label").toString().getBytes(), StandardCharsets.UTF_8);

				Merchant merchant = new Merchant(label, jsonNPC.get("prefix").toString(),
						jsonNPC.get("biom").toString(), jsonNPC.get("type").toString(),
						Integer.valueOf(jsonNPC.get("size").toString()));

				Inventory merchantInv = new Inventory();

				String lootTable = jsonNPC.get("type").toString();
				LootTable table = this.getLootTableByName(lootTable);
				merchantInv.add(table.getItems(), table.getGold());

				merchant.setInventory(merchantInv);
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

	public ArrayList<Victim> getVictims() {
		return this.victims;
	}

	public LootTable getLootTableByName(String name) {
		for (LootTable table : this.lootTables) {
			if (table.getName().equalsIgnoreCase(name))
				return table;
		}
		return null;
	}

	/*
	 * @SuppressWarnings("unchecked") private void loadEventSolutions() { try {
	 * 
	 * FileReader fileReader = new
	 * FileReader(HelperFunctions.getResource("jsonFiles/EventSolutions.json"));
	 * JSONParser parser = new JSONParser(); JSONObject jsonItems = (JSONObject)
	 * parser.parse(fileReader);
	 * 
	 * Set<String> labels = jsonItems.keySet();
	 * 
	 * for (String keyName : labels) { JSONObject jsonItem = (JSONObject)
	 * jsonItems.get(keyName);
	 * 
	 * ArrayList<Item> requiredItems = new ArrayList<Item>(); ((JSONArray)
	 * jsonItem.get("requiredItems")).forEach((item) -> {
	 * requiredItems.add(this.getItemByUniqueName(item.toString()).clone()); });
	 * 
	 * ArrayList<Item> rewardItems = new ArrayList<Item>(); ((JSONArray)
	 * jsonItem.get("rewardItems")).forEach((item) -> {
	 * rewardItems.add(this.getItemByUniqueName(item.toString()).clone()); });
	 * 
	 * String solutionShort = new
	 * String(jsonItem.get("solutionTry").toString().getBytes(),
	 * StandardCharsets.UTF_8); String solutionTry = new
	 * String(jsonItem.get("solutionShort").toString().getBytes(),
	 * StandardCharsets.UTF_8); String success = new
	 * String(jsonItem.get("success").toString().getBytes(),
	 * StandardCharsets.UTF_8); String failure = new
	 * String(jsonItem.get("failure").toString().getBytes(),
	 * StandardCharsets.UTF_8);
	 * 
	 * EventSolution eventSolution = new EventSolution(keyName, solutionShort,
	 * solutionTry, success, failure,
	 * getSkillByString(jsonItem.get("skill").toString()),
	 * Integer.valueOf(jsonItem.get("skillValue").toString()), requiredItems,
	 * getBoolByString(jsonItem.get("needOnlyOneItem").toString()),
	 * getBoolByString(jsonItem.get("needItemPermanet").toString()),
	 * Integer.valueOf(jsonItem.get("rewardXp").toString()), rewardItems,
	 * Integer.valueOf(jsonItem.get("rewardGold").toString()),
	 * Integer.valueOf(jsonItem.get("takeDamage").toString()));
	 * 
	 * this.eventSolutions.add(eventSolution); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * public EventSolution getEventSolutionByName(String name) { for (EventSolution
	 * eventSolution : this.eventSolutions) { if
	 * (eventSolution.getName().equalsIgnoreCase(name)) return eventSolution; }
	 * return null; }
	 * 
	 * public ArrayList<EventSolution> getEventSolutions() { return eventSolutions;
	 * }
	 */
	/*
	 * @SuppressWarnings("unchecked") private void loadEvents() { try {
	 * 
	 * FileReader fileReader = new
	 * FileReader(HelperFunctions.getResource("jsonFiles/Events.json")); JSONParser
	 * parser = new JSONParser(); JSONObject jsonItems = (JSONObject)
	 * parser.parse(fileReader);
	 * 
	 * Set<String> labels = jsonItems.keySet();
	 * 
	 * for (String keyName : labels) { JSONObject jsonItem = (JSONObject)
	 * jsonItems.get(keyName);
	 * 
	 * ArrayList<EventSolution> solutions = new ArrayList<EventSolution>();
	 * 
	 * JSONArray solutionArray = (JSONArray) jsonItem.get("solutions");
	 * 
	 * solutionArray.forEach((solution) -> {
	 * solutions.add(this.getEventSolutionByName(solution.toString())); });
	 * 
	 * String task = new String(jsonItem.get("task").toString().getBytes(),
	 * StandardCharsets.UTF_8); String biom = new
	 * String(jsonItem.get("biom").toString().getBytes(), StandardCharsets.UTF_8);
	 * 
	 * Event event = new Event(keyName, task, solutions, biom);
	 * 
	 * this.events.add(event); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * public Event getEventByName(String name) { for (Event event : this.events) {
	 * if (event.getName().equalsIgnoreCase(name)) return event; } return null; }
	 * 
	 * public ArrayList<Event> getEvents() { return events; }
	 */
	public Skill getSkillByString(String string) {
		if (string.equalsIgnoreCase("st")) {
			return Skill.STRENGTH;
		}
		if (string.equalsIgnoreCase("pe")) {
			return Skill.PERCEPTION;
		}
		if (string.equalsIgnoreCase("en")) {
			return Skill.ENDURANCE;
		}
		if (string.equalsIgnoreCase("ch")) {
			return Skill.CHARISMA;
		}
		if (string.equalsIgnoreCase("in")) {
			return Skill.INTELLIGENCE;
		}
		if (string.equalsIgnoreCase("ag")) {
			return Skill.AGILITY;
		}
		if (string.equalsIgnoreCase("lk")) {
			return Skill.LUCK;
		}
		return null;
	}

	public boolean getBoolByString(String string) {
		if (string.equalsIgnoreCase("true")) {
			return true;
		}
		if (string.equalsIgnoreCase("false")) {
			return false;
		}

		return (Boolean) null;
	}

}
