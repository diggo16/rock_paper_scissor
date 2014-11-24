package model;

public class Profile {
	protected String choice = null;
	protected String name = null;
	protected int score = 0;
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
}