package view;

import java.util.Scanner;

public class Console {
	private Scanner input;
	
	public Console() {
		input = new Scanner(System.in);
	}
	/*
	 * Ask for input option (rock,paper,scissor)
	 */
	public String askForInputOption() {
		System.out.println("What do you want to choose? (rock, paper or scissor)");
		
		String answer = "";
		if(input.hasNext()) {
			answer = input.next();
		}
		return answer;
	}
	/*
	 * close the scanner
	 */
	public void closeScanner() {
		input.close();
	}
	/*
	 * show the winner
	 */
	public void showWinner(String winner) {
		if(winner != null) {
		System.out.println(winner+" won!");
		}
		else {
			System.out.println("Tie!");
		}
	}
	/*
	 * ask for amounts of rounds
	 */
	public int askForRounds() {
		System.out.println("How many \"best of\" rounds do you want to play? (Must be an odd number)");
		int answer = 0;
		do {
		if(input.hasNext()) {
			String temp = input.next();
			try { 
			        answer = Integer.parseInt(temp); 
			    } catch(NumberFormatException e) {
			    	System.out.println("You must insert an odd number!");
			    }
			}
			if(answer <= 0 || answer % 2 == 0) {
				answer = 0;
			}
		if(answer == 0) {
			System.out.println("You must insert an odd number higher than 0!");
		}
		}while(answer == 0);
		return answer;
	}
	/*
	 * present the option that the Profile profileName has chose
	 */
	public void presentProfileOption(String profileName, String option) {
		System.out.println(profileName+" got "+option);
	}
	/*
	 * present the meny and ask for number of the choice
	 */
	public int meny() {
		System.out.println("Meny:\n"
						 + "1. New game\n"
						 + "2. Settings\n"
						 + "3. Statistics\n"
						 + "4. Load\n"
						 + "5. Save\n"
						 + "6. Quit");
		int answer = 0;
		do {
		if(input.hasNext()) {
			String temp = input.next();
			try { 
			        answer = Integer.parseInt(temp); 
			    } catch(NumberFormatException e) {
			    	System.out.println("You must insert a number!");
			    }
			}
			if(answer < 1 || answer >6) {
				answer = 0;
			}
		if(answer == 0) {
			System.out.println("You must insert one of the numbers of the options! (1-6)");
		}
		}while(answer == 0);
		return answer;
	}
	public void presentScore(String userName, int userScore, String botName, int botScore) {
		System.out.println(userName+":"+userScore+", "+botName+":"+botScore);
	}
	public void presentStatistics(int wins, int losses) {
		System.out.println("Wins:"+wins+", Losses:"+losses);
	}
	public void fileNotFound() {
		System.out.println("File not found!");
	}
}
