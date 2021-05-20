package utilities;

import java.util.ArrayList;

import items.Item;

public class Event {

	private String task;
	private ArrayList<EventSolution> solutions;

	public Event() {

	}

	public Event(String task, ArrayList<EventSolution> solutions) {
		this.task = task;
		solutions = solutions;
	}

	public ArrayList<Item> getItemsFromStringArrayForArrayList(String[] stringArray) {
		ArrayList<Item> arrayList = new ArrayList<Item>();
		return arrayList;
	}
}
