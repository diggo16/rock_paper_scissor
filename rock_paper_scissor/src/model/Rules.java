package model;

public class Rules {
	
	private int bestOf;
	
	public Rules() {
		bestOf = 1;
	}
	/*
	 * return 0 if it is a tie, 1 if "option1" won or 2 if "option2" won.
	 */
	public int Winner(String option1, String option2) {
			if(option1.equals("rock")) {
				if(option2.equals("paper")) {
					return 2;
				}
				if(option2.equals("scissor")) {
					return 1;
				}
			}
			if(option1.equals("paper")) {
				if(option2.equals("scissor")) {
					return 2;
				}
				if(option2.equals("rock")) {
					return 1;
				}
			}
			if(option1.equals("scissor")) {
				if(option2.equals("rock")) {
					return 2;
				}
				if(option2.equals("paper")) {
					return 1;
				}
			}
		return 0;
	}
	public void setBestOf(int nr) throws IllegalArgumentException{
		bestOf = nr;
	}
	public int getBestOf() {
		return bestOf;
	}
		
}
