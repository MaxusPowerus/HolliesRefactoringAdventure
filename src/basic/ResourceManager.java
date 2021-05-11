package basic;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import items.Food;
import items.Item;
import items.Outfit;
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
						item = new Weapon(innerItem.get("label").toString(), (int) innerItem.get("value"),
								(int) innerItem.get("damage"));
						break;
					case "Outfits":
						item = new Outfit(innerItem.get("label").toString(), (int) innerItem.get("value"),
								(int) innerItem.get("armor"));
						break;
					case "Food":
						item = new Food(innerItem.get("label").toString(), (int) innerItem.get("value"),
								(int) innerItem.get("energy"));
						break;
					default:
						item = new Item(innerItem.get("label").toString(), (int) innerItem.get("value")); // TODO
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

	public Item getItem(String name) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				return items.get(i);
			}
		}
		return null;
	}
}
