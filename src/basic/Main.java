package basic;

public class Main {

	public static void main(String[] args) {
		boolean fullscreen = false;

		if (args.length > 0 && args[0].equalsIgnoreCase("exit_after_time")) {
			setTimeout(() -> {
				System.exit(0);
			}, 1000 * 120);
		} else if (args.length > 0 && args[0].equalsIgnoreCase("fullscreen")) {
			fullscreen = true;
		}

		GameManager manager = new GameManager(fullscreen);
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
