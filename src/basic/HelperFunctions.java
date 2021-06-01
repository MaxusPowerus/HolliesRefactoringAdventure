package basic;

public class HelperFunctions {

	public static String firstLetter2Upper(String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
	}

	public static String firstLetter2Lower(String word) {
		return word.substring(0, 1).toLowerCase() + word.substring(1, word.length());
	}

	public static String getResource(String path) {
		return HelperFunctions.class.getClassLoader().getResource(path).getFile();
	}

	public static int betragVon(int i) {
		if (i < 0) {
			return i * (-1);
		} else {
			return i;
		}

	}

}
