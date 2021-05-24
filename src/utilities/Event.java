package utilities;

import java.util.ArrayList;

import items.Item;

public class Event {

	private String name;

	private String task;
	private ArrayList<EventSolution> solutions;

	public Event(String name, String task, ArrayList<EventSolution> solutions) {
		this.name = name;
		this.task = task;
		this.solutions = solutions;
	}

	public ArrayList<Item> getItemsFromStringArrayForArrayList(String[] stringArray) {
		ArrayList<Item> arrayList = new ArrayList<Item>();
		return arrayList;
	}

	public String getName() {
		return name;
	}

	public void printParameter() {
		System.out.println("Task: " + task);
		for (int i = 0; i < solutions.size(); i++) {
			System.out.println("Solutions " + i + ":" + solutions.get(i).getName());
		}
	}

	public ArrayList<EventSolution> getEventSolutions() {
		return solutions;
	}
}
