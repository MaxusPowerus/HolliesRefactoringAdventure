package basic;

public class HelperFunctions {

	public static String firstLetter2Upper(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
	}

}
