package model;

import java.util.Random;

public class Bot {
	private String choice;
	
	public void setChoice() {
		choice = generateChoice();
	}
	public String getChoice() {
		return choice;
	}
	/*
	 * generate an option
	 */
	private String generateChoice() {
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		String option = "";
		if(randomNumber == 0) {
			option = "rock";
		}
		if(randomNumber == 1) {
			option = "paper";
		}
		if(randomNumber == 2) {
			option = "scissor";
		}
		return option;
	}
}
