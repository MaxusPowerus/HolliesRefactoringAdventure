package utilities;

public class Container {

	private String name;
	private Inventory inventory;

	public Container(String name) {
		this.name = name;
		inventory = new Inventory();
	}

}
