package model;

public class Profile {
	protected String choice = null;
	protected String name = null;
	protected int score = 0;
	protected Statistics stats = new Statistics();
	/*
	 * returns the choice in a string
	 */
	public String getChoice() {
		return choice;
	}
	public void reset() {
		score = 0;
	}
	public String getName() {
		return name;
	}
	public Statistics getStatistics() {
		return stats;
	}
	public void gameResult(String result) {
		if(result.equals("won")) {
			stats.won();
		}
		else if(result.equals("lost")) {
			stats.lost();
		}
	}
}