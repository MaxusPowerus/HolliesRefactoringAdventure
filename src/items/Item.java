package items;

import entities.Player;
import utilities.Skill;

public class Item {

	private String uniqueName;
	private String name;
	private int value;
	private int spawnChance;
	private int count;
	private double discount;

	public Item(String uniqueName, String name, int value, int spawnChance) {
		this.uniqueName = uniqueName;
		this.name = name;
		this.value = value;
		this.count = 1;
		this.spawnChance = spawnChance;
	}

	public String getName() {
		return name;
	}

	public void incrementCount() {
		count++;
	}

	public void decrementCount() {
		if (count > 0)
			count--;
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

	public int getSpawnChance() {
		return spawnChance;
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

	public int getValue() {
		return value;
	}

	public int getSpecificBuyValue(Player player) {
		double fac = 0.2;
		double specificValue = this.value;
		double ch = player.getSkillSet().getSkillValue(Skill.CHARISMA);

		return (int) ((10 - ch) * fac * specificValue + 1);
	}

	public int getSpecificSellValue(Player player) {
		double fac = 0.17;
		double specificValue = this.value;
		double ch = player.getSkillSet().getSkillValue(Skill.CHARISMA);

		return (int) (fac * ch * specificValue + 1);
	}

	public Item clone() {
		Item item = null;
		if (this instanceof Weapon) {
			item = new Weapon(this.uniqueName, this.name, this.value, ((Weapon) this).getDamage(),
					this.getSpawnChance());
		} else if (this instanceof Food) {
			item = new Food(this.uniqueName, this.name, this.value, ((Food) this).getEnergy(), this.getSpawnChance());
		} else if (this instanceof Outfit) {
			item = new Outfit(this.uniqueName, this.name, this.value, ((Outfit) this).getArmor(), this.getSpawnChance(),
					((Outfit) this).getOutfitFx());
		} else {
			item = new Item(this.uniqueName, this.name, this.value, this.getSpawnChance());
		}
		item.setCount(this.count);
		item.setDiscount(this.discount);
		return item;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
