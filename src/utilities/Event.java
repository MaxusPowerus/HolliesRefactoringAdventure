package utilities;

import java.util.ArrayList;

import map.Biom;

public class Event {

	private String name;
	private String task;
	private ArrayList<EventSolution> solutions;
	private Biom biom;

	public Event(String name, String task, ArrayList<EventSolution> solutions, String biom) {
		this.name = name;
		this.task = task;
		this.solutions = solutions;

		switch (biom) {
		case "all":
			this.biom = null;
			break;

		case "meadow":
			this.biom = Biom.MEADOW;
			break;

		case "forest":
			this.biom = Biom.FOREST;
			break;

		case "desert":
			this.biom = Biom.DESERT;
			break;

		case "swamp":
			this.biom = Biom.SWAMP;
			break;

		case "mountains":
			this.biom = Biom.MOUNTAINS;
			break;
		}

	}

	public String getName() {
		return name;
	}

	public String getTask() {
		return task;
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

	public Biom getBiom() {
		return biom;
	}
}
