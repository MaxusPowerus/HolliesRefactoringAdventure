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

	public Item clone() {
		Item item = null;
		if (this instanceof Weapon) {
			item = new Weapon(this.uniqueName, this.name, this.value, ((Weapon) this).getDamage());
		} else if (this instanceof Food) {
			item = new Weapon(this.uniqueName, this.name, this.value, ((Food) this).getEnergy());
		} else if (this instanceof Outfit) {
			item = new Weapon(this.uniqueName, this.name, this.value, ((Outfit) this).getArmor());
		} else {
			item = new Item(this.uniqueName, this.name, this.value);
		}
		item.setCount(this.count);
		item.setDiscount(this.discount);
		return item;
	}
}
