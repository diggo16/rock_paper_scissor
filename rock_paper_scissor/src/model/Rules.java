package model;

public class Rules {
	
	
	public int Winner(String option1, String option2) {
		if(option1.equals(option2)) {
			return 0;
		}
		else {
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
		}
		return -1;
	}
	public void setBestOf(int nr) throws IllegalArgumentException{
		bestOf = nr;
	}
	public int getBestOf() {
		
	}
		
}
