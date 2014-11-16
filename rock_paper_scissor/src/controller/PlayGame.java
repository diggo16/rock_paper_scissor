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
		console = new Console();
		rules = new Rules();
	}
	
	
	public void newGame() {
		getUserOption();
		bot.setChoice();
		console.closeScanner();
	}
	private void getUserOption() {
		String userChoice = console.askForInputOption();
		user.setChoice(userChoice);	
	}
	/*
	 * 
	 */
	public boolean showWinner() {
		if(user.getChoice() != null && bot.getChoice() != null) {
			String winner = "";
			int winnerInt = rules.Winner(user.getChoice(), bot.getChoice());
			if(winnerInt != -1) {
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
