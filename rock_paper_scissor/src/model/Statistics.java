package model;

public class Statistics {

	private int wins, losses;
	public Statistics() {
		wins = 0;
		losses = 0;
	}
	
	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}
	public void won() {
		wins++;
	}
	public void lost() {
		losses++;
	}
}
