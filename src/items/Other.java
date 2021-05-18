package items;

public class Other extends Item {
	private String info;

	public Other(String uniqueName, String name, String info, int value) {
		super(uniqueName, name, value);
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}
