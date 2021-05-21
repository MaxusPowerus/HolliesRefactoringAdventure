package basic;

public class Main {

	public static void main(String[] args) {
		GameManager manager = new GameManager();

		if (args.length == 1 && args[0] == "exit_after_time") {
			setTimeout(() -> {
				System.exit(0);
			}, 1000 * 3);
		}
	}

	public static void setTimeout(Runnable runnable, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}

}
