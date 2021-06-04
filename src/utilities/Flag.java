package utilities;

public class Flag {
	private boolean value;
	private String name;

	public Flag(String name) {
		this.name = name;
		this.value = false;
	}

	public Flag(String name, boolean flag) {
		this.name = name;
		this.value = value;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
