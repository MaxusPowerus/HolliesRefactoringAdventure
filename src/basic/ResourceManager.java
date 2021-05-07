package basic;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import items.Item;
import items.Weapon;

public class ResourceManager {

	private ArrayList<Item> items;

	public ResourceManager() {
		this.items = new ArrayList<Item>();
		this.loadItems();
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

				while (itemItr.hasNext()) {
					JSONObject innerItem = (JSONObject) category.get(itemItr.next());
					Item item = null;

					switch (key.toString()) {
					case "Weapons":
						System.out.println("Weapon: " + innerItem.get("label"));
						item = new Weapon(); // TODO
						break;
					case "Food":
						System.out.println("Food: " + innerItem.get("label"));
						// item = new Food(); // TODO
						break;
					default:
						System.out.println("Default item (no category): " + innerItem.get("label"));
						item = new Item(); // TODO
						break;
					}

					this.items.add(item);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
