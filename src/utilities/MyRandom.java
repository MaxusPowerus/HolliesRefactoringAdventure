package utilities;

import java.util.Random;

public class MyRandom {
	public MyRandom() {

	}

	public static int pickRandom(int[] chances) {
		int sumOfChances = 0;

		for (int i = 0; i < chances.length; i++) {
			sumOfChances += chances[i];
			chances[i] = sumOfChances;
		}

		Random Randy = new Random();
		int littleRandy = Randy.nextInt(sumOfChances);
		for (int i = 0; i < chances.length; i++) {
			int prev = 0;
			if (i == 0) {
				prev = -1;
			} else {
				prev = chances[i - 1];
			}

			if (littleRandy > prev && littleRandy <= chances[i]) {
				return i;
			}
		}
		return -1;
	}
}
