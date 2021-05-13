package items;

public class Item {

	private String uniqueName;
	private String name;
	private int value;
	private int count;
	private double discount;

	public Item(String uniqueName, String name, int value) {
		this.uniqueName = uniqueName;
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

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Item))
			return false;

		Item item = (Item) object;

		return this.uniqueName == item.uniqueName;
	}

	public int getCount() {
		return count;
	}

	public double getDiscount() {
		return discount;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
