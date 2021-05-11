package items;

public class Item {

	private String name;
	private int value;
	private int count;

	public Item(String name, int value) {
		this.name = name;
		this.value = value;
		this.count = 1;
	}

	public String getName() {
		return name;
	}

	public void incrementCount() {
		count++;
	}

	public boolean decrementCount() {
		count--;
		if (count >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean equals(Item item) {
		if (this.name.equals(item.getName())) {
			return true;
		} else {
			return false;
		}

	}
}
