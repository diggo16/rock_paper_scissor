package view;

import java.util.Scanner;

public class Console {
	private Scanner input;
	
	public Console() {
		input = new Scanner(System.in);
	}
	
	public String askForInputOption() {
		System.out.println("What do you want to choose? (rock, paper or scissor)");
		
		String answer = "";
		if(input.hasNext()) {
			answer = input.next();
		}
		return answer;
	}
	public void closeScanner() {
		input.close();
	}
}
