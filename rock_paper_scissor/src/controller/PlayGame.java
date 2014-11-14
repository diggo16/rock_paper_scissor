package controller;

import view.Console;
import model.User;

public class PlayGame {
	
	private User user;
	private Console console;
	
	public PlayGame(User user) {
		this.user = user;
		console = new Console();
	}
	
	
	public void newGame() {
		getUserOption();
		console.closeScanner();
	}
	private void getUserOption() {
		String userChoice = console.askForInputOption();
		user.setChoice(userChoice);	
	}

}
