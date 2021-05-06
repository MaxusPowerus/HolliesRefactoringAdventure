package basic;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import items.Item;

public class ResourceManager {

	private ArrayList<Item> items;

	public ResourceManager() {
		items = new ArrayList<Item>();
		loadItems();
	}

	private void loadItems() {
		try {
			FileReader fileReader = new FileReader(
					"D:\\Users\\Rechenknecht\\Desktop\\Eclipse Workspace\\Holly\\Hollies Adventure\\resources\\items.json");
			JSONParser parser = new JSONParser();

			JSONObject items = (JSONObject) parser.parse(fileReader);
			items = (JSONObject) items.get("Categories");
			Set<Map> set = items.keySet();
			Iterator<Map> itr = set.iterator();
			while (itr.hasNext()) {
				JSONObject category = (JSONObject) items.get(itr.next());
				Set<Map> categoryItem = category.keySet();
				Iterator<Map> itemItr = categoryItem.iterator();
				while (itemItr.hasNext()) {
					JSONObject i = (JSONObject) category.get(itemItr.next());
					Item item = new Item();

				}

				System.out.println(itr.next());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
