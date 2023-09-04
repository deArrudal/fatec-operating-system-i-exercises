package view;

import controller.ThreadLane;

public class FrogRace {
	public static void main(String[] args) throws InterruptedException {
		int numFrog = 5; // number of frogs.
		double distance = 10.0; // race distance [m].
		double maxJump = 1.0; // frog's maximum jump [m].

		for (int i = 0; i < numFrog; i++) {
			Thread threads = new ThreadLane(i + 1, distance, maxJump);
			threads.start();
		}
	}
}