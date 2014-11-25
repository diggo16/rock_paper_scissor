package controller;

import java.io.FileNotFoundException;

import view.Console;
import model.Bot;
import model.Information;
import model.Rules;
import model.Statistics;
import model.User;

public class PlayGame {
	
	private User user;
	private Bot bot;
	private Console console;
	private Rules rules;
	private Information info;
	
	public PlayGame(User user, Bot bot, Console console) {
		this.user = user;
		this.console = console;
		this.bot = bot;
		rules = new Rules();
		info = new Information("info.txt");
	}
	public void meny() {
		int menyChoice;
		do {
			menyChoice = console.meny();
			
			if(menyChoice == 1) {
				newGame();
			}
			if(menyChoice == 2) {
				settings();
			}
			if(menyChoice == 3) {
				Statistics stats = user.getStatistics();
				console.presentStatistics(stats.getWins(), stats.getLosses());
			}
			if(menyChoice == 4) {
				load();
			}
			if(menyChoice == 5) {
				save();
			}
		}while(menyChoice != 6);
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
		reset();
		int bestOf = rules.getBestOf();
		int maxPoints = (bestOf/2)+1;
		
		for(int i = 0; i < bestOf; i++) {
			boolean validOption = false;
			do {
			validOption = getUserOption();
			}while(validOption == false);
			bot.setChoice();
			if(countWinner() != true) {
				i--;
			}
			console.presentProfileOption(user.getClass().getSimpleName(), user.getChoice());
			console.presentProfileOption(bot.getClass().getSimpleName(), bot.getChoice());
			console.presentScore(user.getName(), user.getScore(), bot.getName(), bot.getScore());
				
			if(user.getScore() == maxPoints || bot.getScore() == maxPoints) {
				break;
			}
			
		}winner();
			
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
		if(winner != null)
			{
			if(winner.equals(user.getName())) {
				user.gameResult("won");
			}
			else {
				user.gameResult("lost");
			}
			console.showWinner(winner);
		}
	}
	private String winnerName() {
		int userScore = user.getScore();
		int botScore = bot.getScore();
		if(userScore > botScore) {
			return user.getName();
		}
		return bot.getName();
	}	
	/*
	 * ask the console for the user's choice
	 */
	private boolean getUserOption() {
		String userChoice = console.askForInputOption();
		user.setChoice(userChoice);
		if(user.getChoice().equals(null)) {
			return false;
		}
		return true;
	}
	private void reset() {
		user.reset();
		bot.reset();
	}
	private void load() {
		try {
			info.load();
			user = info.getUser();
		} catch (FileNotFoundException e) {
			console.fileNotFound();
		}
	}
	private void save() {
		info.save(user);
	}
}
