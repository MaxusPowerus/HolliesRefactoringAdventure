package utilities;

import java.util.ArrayList;

public class Event {

	private String name;

	private String task;
	private ArrayList<EventSolution> solutions;

	public Event(String name, String task, ArrayList<EventSolution> solutions) {
		this.name = name;
		this.task = task;
		this.solutions = solutions;
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
}
