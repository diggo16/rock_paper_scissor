package test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Bot;
import model.Information;
import model.Rules;
import model.Statistics;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import controller.PlayGame;
import view.Console;


public class TestAll {
	
	private Console consoleMock;
	private Console console;
	private Information info;
	private int user1Wins,user1Losses;
	private User user;
	private Bot bot;
	private PlayGame pg;
	private Rules rules;
	private Random random;
	private String choice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		consoleMock = Mockito.mock(Console.class);
		console = new Console();
		
		info = new Information("info.txt");
		
		user1Wins = 3;
		user1Losses = 1;
		
		user = new User("user");
		bot  = new Bot();
		console = Mockito.mock(Console.class);
		Mockito.when(console.askForInputOption()).thenReturn("rock");
		pg = new PlayGame(user,bot,console);
		
		rules = new Rules();
		
		random = new Random();
		
	}
	@After
	public void tearDown() throws Exception {
	}
	/**
	 * Bot
	 */
	/*
	 * test set and get choice methods
	 */
	@Test
	public void testBotSetAndGetChoice() {
		Bot bot = new Bot();
		//test 10 times
		for(int i = 0; i < 10; i++) {
			bot.setChoice();
			String botChoice = bot.getChoice();
			List<String> options = new ArrayList<String>();
			options.add("rock");
			options.add("paper");
			options.add("scissor");
			assertEquals(options.get(options.indexOf(botChoice)),botChoice);
		}
	}
	/**
	 * console
	 */
	@Test
	public void testAskForInputOption() {
		String option = "rock";
		Mockito.when(consoleMock.askForInputOption()).thenReturn(option);
		
		String input = consoleMock.askForInputOption();
		assertEquals(option, input);
		consoleMock.closeScanner();
	}
	/*
	 * test to show the winner
	 */
	@Test
	public void testShowWinner() {
		console.showWinner(""); // should print out "tie!" in the console
		console.showWinner("user"); // should print out "user won!" in the console
		console.closeScanner();
	}
	/*
	 * test to present the the option
	 */
	@Test
	public void testPresentProfileOption() {	
		User user = new User("user");
		user.setChoice("rock");
		
		Bot bot = new Bot();
		bot.setChoice();
		System.out.print("User got rock=");
		console.presentProfileOption(user.getClass().getSimpleName(),user.getChoice());
		System.out.print("Bot got \"option\"=");
		console.presentProfileOption(bot.getClass().getSimpleName(),bot.getChoice());
		console.closeScanner();
	}
	/*
	 * test the meny
	 */
	@Test
	public void testConsoleMeny() {
		for(int k = 0; k<=3; k++) {
			Mockito.when(consoleMock.meny()).thenReturn(k);
			int choice = consoleMock.meny();
			int[] validNumbers = {1,2,3};		// every valid numbers in an array
			boolean ifValid = false;
			for(int i = 0; i < validNumbers.length; i++) {		// check if the return value was valid else fail the test
				if(choice == validNumbers[i]) {
					ifValid = true;
				}
			}			
			if(ifValid == false) {
				if(k != 0) {
				fail();
				}
			}
		}
	}
	/**
	 * Information
	 */
	/* 
	 * Test to save the information
	 */
	@Test
	public void testSave() {
		//user 1
		User user1 = new User("Name1");
		for(int i = 0; i < user1Wins; i++) {
			user1.gameResult("won");
		}
		user1.gameResult("lost");
		if(info.save(user1) == false) {
			fail();
		}
	}
	/*
	 * test to load the information
	 */
	@Test
	public void TestLoad() {
		try {
			info.load();
		} catch (FileNotFoundException e) {
			fail();
		}
		//user 1
		User user1 = info.getUser();
		assertEquals("Name1",user1.getName());
		Statistics userStats1 = user1.getStatistics();
		assertEquals(user1Wins,userStats1.getWins());
		assertEquals(user1Losses,userStats1.getLosses());
	}
	/**
	 * Play game
	 **/
	/*
	 * test several games with different best of numbers
	 */
	@Test
	public void testBestOf() {
		/*
		 * test best of 1, 3, 5, 7 and 9
		 */
		for(int i = 1 ; i <10; i = i + 2) {
			int round = i;
			int maxScore = round / 2 +1;
			Mockito.when(console.askForRounds()).thenReturn(round);
			pg.settings();
			pg.newGame();
			
			if(user.getScore() != maxScore && bot.getScore() != maxScore) {
				fail("");
			}
		}
	}
	@Test
	public void testWinner() {
		user.reset();
		bot.reset();
		for(int i = 0; i < 2; i++) {
			user.win();
		}
		bot.win();
		pg.winner();
		Mockito.verify(console).showWinner("user");
		
	}
	/**
	 * Test rules
	 */
	@Test
	public void testSetAndGetBestOf() {
		assertEquals(1,rules.getBestOf());
		rules.setBestOf(3);
		assertEquals(3,rules.getBestOf());
	}
	@Test
	public void testRulesWinner() {
		String rock = "rock",paper = "paper", scissor = "scissor";
		//test rock
		rules.Winner(rock,rock);
		rules.Winner(rock,paper);
		rules.Winner(rock,scissor);
		//test paper
		rules.Winner(paper,paper);
		rules.Winner(paper,scissor);
		rules.Winner(paper,rock);
		//test scissor
		rules.Winner(scissor,scissor);
		rules.Winner(scissor,rock);
		rules.Winner(scissor,paper);
	}
	@Test
	public void testSetAndGetChoice() {
		choice = "rock";
		user.setChoice(choice);
		assertEquals(choice,user.getChoice());
	}
	@Test
	public void testWrongAnswer() {
		choice = "rocking";
		user.setChoice(choice);
		assertEquals(null,user.getChoice());
	}
	@Test
	public void testScore() {
		int wins = random.nextInt(100);
		for(int i = 0 ; i < wins ; i++) {
		user.win();
		}
		assertEquals(wins,user.getScore());
	}
	@Test
	public void testWonAndLostGames() {
		int wins = random.nextInt(50), losses = random.nextInt(50);
		for(int i = 0; i < wins; i++) {
			user.gameResult("won");
		}
		for(int i = 0; i < losses; i++) {
			user.gameResult("lost");
		}
		Statistics stats = user.getStatistics();
		assertEquals(wins, stats.getWins());
		assertEquals(losses, stats.getLosses());
		
	}
/**
 * test console
 */
	@Test
	public void testOutputMessages() {
		console = new Console();
		//showWinner method
		String winner = "User";
		System.out.print("User won!:");
		console.showWinner(winner);
		//presentProfileOption method
		System.out.print("User got rock:");
		console.presentProfileOption(winner, "rock");
		//presentScore method
		System.out.print("User:5 bot:3:");
		console.presentScore(winner, 5, "bot", 3);
		//presentStatistics method
		System.out.print("Wins:5 Losses:3:");
		console.presentStatistics(5, 3);
		//fileNotFound method
		System.out.print("File not found!:");
		console.fileNotFound();
	}

}
