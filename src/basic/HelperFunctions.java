package basic;

public class HelperFunctions {

	public static String firstLetter2Upper(String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
	}

	public static String firstLetter2Lower(String word) {
		return word.substring(0, 1).toLowerCase() + word.substring(1, word.length());
	}

}
