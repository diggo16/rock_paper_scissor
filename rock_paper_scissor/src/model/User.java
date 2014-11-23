package model;

public class User extends Profile {
	public User(String name) {
		this.name = name;
	}
	/*
	 * set the choice to the string in the parameter
	 */
	public void setChoice(String choice) {
		if( checkIfValid(choice)== true) {
			this.choice = choice;
		}
		else {
			choice = null;
		}	
	}
	/*
	 * check if the string is a valid option (rock, paper, scissor)
	 */
	private boolean checkIfValid(String option) {
		String[] options = {"rock","paper","scissor"};
		for(int i = 0; i < options.length; i++) {
			if(option.equals(options[i]) == true) {
				return true;
			}
		}
		return false;
	}
	public void win() {
		
	}
	public int getScore() {
		return 0;
	}

}
