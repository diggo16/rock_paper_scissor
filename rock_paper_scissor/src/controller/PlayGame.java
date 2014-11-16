package controller;

import view.Console;
import model.Bot;
import model.Rules;
import model.User;

public class PlayGame {
	
	private User user;
	private Bot bot;
	private Console console;
	private Rules rules;
	
	public PlayGame(User user) {
		this.user = user;
		bot = new Bot();
		rules = new Rules();
	}
	/*
	 * creates a new game
	 */
	public void newGame() {
		console = new Console();
		getUserOption();
		bot.setChoice();
		console.closeScanner();
	}
	/*
	 * ask the console for the user's choice
	 */
	private void getUserOption() {
		String userChoice = console.askForInputOption();
		user.setChoice(userChoice);	
	}
	/*
	 * let the console print the winner or tell that it is a tie
	 */
	public boolean showWinner() {
		if(user.getChoice() != null && bot.getChoice() != null) {
			int winnerInt = rules.Winner(user.getChoice(), bot.getChoice());
			if(winnerInt != -1) {
				String winner = "";
				if(winnerInt == 1) {
					winner = user.getClass().getSimpleName();
				}
				if(winnerInt == 2) {
					winner = bot.getClass().getSimpleName();
				}
				console.showWinner(winner);
				return true;
			}
		}
		return false;
	}

}
