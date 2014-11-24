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
	
	public PlayGame(User user, Bot bot, Console console) {
		this.user = user;
		this.console = console;
		this.bot = bot;
		rules = new Rules();
	}
	public void meny() {
		int menyChoice;
		do {
			menyChoice = console.meny();
			
			if(menyChoice == 0) {
				break;
			}
		
			if(menyChoice == 1) {
				newGame();
			}
			if(menyChoice == 2) {
				settings();
			}
		}while(menyChoice != 3);
		console.closeScanner();
		
	}
	public void settings() {
		int bestOf = console.askForRounds();
		rules.setBestOf(bestOf);
	}
	/*
	 * creates a new game
	 */
	public void newGame() {
		int bestOf = rules.getBestOf();
		int maxPoints = (bestOf/2)+1;
		for(int i = 0; i < bestOf; i++) {
			getUserOption();
			bot.setChoice();
			if(countWinner() != true) {
				i--;
			}
			console.presentProfileOption(user.getClass().getSimpleName(), user.getChoice());
			console.presentProfileOption(bot.getClass().getSimpleName(), bot.getChoice());
			
			if(user.getScore() == maxPoints || bot.getScore() == maxPoints) {
				break;
			}
		}
		winner();
	}
	private boolean countWinner() {
		int winnerInt = rules.Winner(user.getChoice(), bot.getChoice());
		if(winnerInt == 1) {
			user.win();
		}
		if (winnerInt == 2) {
			bot.win();
		}
		if(winnerInt == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public void winner() {
		String winner = winnerName();
		console.showWinner(winner);
	}
	private String winnerName() {
		int userScore = user.getScore();
		int botScore = bot.getScore();
		if(userScore == botScore) {
			return null;
		}
		if(userScore > botScore) {
			return user.getName();
		}
		return bot.getName();
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
	/*
	 * ask the console for the user's choice
	 */
	private void getUserOption() {
		String userChoice = console.askForInputOption();
		user.setChoice(userChoice);
	}
}
