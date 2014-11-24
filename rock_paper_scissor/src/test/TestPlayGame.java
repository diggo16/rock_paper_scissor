package test;

import static org.junit.Assert.fail;

import java.util.Random;

import model.Bot;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import view.Console;
import controller.PlayGame;

public class TestPlayGame {

	private User user;
	private Bot bot;
	private Console console;
	private PlayGame pg;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		user = new User("user");
		bot  = new Bot();
		console = Mockito.mock(Console.class);
		Mockito.when(console.askForInputOption()).thenReturn("rock");
		pg = new PlayGame(user,bot,console);
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	 * test the function newGame
	 */
	@Test
	public void testNewGameAndWinner() {
		pg.newGame();
		boolean succeed = pg.showWinner();
		if(succeed == false) {
			fail();
		}		
	}
	@Test
	public void testConsoleCall() {
		pg.newGame();
		Mockito.verify(console).presentProfileOption("User","rock");
		
	}
	@Test
	public void testMeny() {
		console = new Console();
		pg = new PlayGame(user,bot,console);
		pg.meny();	
	}
	@Test
	public void testBestOf() {
		Mockito.when(console.askForRounds()).thenReturn(3);
		pg.settings();
		pg.newGame();
		if(user.getScore() != 2 || bot.getScore() != 2) {
			fail();
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
		Mockito.verify(console).showWinner("User");
		
	}
}